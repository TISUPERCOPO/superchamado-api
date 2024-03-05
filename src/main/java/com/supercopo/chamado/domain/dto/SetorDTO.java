package com.supercopo.chamado.domain.dto;

import com.supercopo.chamado.domain.Setor;

public class SetorDTO {

	private Integer id;
	private String descricao;
	private Boolean status = Boolean.TRUE;

	public SetorDTO() {
	}

	public SetorDTO(Integer id, String descricao, Boolean status) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
	}
	
	public SetorDTO(Setor obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.status = obj.getStatus();
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

}
