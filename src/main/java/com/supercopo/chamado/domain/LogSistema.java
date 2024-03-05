package com.supercopo.chamado.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LogSistema implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String comando;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss:SSS")
	@Column(columnDefinition = "datetime")
	private OffsetDateTime datagravacao;
	private String loginusuario;
	private Boolean status;
	@JsonIgnore
	@ManyToOne
	private Tenant tenant;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public OffsetDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(OffsetDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String loginusuario) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
		this.status = true;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "permissao_id")
	private Permissao permissao;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sac_id")
	private Sac sac;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "setor_id")
	private Setor setor;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "chamado_id")
	private Chamado chamado;

	public LogSistema() {

	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Empresa empresa) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.empresa = empresa;
		this.status = true;
	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Usuario usu) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.usuario = usu;
		this.status = true;
	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Permissao usu) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.permissao = usu;
		this.status = true;
	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Sac sac) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.sac = sac;
		this.status = true;
	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Setor setor) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.setor = setor;
		this.status = true;
	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao,
			Categoria categoria) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.categoria = categoria;
		this.status = true;
	}

	public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Chamado chamado) {
		this.id = id;
		this.loginusuario = usuarioLogado;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.chamado = chamado;
		this.status = true;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sac getSac() {
		return sac;
	}

	public void setSac(Sac sac) {
		this.sac = sac;
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

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

}