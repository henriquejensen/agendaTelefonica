package Controller;

import java.util.Scanner;
import Model.*;

public class PessoaController {

	private static PessoaDAO pessoaBanco = new PessoaDAO();
	private static EnderecoDAO enderecoBanco = new EnderecoDAO();

	public static void inserirContato(Pessoa novaPessoa){
		/*procura o nome da pessoa no banco não cadastrar duas com o mesmo nome*/
		Endereco idEndereco = enderecoBanco.inserirEnderecoBanco(novaPessoa.getEndereco());
		novaPessoa.setEndereco(idEndereco);
		pessoaBanco.inserirPessoaBanco(novaPessoa);
		
		/**
		 * pegar o id que retorna da gravacao da pessoa quando faz a gravacao dela
		 * passar esse id para cada telefone que for gravado
		 * */
		
		/**procura o endereco no banco, se ja esta cadastrado pega o id deste,
		 * senão cadastra o endereco com o novo id
		EnderecoDAO.inserirEnderecoBanco(novaPessoa);		
		
		/**cadastra os telefones do novo contato e pega o id
		NumeroTelefoneDAO.inserirTelfoneBanco(novaPessoa);*/
	}

}
