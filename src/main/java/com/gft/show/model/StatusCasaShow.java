package com.gft.show.model;

public enum StatusCasaShow {
	ROCK("Rock"),
	AXE("Axe"),
	ELETROCIA("Eletrocia");
	
	private String definicao;

	StatusCasaShow(String definicao){
		this.definicao = definicao;
				
	}
	
	public String getDefinicao() {
		return definicao;
	}
}