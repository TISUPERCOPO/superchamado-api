package com.supercopo.chamado.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class UsuarioEmpresaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa emrpesa;

	public UsuarioEmpresaPK() {
	}

	public UsuarioEmpresaPK(Usuario usuario, Empresa emrpesa) {
		this.usuario = usuario;
		this.emrpesa = emrpesa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmrpesa() {
		return emrpesa;
	}

	public void setEmrpesa(Empresa emrpesa) {
		this.emrpesa = emrpesa;
	}

}
