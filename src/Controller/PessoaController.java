package Controller;

import java.util.Scanner;
import Model.*;

public class PessoaController {

	public static void inserirContato(Pessoa novaPessoa){
		/*procura o nome da pessoa no banco não cadastrar duas com o mesmo nome*/
		PessoaDAO.inserirPessoaBanco(novaPessoa.getId(), novaPessoa.getNome());
		
		/*procura o endereco no banco, se ja esta cadastrado pega o id deste,
		 * senão cadastra o endereco com o novo id*/
		EnderecoDAO.inserirEnderecoBanco(novaPessoa.getEndereco());		
		
		/*cadastra os telefones do novo contato e pega o id*/
		NumeroTelefoneDAO.inserirTelfoneBanco(novaPessoa.getTelefones());
	}

}
