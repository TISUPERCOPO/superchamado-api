package com.supercopo.chamado.domain.dto.flat;

import java.time.OffsetDateTime;
import java.util.List;

import com.supercopo.chamado.domain.Usuario;
import com.supercopo.chamado.domain.dto.EmpresaUsu;

public class UsuarioFlat {

	private Integer id;
	private Boolean status = Boolean.TRUE;
	private String nome;
	private String login;
	private String perfil;
	private String senha;
	private OffsetDateTime datagravacao;
	private String loginusuario;
	private List<PermissaoFront> permissoes;
	private List<EmpresaUsu> empresas;

	public UsuarioFlat(Usuario usu) {
		this.id = usu.getId();
		this.status = usu.getStatus();
		this.nome = usu.getNome();
		this.login = usu.getLogin();
		// this.senha = senha;
		this.datagravacao = usu.getLogs().getDatagravacao();
		this.loginusuario = usu.getLogs().getLoginusuario();
		// this.permissoes = permissoes;
	}

	public UsuarioFlat() {
	}

	public UsuarioFlat(Integer id, Boolean status, String nome, String login, String perfil, String senha,
			OffsetDateTime datagravacao, String loginusuario, List<PermissaoFront> permissoes,
			List<EmpresaUsu> empresas) {
		this.id = id;
		this.status = status;
		this.nome = nome;
		this.login = login;
		this.perfil = perfil;
		this.senha = senha;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
		this.permissoes = permissoes;
		this.empresas = empresas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public List<PermissaoFront> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoFront> permissoes) {
		this.permissoes = permissoes;
	}

	public List<EmpresaUsu> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaUsu> empresas) {
		this.empresas = empresas;
	}

}
