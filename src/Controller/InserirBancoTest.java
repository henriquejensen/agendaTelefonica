package controller;

import static org.testng.AssertJUnit.assertEquals;
import java.util.ArrayList;
import model.*;
import org.testng.annotations.Test;
import view.Interface;

public class InserirBancoTest{
	
	private static Pessoa pessoa = new Pessoa();
	private static Endereco endereco = new Endereco();
	private static NumeroTelefone telefone = new NumeroTelefone();
	private static ArrayList<NumeroTelefone> listaTelefone = new ArrayList<NumeroTelefone>();
	private static EnderecoDAO enderecoBanco;
	private static PessoaDAO pessoaBanco;
	private static NumeroTelefoneDAO telefoneBanco;
	private static PessoaController inserir = new PessoaController(pessoaBanco, telefoneBanco, enderecoBanco, null);
	
	@Test
	public void TestInserirNoBanco(){		
		
		pessoa.setNome("Henrique Jensen");
		
		endereco.setRua("Avenida das Flores");
		endereco.setNumeroCasa(157);
		endereco.setBairro("Capão Redondo");
		endereco.setEstado("MG");
		pessoa.setEndereco(endereco);
		
		telefone.setDdd("51");
		telefone.setNumero("555-4404");
		telefone.setPessoa(pessoa);
		
		listaTelefone.add(telefone);
		
		pessoa.setDeletadoBanco(false);
		
		assertEquals(1, inserir.inserirContato(pessoa, listaTelefone));
	}
	
	@Test
	public void TestInserirNoBancoDoisTelefones(){	
		
		telefone = new NumeroTelefone();
		pessoa = new Pessoa();
		endereco = new Endereco();
		
		pessoa.setNome("Hérion");
		
		endereco.setRua("Rua do contra");
		endereco.setNumeroCasa(159);
		endereco.setBairro("Siri Cascudo");
		endereco.setEstado("SP");
		pessoa.setEndereco(endereco);
		
		telefone.setDdd("35");
		telefone.setNumero("9638-5274");
		telefone.setPessoa(pessoa);
		
		listaTelefone.add(telefone);
		
		telefone = null;
		telefone = new NumeroTelefone();
		
		telefone.setDdd("51");
		telefone.setNumero("9999-11111");
		telefone.setPessoa(pessoa);		
		
		listaTelefone.add(telefone);
		
		pessoa.setDeletadoBanco(false);
		
		assertEquals(1, inserir.inserirContato(pessoa, listaTelefone));				
	}
	
	@Test
	public void TestInserirChamandoInterface(){
		
		assertEquals("Cadastro realizado com sucesso", Interface.menu());
	}
	
	@Test
	public void TestChamadaPaginaHome() {
		
		assertEquals("Agenda Online", inserir.home());
	}
	
	/*@Test
	public void TestListarContatosPagina() {
		
		List<String> nomes = new ArrayList<String>();
		nomes.add("Henrique");
		nomes.add("Pro");
		nomes.add("Jarbas");
		
		assertEquals(nomes, inserir.listaContatos());
	}*/
	
	

	/*@Test
	public static void TestRemoverContatoBanco(){
		
		pessoa = new Pessoa();
		
		pessoa.setNome("Hérion");
		
		assertEquals(true, PessoaController.removerContato(pessoa));
	}*/
}
