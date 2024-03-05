package com.supercopo.chamado.domain.dto.rel;

import com.supercopo.chamado.domain.Usuario;

public class UsuRel {

	private String nome;
	private String login;
	private String status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UsuRel(String nome, String login, String status) {
		super();
		this.nome = nome;
		this.login = login;
		this.status = status;
	}

	public UsuRel(Usuario usu) {
		this.nome = usu.getNome();
		this.login = usu.getLogin();
		Boolean status = usu.getStatus();
		if (status) {
			this.status = "Ativo";
		} else {
			this.status = "Inativo";
		}

	}

}