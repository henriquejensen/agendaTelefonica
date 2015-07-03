package Model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {	
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private Endereco endereco;
	private ArrayList telefones = new ArrayList();
	
	public ArrayList getTelefones() {
		return telefones;
	}

	public void setTelefone(NumeroTelefone telefone) {
		this.telefones.add(telefones);
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
