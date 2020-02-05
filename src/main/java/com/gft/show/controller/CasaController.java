package com.gft.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gft.show.model.CasaShow;

@Controller

public class CasaController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/entrar")
	public String login() {
		return "entrar";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/registrar")
	public String cadastro() {
		return "cadastro";
	}
	
	@RequestMapping (method = RequestMethod.GET, path = "/casashow")
	public String Menu() {
		
		return "CadastroEvento";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/casashow/home")
	public String Sobre() {
		return "Home";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/casashow/casas")
	public String Skill() {
		return "CadastroEvento";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/casashow/eventos")
	public String Work() {
		return "CadastroTitulo";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/casashow/historico")
	public String LifeStyle() {
		return "PesquisaEvento";
	}
	
	@RequestMapping(value="/casashow/evento", method = RequestMethod.POST)
	public void salvar(CasaShow casaShow) {
		//Salvar no banco de dados
		
	}
}
