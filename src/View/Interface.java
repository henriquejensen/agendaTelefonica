package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.PessoaController;
import Model.*;

public class Interface {
		
	private static Scanner ler = new Scanner(System.in);
	private static int entrada;
	private static int cadastro=1;
	private static Pessoa pessoa = new Pessoa();

	public static void main(String[] args) {
		menu();		
	}	
	
	public static String menu(){
		
			do{
				System.out.println(".... Cadastro de pessoas .....");
				System.out.println("1 - Cadastro de novo contato: \n"
								 + "2 - Mostrar contatos cadastrados: \n"
								 + "0 - Sair do programa: \n");
				System.out.print("Digite uma opção: ");
				entrada = ler.nextInt();
				ler.nextLine();
				System.out.println();
				
				switch(entrada){
					case 1:
						NumeroTelefone telefone = new NumeroTelefone();
						ArrayList<NumeroTelefone> listaTelefone = new ArrayList<NumeroTelefone>();
						Endereco endereco = new Endereco();
						System.out.print("Digite o nome completo: ");						
						pessoa.setNome(ler.nextLine());
						System.out.println();
						
						System.out.println("Digite o endereço... ");
						System.out.print("rua: ");
						endereco.setRua(ler.nextLine());
						System.out.print("numero: ");
						endereco.setNumeroCasa(ler.nextInt());
						ler.nextLine();
						System.out.print("bairro: ");
						endereco.setBairro(ler.nextLine());
						System.out.print("estado: ");
						endereco.setEstado(ler.nextLine());
						pessoa.setEndereco(endereco);
						
						System.out.println();
						do{							
							System.out.println("Digite 1 para cadastrar telefone\n"
									 + "Digite 0 para sair: ");
							cadastro = ler.nextInt();
							
							if(cadastro == 1){
								System.out.print("Digite o ddd: ");
								telefone.setDdd(ler.next());
								System.out.println();
								System.out.print("Digite o numero: ");
								telefone.setNumero(ler.next());
								telefone.setPessoa(pessoa);
								listaTelefone.add(telefone);
								System.out.println();
							}
						}while(cadastro!=0);
						PessoaController.inserirContato(pessoa, listaTelefone);
						break;
					case 2:
						break;
					case 0:
						break;
					default:
						System.out.println("Entrada Inválida, digite novamente");				
				}
			}while(entrada != 0);
		return "Cadastro realizado com sucesso";
	}

}
