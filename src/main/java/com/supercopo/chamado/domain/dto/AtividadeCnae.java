package com.supercopo.chamado.domain.dto;

public class AtividadeCnae {

	private String text;
	private String code;

	public AtividadeCnae() {
	}

	public AtividadeCnae(String text, String code) {
		this.text = text;
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
