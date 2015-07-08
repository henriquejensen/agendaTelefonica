package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;
//import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class PessoaController {
	
	private static EnderecoDAO endereco = new EnderecoDAO();
	private static PessoaDAO pessoa = new PessoaDAO();
	private static NumeroTelefoneDAO telefoneBanco = new NumeroTelefoneDAO();
	
	public String home() {
		
		return "Agenda Online";
	}
	
	public List<String> listaContatos() {
		
		List<String> nomes = new ArrayList<String>();
		nomes.add("Henrique");
		nomes.add("Pro");
		nomes.add("Jarbas");
		
		return nomes;
	}
	
	public int inserirContato(Pessoa novaPessoa, ArrayList<NumeroTelefone> novoTelefone) {
		
		/**insere o endereço no banco e retorna o id deste endereço para ter o relacionamento
		 * com a tabela pessoa*/
		Endereco idEndereco = endereco.inserirEnderecoBanco(novaPessoa.getEndereco());		
		novaPessoa.setEndereco(idEndereco);
		
		Pessoa idPessoa = pessoa.inserirPessoaBanco(novaPessoa);
					
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
