package com.gft.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.repository.CasaShowRepository;
import com.gft.show.repository.EventoRepository;

@Controller

public class CasaController {
	@Autowired
	private EventoRepository events;
	
	
	@Autowired
	private CasaShowRepository cshow;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/entrar")
	public String login() {
		return "entrar";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/registrar")
	public String cadastro() {
		return "cadastro";
	}
	


	@RequestMapping(method = RequestMethod.GET, path = "/historico")
	public String LifeStyle() {
		return "Historico";
	}

	


	
}
