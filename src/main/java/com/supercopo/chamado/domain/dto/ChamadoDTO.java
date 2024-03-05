package com.supercopo.chamado.domain.dto;

import com.supercopo.chamado.domain.Chamado;

public class ChamadoDTO {

	private Integer id;
	private String descricao;
	private String titulo;

	private Integer setorid;
	private String descricaosetor;

	private Integer categoriaid;
	private String descricaocategoria;
	private Boolean status;

	public ChamadoDTO() {
	}

	public ChamadoDTO(Integer id, String descricao, String titulo, Integer setorid, String descricaosetor,
			Integer categoriaid, String descricaocategoria, Boolean status) {
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.setorid = setorid;
		this.descricaosetor = descricaosetor;
		this.categoriaid = categoriaid;
		this.descricaocategoria = descricaocategoria;
		this.status = status;
	}
	
	public ChamadoDTO(Chamado obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.titulo = obj.getTitulo();
		this.status = obj.getStatus();
		this.setorid = obj.getSetor().getId();
		this.descricaosetor = obj.getSetor().getDescricao();
		this.categoriaid = obj.getCategoria().getId();
		this.descricaocategoria = obj.getCategoria().getDescricao();
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getSetorid() {
		return setorid;
	}

	public void setSetorid(Integer setorid) {
		this.setorid = setorid;
	}

	public String getDescricaosetor() {
		return descricaosetor;
	}

	public void setDescricaosetor(String descricaosetor) {
		this.descricaosetor = descricaosetor;
	}

	public Integer getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(Integer categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getDescricaocategoria() {
		return descricaocategoria;
	}

	public void setDescricaocategoria(String descricaocategoria) {
		this.descricaocategoria = descricaocategoria;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
