package com.supercopo.chamado.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supercopo.chamado.domain.LogSistema;
import com.supercopo.chamado.domain.Permissao;
import com.supercopo.chamado.domain.Usuario;
import com.supercopo.chamado.validation.usuario.UsuarioUpdate;

@UsuarioUpdate
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean status;// enum ok
	private String nome;
	private String login;
	private String email;
	private Integer tenantativo;
	private Integer gtenantativo;
	private String empresaativa;
	private Integer idEmpresaativa;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	private List<Permissao> permissoes;
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<LogSistema> logs = new ArrayList<LogSistema>();
	private List<EmpresaRetornUsuario> empresas = new ArrayList<EmpresaRetornUsuario>();
	@JsonIgnore
	private String senha;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Integer id, Boolean status, String nome, String login, String email, Integer tenantativo,
			Integer gtenantativo, String empresaativa, Integer idEmpresaativa, List<Permissao> permissoes,
			List<LogSistema> logs, List<EmpresaRetornUsuario> empresas, String senha) {
		super();
		this.id = id;
		this.status = status;
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.tenantativo = tenantativo;
		this.gtenantativo = gtenantativo;
		this.empresaativa = empresaativa;
		this.idEmpresaativa = idEmpresaativa;
		this.permissoes = permissoes;
		this.logs = logs;
		this.empresas = empresas;
		this.senha = senha;
	}

	public UsuarioDTO(Usuario usu) {
		this.id = usu.getId();
		this.nome = usu.getNome();
		this.login = usu.getLogin();
		// this.senha = usu.getSenha();
		this.tenantativo = usu.getTenantativo();
		this.status = usu.getStatus();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTenantativo() {
		return tenantativo;
	}

	public void setTenantativo(Integer tenantativo) {
		this.tenantativo = tenantativo;
	}

	public Integer getGtenantativo() {
		return gtenantativo;
	}

	public void setGtenantativo(Integer gtenantativo) {
		this.gtenantativo = gtenantativo;
	}

	public String getEmpresaativa() {
		return empresaativa;
	}

	public void setEmpresaativa(String empresaativa) {
		this.empresaativa = empresaativa;
	}

	public Integer getIdEmpresaativa() {
		return idEmpresaativa;
	}

	public void setIdEmpresaativa(Integer idEmpresaativa) {
		this.idEmpresaativa = idEmpresaativa;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public List<LogSistema> getLogs() {
		return logs;
	}

	public void setLogs(List<LogSistema> logs) {
		this.logs = logs;
	}

	public List<EmpresaRetornUsuario> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaRetornUsuario> empresas) {
		this.empresas = empresas;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
