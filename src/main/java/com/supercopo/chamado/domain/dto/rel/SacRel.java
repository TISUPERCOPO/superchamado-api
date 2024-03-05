package com.supercopo.chamado.domain.dto.rel;

import java.math.BigDecimal;
import java.util.Date;

import com.supercopo.chamado.domain.Sac;

public class SacRel {

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
	private Date dataprevisao;
	private String status;
	private String empresa;
	private String setor;

	public SacRel() {
	}

	public SacRel(Sac obj) {
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
		Boolean status = obj.getStatus();
		if (status) {
			this.status = "Ativo";
		} else {
			this.status = "Inativo";
		}
		this.empresa = obj.getEmpresa();
		this.setor = obj.getSetor();
	}

	public SacRel(Integer id, String problema, String credito, String devolucao, BigDecimal valorcredito,
			String observacao, String cliente, String vendedor, String transportadora, String tipopedido, String pedido,
			Date dataprevisao, String status, String empresa, String setor) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
