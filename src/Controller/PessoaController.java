package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class PessoaController {
	
	private final EnderecoDAO enderecoBanco;
	private final PessoaDAO pessoaBanco;
	private final NumeroTelefoneDAO telefoneBanco;
	private final Result result;
	private final Validator validator;
	
	
	public PessoaController(PessoaDAO novaPessoa, NumeroTelefoneDAO novoTelefone,
								EnderecoDAO novoEndereco, Result result, Validator validator) {
		
		this.enderecoBanco = novoEndereco;
		this.pessoaBanco = novaPessoa;
		this.telefoneBanco = novoTelefone;
		this.result = result;
		this.validator = validator;
	}
	
	public String home() {
		
		return "Agenda Online";
	}
	
	public void adiciona(Pessoa pessoa, Endereco endereco, List<NumeroTelefone> telefone) {
		
		if(pessoa.getNome() == null || pessoa.getNome().length() < 3) {
			
			validator.add(new ValidationMessage("Nome é obrigatório e precisa ter mais de 3 letras",
			        "pessoa.nome"));
		}
		
		if(telefone.get(0).getNumero() == null) {
			
			validator.add(new ValidationMessage("Pelo menos um telefone deverá ser cadastrado",
			        "telefone.numero"));
		}
				
		validator.onErrorUsePageOf(PessoaController.class).formulario();
		
		pessoa.setEndereco(endereco);
				
		enderecoBanco.inserirEnderecoBanco(endereco);
		pessoaBanco.inserirPessoaBanco(pessoa);
		
		for(NumeroTelefone tel:telefone) {
			
			if(tel != null) {
				
				tel.setPessoa(pessoa);
				telefoneBanco.inserirTelefoneBanco(tel);
			}	
		}
		result.redirectTo(this).listaContatos();
	}
	
	public List<Pessoa> listaContatos() {
		
		List<Pessoa> nomes = new ArrayList<Pessoa>();
				
		nomes = pessoaBanco.carrega(null);
				
		return nomes;
	}
	
	public void inserirContato(Pessoa novaPessoa, ArrayList<NumeroTelefone> novoTelefone) {
		
		/**insere o endereço no banco e retorna o id deste endereço para ter o relacionamento
		 * com a tabela pessoaBanco*/
		Endereco idEndereco = enderecoBanco.inserirEnderecoBanco(novaPessoa.getEndereco());		
		novaPessoa.setEndereco(idEndereco);
		
		Pessoa idPessoa = pessoaBanco.inserirPessoaBanco(novaPessoa);
					
		for(int i=0; i < novoTelefone.size(); i++) {
			novoTelefone.get(i).setPessoa(idPessoa);		
			telefoneBanco.inserirTelefoneBanco(novoTelefone.get(i));
		}
	}
	
	public void formulario() {
		
	}
	
	public List<Pessoa> atualizar() {
		
		return this.listaContatos();
	}
	
	public Pessoa edita(Long id) {
	 
		List<Pessoa> pessoa = pessoaBanco.carrega(id);
				
		return pessoa.get(0);
	}
	
	public void altera(Pessoa pessoa) {	
		
		List<Pessoa> oldPessoa = pessoaBanco.carrega(pessoa.getId());
		
		pessoa.setId(oldPessoa.get(0).getId());
		pessoa.getEndereco().setIdEndereco(oldPessoa.get(0).getEndereco().getIdEndereco());
				
		enderecoBanco.atualiza(pessoa.getEndereco());
		pessoaBanco.atualiza(pessoa);
	    result.redirectTo(PessoaController.class).home();
	}
	
	public List<Pessoa> remover(Long id) {
				
		return this.listaContatos();
	}
	
	public Pessoa confirmacaoRemover(Long id) {
		
		List<Pessoa> pessoa = pessoaBanco.carrega(id);
		
		return pessoa.get(0);
	}
	
	public void excluir(Long id) {
		
		List<Pessoa> pessoa = pessoaBanco.carrega(id);
		pessoa.get(0).setDeletadoBanco(true);
		pessoaBanco.remove(pessoa.get(0));
		result.redirectTo(PessoaController.class).listaContatos();
	}
	
	public List<Pessoa> atualizarTelefone() {
		
		return this.listaContatos();
	}
	
	public List<NumeroTelefone> editaTelefone(long id) {
		
		List<NumeroTelefone> telefones = new ArrayList<NumeroTelefone>();
		telefones = telefoneBanco.carrega(id);
		
		return telefones;
	}
	
	public String alteraTelefone(List<NumeroTelefone> telefone) {
				
		for(NumeroTelefone tel:telefone) {
			
			telefoneBanco.atualizarTelefoneBanco(tel);
		}
		
		return "Alterado com sucesso";
	}
	
	public void telaBuscaContato() {
		
	}
	
	public List<Pessoa> buscaContato(String nome) {
		
		return pessoaBanco.busca(nome);
	}
	
}
