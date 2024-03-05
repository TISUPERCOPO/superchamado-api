package com.supercopo.chamado.domain.dto.flat;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.supercopo.chamado.domain.Classepermissao;
import com.supercopo.chamado.domain.Permissao;

public class ClassePermissaoFlat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Boolean read = Boolean.FALSE;
	private Boolean create = Boolean.FALSE;
	private Boolean update = Boolean.FALSE;
	private Boolean delete = Boolean.FALSE;
	private Boolean status = Boolean.FALSE;
	@OneToMany(mappedBy = "classepermissao")
	private PermissoesFlat permission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public PermissoesFlat getPermission() {
		return permission;
	}

	public void setPermission(PermissoesFlat permission) {
		this.permission = permission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassePermissaoFlat other = (ClassePermissaoFlat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ClassePermissaoFlat(Integer id, String nome, PermissoesFlat permission) {
		this.id = id;
		this.nome = nome;
		this.permission = permission;
	}

	public ClassePermissaoFlat() {
	}

	public ClassePermissaoFlat(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		this.id = objPorCategoria.getId();
		this.nome = objPorCategoria.getNome();

		switch (objPorCategoria.getNome()) {
		
//		case "Exame":
//			classePermissaoFlatExame(objPorCategoria, permissoes);
//			break;
//		case "Convênio":
//			classePermissaoFlatConvenio(objPorCategoria, permissoes);
//			break;
//		case "Paciente":
//			classePermissaoFlatPaciente(objPorCategoria, permissoes);
//			break;
		case "Usuario":
			classePermissaoFlatUsuario(objPorCategoria, permissoes);
			break;
		case "Relatório":
			classePermissaoFlatRelatorio(objPorCategoria, permissoes);
			break;
		case "Empresa":
			classePermissaoFlatEmpresa(objPorCategoria, permissoes);
			break;
		case "Sac":
			classePermissaoFlatSac(objPorCategoria, permissoes);
			break;
		case "Setor":
			classePermissaoFlatSetor(objPorCategoria, permissoes);
			break;
		case "Categoria":
			classePermissaoFlatCategoria(objPorCategoria, permissoes);
			break;
		case "Chamado":
			classePermissaoFlatChamado(objPorCategoria, permissoes);
			break;

		}

	}

	private void classePermissaoFlatSac(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_SAC":
				create = Boolean.TRUE;
				break;
			case "U_SAC":
				update = Boolean.TRUE;
				break;
			case "D_SAC":
				delete = Boolean.TRUE;
				break;
			case "R_SAC":
				read = Boolean.TRUE;
				break;
			case "S_SAC":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void classePermissaoFlatEmpresa(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_EMP":
				create = Boolean.TRUE;
				break;
			case "U_EMP":
				update = Boolean.TRUE;
				break;
			case "D_EMP":
				delete = Boolean.TRUE;
				break;
			case "R_EMP":
				read = Boolean.TRUE;
				break;
			case "S_EMP":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void classePermissaoFlatSetor(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_SET":
				create = Boolean.TRUE;
				break;
			case "U_SET":
				update = Boolean.TRUE;
				break;
			case "D_SET":
				delete = Boolean.TRUE;
				break;
			case "R_SET":
				read = Boolean.TRUE;
				break;
			case "S_SET":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void voltarStatusAtributos() {
		create = Boolean.FALSE;
		update = Boolean.FALSE;
		delete = Boolean.FALSE;
		read = Boolean.FALSE;
		status = Boolean.FALSE;
	}

	private void classePermissaoFlatCategoria(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_CAT":
				create = Boolean.TRUE;
				break;
			case "U_CAT":
				update = Boolean.TRUE;
				break;
			case "D_CAT":
				delete = Boolean.TRUE;
				break;
			case "R_CAT":
				read = Boolean.TRUE;
				break;
			case "S_CAT":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void classePermissaoFlatChamado(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_CHA":
				create = Boolean.TRUE;
				break;
			case "U_CHA":
				update = Boolean.TRUE;
				break;
			case "D_CHA":
				delete = Boolean.TRUE;
				break;
			case "R_CHA":
				read = Boolean.TRUE;
				break;
			case "S_CHA":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void classePermissaoFlatPaciente(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_PCTE":
				create = Boolean.TRUE;
				break;
			case "U_PCTE":
				update = Boolean.TRUE;
				break;
			case "D_PCTE":
				delete = Boolean.TRUE;
				break;
			case "R_PCTE":
				read = Boolean.TRUE;
				break;
			case "S_PCTE":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void classePermissaoFlatUsuario(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {
			case "C_USU":
				create = Boolean.TRUE;
				break;
			case "U_USU":
				update = Boolean.TRUE;
				break;
			case "D_USU":
				delete = Boolean.TRUE;
				break;
			case "R_USU":
				read = Boolean.TRUE;
				break;
			case "S_USU":
				status = Boolean.TRUE;
				break;
			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

	private void classePermissaoFlatRelatorio(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch (permissao.getDescricao()) {

			case "R_REL":
				read = Boolean.TRUE;
				break;

			}
		}
		PermissoesFlat classepermissaoFlat = new PermissoesFlat(read);
		setPermission(classepermissaoFlat);
		voltarStatusAtributos();

	}

}
