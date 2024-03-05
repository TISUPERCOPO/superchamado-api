package com.supercopo.chamado.domain.dto.flat;

import java.time.OffsetDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.supercopo.chamado.domain.Categoria;
import com.supercopo.chamado.domain.Chamado;
import com.supercopo.chamado.domain.Setor;
import com.supercopo.chamado.domain.UrgenciaEnum;

public class ChamadoFlat {

	private Integer id;
	private String descricao;
	private String titulo;

	private Setor setor;
	private String descricaoset;

	private Categoria categoria;
	private String descricaocat;
	private Boolean status;
	private String urgencia;

	private OffsetDateTime datagravacao;
	private String loginusuario;

	public ChamadoFlat() {
	}

	public ChamadoFlat(Integer id, String descricao, String titulo, Setor setor, String descricaoset,
			Categoria categoria, String descricaocat, Boolean status, String urgencia, OffsetDateTime datagravacao,
			String loginusuario) {
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.setor = setor;
		this.descricaoset = descricaoset;
		this.categoria = categoria;
		this.descricaocat = descricaocat;
		this.status = status;
		this.urgencia = urgencia;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
	}

	public ChamadoFlat(Chamado obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.titulo = obj.getTitulo();
		this.status = obj.getStatus();
		this.loginusuario = obj.getLogs().getLoginusuario();
		this.datagravacao = obj.getLogs().getDatagravacao();
		this.categoria = obj.getCategoria();
		this.setor = obj.getSetor();
		this.descricaocat = obj.getCategoria().getDescricao();
		this.descricaoset = obj.getSetor().getDescricao();
		this.urgencia = obj.getUrgencia();

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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricaoset() {
		return descricaoset;
	}

	public void setDescricaoset(String descricaoset) {
		this.descricaoset = descricaoset;
	}

	public String getDescricaocat() {
		return descricaocat;
	}

	public void setDescricaocat(String descricaocat) {
		this.descricaocat = descricaocat;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

}
