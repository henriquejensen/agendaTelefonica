package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;
//import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class PessoaController {
	
	private final EnderecoDAO enderecoBanco;
	private final PessoaDAO pessoaBanco;
	private final NumeroTelefoneDAO telefoneBanco;
	private final Result result;
	
	
	public PessoaController(PessoaDAO novaPessoa, NumeroTelefoneDAO novoTelefone, EnderecoDAO novoEndereco, Result result) {
		
		this.enderecoBanco = novoEndereco;
		this.pessoaBanco = novaPessoa;
		this.telefoneBanco = novoTelefone;
		this.result = result;
	}
	
	public String home() {
		
		return "Agenda Online";
	}
	
	public void adiciona(Pessoa pessoa, Endereco endereco, NumeroTelefone telefone) {
		
		telefone.setPessoa(pessoa);
		pessoa.setEndereco(endereco);
				
		enderecoBanco.inserirEnderecoBanco(endereco);
		pessoaBanco.inserirPessoaBanco(pessoa);		
		telefoneBanco.inserirTelefoneBanco(telefone);		
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
	
	public Pessoa edita(Long id) {
	 
		List<Pessoa> pessoa = pessoaBanco.carrega(id);
				
		return pessoa.get(0);
	}
	
	public void altera(Pessoa pessoa) {
	
		System.out.println(pessoa.getEndereco());
		
		//List<Endereco> endereco = enderecoBanco.carrega(pessoa.);
		
		
		
		/*pessoa.setEndereco(endereco.get(0));*/
	    /*pessoaBanco.atualiza(pessoa);
	    result.redirectTo(PessoaController.class).home();*/
	}
	
	public void remove(Long id) {
		
		List<Pessoa> pessoa = pessoaBanco.carrega(id);		
		pessoaBanco.remove(pessoa.get(0));
		result.redirectTo(PessoaController.class).listaContatos();
	}	
}
