package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;
//import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class PessoaController {
	
	private final EnderecoDAO endereco;
	private final PessoaDAO pessoaBanco;
	private final NumeroTelefoneDAO telefoneBanco;
	
	
	public PessoaController(PessoaDAO novaPessoa, NumeroTelefoneDAO novoTelefone, EnderecoDAO novoEndereco) {
		
		this.endereco = novoEndereco;
		this.pessoaBanco = novaPessoa;
		this.telefoneBanco = novoTelefone;
	}
	
	public String home() {
		
		return "Agenda Online";
	}
	
	public List<Pessoa> listaContatos() {
		
		List<Pessoa> nomes = new ArrayList<Pessoa>();
		
		/*nomes.add("Henrique");
		nomes.add("Pro");
		nomes.add("Jarbas");*/
		
		nomes = pessoaBanco.listaPessoaBanco();
		
		/*for (int i = 0; i < nomes.size(); i++) {
			
			System.out.println(nomes.get(i).getNome());
			System.out.println(nomes.get(i).getId());
			System.out.println(nomes.get(i).getEndereco().getRua());
		}*/
		
		return nomes;
	}
	
	public int inserirContato(Pessoa novaPessoa, ArrayList<NumeroTelefone> novoTelefone) {
		
		/**insere o endereço no banco e retorna o id deste endereço para ter o relacionamento
		 * com a tabela pessoaBanco*/
		Endereco idEndereco = endereco.inserirEnderecoBanco(novaPessoa.getEndereco());		
		novaPessoa.setEndereco(idEndereco);
		
		Pessoa idPessoa = pessoaBanco.inserirPessoaBanco(novaPessoa);
					
		for(int i=0; i < novoTelefone.size(); i++) {
			novoTelefone.get(i).setPessoa(idPessoa);		
			telefoneBanco.inserirTelefoneBanco(novoTelefone.get(i));
		}		
		return 1;
	}
	
	/*public static boolean removerContato(Pessoa removerPessoa){
		PessoaDAO.removerPessoaBanco(removerPessoa);
		return true;
	}*/
	
	/*public static boolean buscarContato(Pessoa comparaPessoa) {
		
		if(PessoaDAO.buscarContato(comparaPessoa))
			return true;
		
		return false;
	}*/
	
}
