package Controller;

import java.util.Scanner;
import Model.*;

public class PessoaController {

	private static Scanner ler;
	private static int entrada;

	public static void main(String[] args) {
		menu();		
	}	
	
	public static void menu(){
		do{
			System.out.println(".... Cadastro de pessoas .....");
			System.out.println("1 - Cadastro de novo contato: \n"
							 + "2 - Mostrar contatos cadastrados: \n"
							 + "0 - entrada");
			System.out.print("Digite uma opção: ");
			entrada = ler.nextInt();
			System.out.print("\n");
			
			switch(entrada){
				case 1:
					inserirContato();
					break;
				case 2:
					break;
				case 0:
					break;
				default:
					System.out.println("Entrada Inválida, digite novamente");				
			}
		}while(entrada != 0);		
	}

}
