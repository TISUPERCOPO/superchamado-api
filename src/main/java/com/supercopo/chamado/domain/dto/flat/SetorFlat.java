package com.supercopo.chamado.domain.dto.flat;

import java.time.OffsetDateTime;

import com.supercopo.chamado.domain.Setor;

public class SetorFlat {

	private Integer id;
	private String descricao;
	private Boolean status = Boolean.TRUE;
	private OffsetDateTime datagravacao;
	private String loginusuario;

	public SetorFlat() {
	}

	public SetorFlat(Integer id, String descricao, Boolean status, OffsetDateTime datagravacao, String loginusuario) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
	}

	public SetorFlat(Setor obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.status = obj.getStatus();
		this.loginusuario = obj.getLogs().getLoginusuario();
		this.datagravacao = obj.getLogs().getDatagravacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public OffsetDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(OffsetDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

}
