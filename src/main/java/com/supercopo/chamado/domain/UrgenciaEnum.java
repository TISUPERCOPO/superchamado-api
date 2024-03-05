package com.supercopo.chamado.domain;

public enum UrgenciaEnum {

	BAIXA("BAIXA"),
	MEDIA("MEDIA"),
	ALTA("ALTA");
	
	
	 private final String descricao;

	    UrgenciaEnum(String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    @Override
	    public String toString() {
	        return descricao;
	    }
	
	
}
