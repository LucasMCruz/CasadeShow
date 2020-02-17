package com.gft.show.model;

public enum StatusEvento {
	ROCK("Rock"),
	AXE("Axe"),
	ELETRONIA("Eletrocia");
	
	private String definicao;

	StatusEvento(String definicao){
		this.definicao= definicao; 
	}
	
	public String getDefinicao() {
		return definicao;
	}
}
