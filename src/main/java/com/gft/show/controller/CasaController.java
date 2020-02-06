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
	
	@RequestMapping (method = RequestMethod.GET, path = "/")
	public String Menu() {
		
		return "Home";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/home")
	public String Sobre() {
		return "Home";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/casas")
	public String Skill() {
		return "Cadastrocasa";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/eventos")
	public String Work() {
		return "CadastroEvento";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/historico")
	public String LifeStyle() {
		return "Historico";
	}
	
	@RequestMapping(value="/casashow/evento", method = RequestMethod.POST)
	public void salvar(CasaShow casaShow) {
		//Salvar no banco de dados
		
	}
}
