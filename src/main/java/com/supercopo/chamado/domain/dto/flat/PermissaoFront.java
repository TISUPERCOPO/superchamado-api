package com.supercopo.chamado.domain.dto.flat;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supercopo.chamado.domain.Classepermissao;

public class PermissaoFront {

	private int id;
	private String nome;
	private PermissoesFlat permission;

	@JsonIgnore
	@ManyToOne
	private Classepermissao classepermissao;

	public PermissaoFront() {
	}

	public PermissaoFront(int id, String nome, PermissoesFlat permission, Classepermissao classepermissao) {
		this.id = id;
		this.nome = nome;
		this.permission = permission;
		this.classepermissao = classepermissao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PermissoesFlat getPermission() {
		return permission;
	}

	public void setPermission(PermissoesFlat permission) {
		this.permission = permission;
	}

	public Classepermissao getClassepermissao() {
		return classepermissao;
	}

	public void setClassepermissao(Classepermissao classepermissao) {
		this.classepermissao = classepermissao;
	}

}
