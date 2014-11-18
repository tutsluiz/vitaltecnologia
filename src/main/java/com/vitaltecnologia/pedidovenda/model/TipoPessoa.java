package com.vitaltecnologia.pedidovenda.model;

public enum TipoPessoa {

	FISICA("fisica"), 
	JURIDICA("juridica");
	
	private String tipoPessoa;
	
	TipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}
	
}
