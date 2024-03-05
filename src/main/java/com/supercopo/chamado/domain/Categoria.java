package com.supercopo.chamado.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supercopo.chamado.domain.dto.CategoriaDTO;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Boolean status = Boolean.TRUE;
	
	@ManyToOne
	private Tenant tenant;
	

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Categoria() {
	}


	public Categoria(Integer id, String descricao, Boolean status, Tenant tenant, List<LogSistema> logs) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.tenant = tenant;
		this.logs = logs;
	}


	public Categoria(@Valid CategoriaDTO obj) {
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

	

	public Tenant getTenant() {
		return tenant;
	}


	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	
	public void addLogs(LogSistema log) {
		logs.add(log);
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

}
