package com.supercopo.chamado.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supercopo.chamado.domain.dto.ChamadoDTO;
import com.supercopo.chamado.domain.dto.flat.ChamadoFlat;

@Entity
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String titulo;
	@ManyToOne
	private Setor setor;
	@ManyToOne
	private Categoria categoria;
	private Boolean status;

	private String urgencia;

	@ManyToOne
	private Tenant tenant;

	@JsonIgnore
	@OneToMany(mappedBy = "chamado")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Chamado() {
	}

	public Chamado(Integer id, String descricao, String titulo, Setor setor, Categoria categoria, Boolean status,
			String urgencia, Tenant tenant, List<LogSistema> logs) {
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.setor = setor;
		this.categoria = categoria;
		this.status = status;
		this.urgencia = urgencia;
		this.tenant = tenant;
		this.logs = logs;
	}

	public Chamado(@Valid ChamadoDTO obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.titulo = obj.getTitulo();

	}

	public Chamado(ChamadoFlat obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.titulo = obj.getTitulo();
		this.categoria = obj.getCategoria();
		this.setor = obj.getSetor();
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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


	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
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
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
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

}
