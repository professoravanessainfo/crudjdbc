package entities;

import java.util.UUID;

public class Pessoa {

	private UUID id;
	private String nome;
	private String cpf;
	private String telefone;

	//por padrão o método construtor deve ser inserido logo após a lista de atributos da classe
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	//lista de métodos de encapsulamento
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
