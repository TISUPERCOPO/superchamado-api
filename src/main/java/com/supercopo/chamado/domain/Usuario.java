package com.supercopo.chamado.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supercopo.chamado.domain.dto.flat.PermissaoFront;
import com.supercopo.chamado.domain.dto.flat.UsuarioFlat;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String login;
	@JsonIgnore
	private String senha;
	private Boolean status = Boolean.TRUE;

	private Integer tenantativo;
	private Integer gtenantativo;

	@ManyToOne
	private Tenant tenant;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	private List<Permissao> permissoes = new ArrayList<Permissao>();

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Usuario() {
	}

	public Usuario(Integer id, String nome, String login, String senha, Boolean status, Integer tenantativo,
			Integer gtenantativo, Tenant tenant, List<Permissao> permissoes, List<LogSistema> logs) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.tenantativo = tenantativo;
		this.gtenantativo = gtenantativo;
		this.tenant = tenant;
		this.permissoes = permissoes;
		this.logs = logs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public void addLogs(LogSistema log) {
		logs.add(log);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public LogSistema getLogs() {
		Integer codigo = 0;
		Integer indice = -1;
		LogSistema ultimo = new LogSistema();
		for (int i = 0; i < logs.size(); i++) {
			if (codigo < logs.get(i).getId()) {
				codigo = logs.get(i).getId();
				indice = i;
			}
		}
		if (indice == -1) {
			return ultimo;
		} else {
			return ultimo = logs.get(indice);
		}

	}

	public Usuario(Usuario usuAtual, UsuarioFlat obj, Tenant t) {
		this.id = usuAtual.getId();
		this.status = obj.getStatus();
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		this.senha = usuAtual.getSenha();
		transformarPermisaoFlat(obj.getPermissoes());

	}

	public Usuario(Usuario usuAtual, UsuarioFlat obj) {
		this.id = usuAtual.getId();
		this.status = obj.getStatus();
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		this.senha = usuAtual.getSenha();
		transformarPermisaoFlat(obj.getPermissoes());

	}

	public void setLogs(List<LogSistema> logs) {
		this.logs = logs;
	}

	private void transformarPermisaoFlat(List<PermissaoFront> permissoes2) {
		for (PermissaoFront pf : permissoes2) {
			switch (pf.getNome()) {

			case "Usuario":
				classePermissaoFlatUsuario(pf);
				break;
			case "Relatório":
				classePermissaoFlatRelatorio(pf);
				break;
			case "Empresa":
				classePermissaoFlatEmpresa(pf);
				break;
			case "Sac":
				classePermissaoFlatSac(pf);
				break;
			case "Setor":
				classePermissaoFlatSetor(pf);
				break;
			case "Categoria":
				classePermissaoFlatCategoria(pf);
				break;
		case "Chamado":
			classePermissaoFlatChamado(pf);
			break;
		
		}

		}

	}

	private void classePermissaoFlatEmpresa(PermissaoFront pf) {
		if (pf.getPermission().getCreate()) {
			Permissao c = new Permissao(1, "C_EMP");
			this.permissoes.add(c);
		}
		;
		if (pf.getPermission().getUpdate()) {
			Permissao u = new Permissao(2, "U_EMP");
			this.permissoes.add(u);
		}
		;
		if (pf.getPermission().getDelete()) {
			Permissao d = new Permissao(3, "D_EMPD");
			this.permissoes.add(d);
		}
		;
		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(4, "R_EMP");
			this.permissoes.add(r);
		}
		;
		if (pf.getPermission().getStatus()) {
			Permissao s = new Permissao(5, "S_EMP");
			this.permissoes.add(s);
		}
		;

	}

	private void classePermissaoFlatUsuario(PermissaoFront pf) {

		if (pf.getPermission().getCreate()) {
			Permissao c = new Permissao(6, "C_USU");
			this.permissoes.add(c);
		}
		;
		if (pf.getPermission().getUpdate()) {
			Permissao u = new Permissao(7, "U_USU");
			this.permissoes.add(u);
		}
		;
		if (pf.getPermission().getDelete()) {
			Permissao d = new Permissao(8, "D_USU");
			this.permissoes.add(d);
		}
		;
		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(9, "R_USU");
			this.permissoes.add(r);
		}

		;
		if (pf.getPermission().getStatus()) {
			Permissao s = new Permissao(10, "S_USU");
			this.permissoes.add(s);
		}
		;
	}

	private void classePermissaoFlatRelatorio(PermissaoFront pf) {

		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(11, "R_REL");
			this.permissoes.add(r);
		}
		;

	}

	private void classePermissaoFlatSac(PermissaoFront pf) {

		if (pf.getPermission().getCreate()) {
			Permissao c = new Permissao(12, "C_SAC");
			this.permissoes.add(c);
		}
		;
		if (pf.getPermission().getUpdate()) {
			Permissao u = new Permissao(13, "U_SAC");
			this.permissoes.add(u);
		}
		;
		if (pf.getPermission().getDelete()) {
			Permissao d = new Permissao(14, "D_SAC");
			this.permissoes.add(d);
		}
		;
		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(15, "R_SAC");
			this.permissoes.add(r);
		}

		if (pf.getPermission().getStatus()) {
			Permissao s = new Permissao(16, "S_SAC");
			this.permissoes.add(s);
		;
		}
		
		
	}
	private void classePermissaoFlatSetor(PermissaoFront pf) {

		if (pf.getPermission().getCreate()) {
			Permissao c = new Permissao(17, "C_SET");
			this.permissoes.add(c);
		}
		;
		if (pf.getPermission().getUpdate()) {
			Permissao u = new Permissao(18, "U_SET");
			this.permissoes.add(u);
		}
		;
		if (pf.getPermission().getDelete()) {
			Permissao d = new Permissao(19, "D_SET");
			this.permissoes.add(d);
		}
		;
		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(20, "R_SET");
			this.permissoes.add(r);
		}

		if (pf.getPermission().getStatus()) {
			Permissao s = new Permissao(21, "S_SET");
			this.permissoes.add(s);
		;
		}
		
		
	}
	
	private void classePermissaoFlatCategoria(PermissaoFront pf) {

		if (pf.getPermission().getCreate()) {
			Permissao c = new Permissao(22, "C_CAT");
			this.permissoes.add(c);
		}
		;
		if (pf.getPermission().getUpdate()) {
			Permissao u = new Permissao(23, "U_CAT");
			this.permissoes.add(u);
		}
		;
		if (pf.getPermission().getDelete()) {
			Permissao d = new Permissao(24, "D_CAT");
			this.permissoes.add(d);
		}
		;
		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(25, "R_CAT");
			this.permissoes.add(r);
		}

		if (pf.getPermission().getStatus()) {
			Permissao s = new Permissao(26, "S_CAT");
			this.permissoes.add(s);
		;
		}
		
		
	}
	private void classePermissaoFlatChamado(PermissaoFront pf) {

		if (pf.getPermission().getCreate()) {
			Permissao c = new Permissao(27, "C_CHA");
			this.permissoes.add(c);
		}
		;
		if (pf.getPermission().getUpdate()) {
			Permissao u = new Permissao(28, "U_CHA");
			this.permissoes.add(u);
		}
		;
		if (pf.getPermission().getDelete()) {
			Permissao d = new Permissao(29, "D_CHA");
			this.permissoes.add(d);
		}
		;
		if (pf.getPermission().getRead()) {
			Permissao r = new Permissao(30, "R_CHA");
			this.permissoes.add(r);
		}

		if (pf.getPermission().getStatus()) {
			Permissao s = new Permissao(31, "S_CHA");
			this.permissoes.add(s);
		;
		}
		
		
	}

}
