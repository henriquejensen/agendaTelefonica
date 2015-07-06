package Model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {	
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	@OneToOne
	private Endereco endereco;
	boolean deletadoBanco = false;
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
	
	public void setId(Long id) {
		this.id = id;
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

	public boolean isDeletadoBanco() {
		return deletadoBanco;
	}

	public void setDeletadoBanco(boolean deletadoBanco) {
		this.deletadoBanco = deletadoBanco;
	}

}
