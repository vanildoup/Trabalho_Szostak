package edu.up.br.exemplo.model;

import java.io.Serializable;

public class ClienteBean implements Serializable 
{
	private int id;
	private String endereco;
	private String cep;
	private String nome;
	private String cpf;
	private String nickname;
	private String password;
	private boolean isAdmin;
	
	public ClienteBean(){}
	
		public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	public String getNickname() {
		if( nickname == null ) {
			nickname = "";
		}
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	protected String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		if( endereco == null ) {
			endereco = "";
		}
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		if( cep == null ) {
			cep = "";
		}
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNome() {
		if( nome == null ) {
			nome = "";
		}
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		if( cpf == null ) {
			cpf = "";
		}
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
