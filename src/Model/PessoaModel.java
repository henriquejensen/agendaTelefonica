package Model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PessoaModel {	
	
	@Id @GeneratedValue
	private Long id;
	private String primeiroNome;
	private String endereco;
	private String ultimoNome;
	private ArrayList telefones = new ArrayList();
	
	public ArrayList getTelefones() {
		return telefones;
	}

	public void setTelefone(NumeroTelefoneModel telefone) {
		this.telefones.add(telefones);
	}

	public void setNome(String nome){
		String[] array = nome.split(" ");
		this.primeiroNome = array[0];
		this.ultimoNome = array[nome.length()-1];
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return primeiroNome;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

}
