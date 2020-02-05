package com.gft.show.model;

public enum StatusEvento {
	RESERVADO("Reservado"),
	COMPRADO("COMPRADO");
	
	
	private String definicao;

	StatusEvento(String definicao){
		this.definicao= definicao; 
	}
	
	public String getDefinicao() {
		return definicao;
	}
}
