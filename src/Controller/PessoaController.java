package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.caelum.vraptor.Resource;
import Model.*;

@Resource
public class PessoaController {
	
	private static EnderecoDAO endereco = new EnderecoDAO();
	private static PessoaDAO pessoa = new PessoaDAO();
	private static NumeroTelefoneDAO telefoneBanco = new NumeroTelefoneDAO();
		
	public static boolean inserirContato(Pessoa novaPessoa, ArrayList<NumeroTelefone> novoTelefone){
		
		/**insere o endereço no banco e retorna o id deste endereço para ter o relacionamento
		 * com a tabela pessoa*/
		Endereco idEndereco = endereco.inserirEnderecoBanco(novaPessoa.getEndereco());		
		novaPessoa.setEndereco(idEndereco);
		
		Pessoa idPessoa = pessoa.inserirPessoaBanco(novaPessoa);
					
		for(int i=0; i < novoTelefone.size(); i++) {
			novoTelefone.get(i).setPessoa(idPessoa);		
			telefoneBanco.inserirTelefoneBanco(novoTelefone.get(i));
		}		
		
		return true;
	}

}
