package com.supercopo.chamado.domain.dto;

public class SacAPI {

	private String pedido;
	private String cliente;
	private String transportadora;
	private String vendedor;
	private String empresa;
	private String tipovenda;

	public SacAPI() {
	}

	public SacAPI(String pedido, String cliente, String transportadora, String vendedor, String empresa,
			String tipovenda) {
		this.pedido = pedido;
		this.cliente = cliente;
		this.transportadora = transportadora;
		this.vendedor = vendedor;
		this.empresa = empresa;
		this.tipovenda = tipovenda;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTipovenda() {
		return tipovenda;
	}

	public void setTipovenda(String tipovenda) {
		this.tipovenda = tipovenda;
	}

}
