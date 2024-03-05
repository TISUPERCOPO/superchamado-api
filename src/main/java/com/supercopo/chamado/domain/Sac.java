package com.supercopo.chamado.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supercopo.chamado.domain.dto.SacDTO;

@Entity
public class Sac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String problema;
	private String credito;
	private String devolucao;
	private BigDecimal valorcredito;
	private String observacao;
	private String cliente;
	private String vendedor;
	private String transportadora;
	private String tipopedido;
	private String pedido;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataprevisao;
	private Boolean status = Boolean.TRUE;
	private String empresa;
	private String setor;
	private String frete;
	private Double custoTotal;

	@ManyToOne
	private Tenant tenant;

	@JsonIgnore
	@OneToMany(mappedBy = "sac")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Sac() {
	}

	public Sac(Integer id, String problema, String credito, String devolucao, BigDecimal valorcredito,
			String observacao, String cliente, String vendedor, String transportadora, String tipopedido, String pedido,
			Date dataprevisao, Boolean status, String empresa, String setor, String frete, Double custoTotal,
			Tenant tenant, List<LogSistema> logs) {
		this.id = id;
		this.problema = problema;
		this.credito = credito;
		this.devolucao = devolucao;
		this.valorcredito = valorcredito;
		this.observacao = observacao;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.transportadora = transportadora;
		this.tipopedido = tipopedido;
		this.pedido = pedido;
		this.dataprevisao = dataprevisao;
		this.status = status;
		this.empresa = empresa;
		this.setor = setor;
		this.frete = frete;
		this.custoTotal = custoTotal;
		this.tenant = tenant;
		this.logs = logs;
	}

	public Sac(@Valid SacNew obj) {
		this.id = obj.getId();
		this.problema = obj.getProblema();
		this.credito = obj.getCredito();
		this.devolucao = obj.getDevolucao();
		this.valorcredito = obj.getValorcredito();
		this.observacao = obj.getObservacao();
		this.cliente = obj.getCliente();
		this.vendedor = obj.getVendedor();
		this.transportadora = obj.getTransportadora();
		this.tipopedido = obj.getTipopedido();
		this.pedido = obj.getPedido();
		this.dataprevisao = obj.getDataprevisao();
		this.status = obj.getStatus();
		this.empresa = obj.getEmpresa();
		this.setor = obj.getSetor();
		this.frete = obj.getFrete();
		this.custoTotal = obj.getCustoTotal();

	}
	
	
	
	public Sac(@Valid SacDTO obj) {
		this.id = obj.getId();
		this.problema = obj.getProblema();
		this.credito = obj.getCredito();
		this.devolucao = obj.getDevolucao();
		this.valorcredito = obj.getValorcredito();
		this.observacao = obj.getObservacao();
		this.cliente = obj.getCliente();
		this.vendedor = obj.getVendedor();
		this.transportadora = obj.getTransportadora();
		this.tipopedido = obj.getTipopedido();
		this.pedido = obj.getPedido();
		this.dataprevisao = obj.getDataprevisao();
		this.status = obj.getStatus();
		this.empresa = obj.getEmpresa();
		this.setor = obj.getSetor();
		this.frete = obj.getFrete();
		this.custoTotal = obj.getCustoTotal();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(String devolucao) {
		this.devolucao = devolucao;
	}

	public BigDecimal getValorcredito() {
		return valorcredito;
	}

	public void setValorcredito(BigDecimal valorcredito) {
		this.valorcredito = valorcredito;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public String getTipopedido() {
		return tipopedido;
	}

	public void setTipopedido(String tipopedido) {
		this.tipopedido = tipopedido;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public Date getDataprevisao() {
		return dataprevisao;
	}

	public void setDataprevisao(Date dataprevisao) {
		this.dataprevisao = dataprevisao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setLogs(List<LogSistema> logs) {
		this.logs = logs;
	}

	public String getFrete() {
		return frete;
	}

	public void setFrete(String frete) {
		this.frete = frete;
	}


	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
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
		Sac other = (Sac) obj;
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
