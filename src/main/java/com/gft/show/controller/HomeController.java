package com.gft.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.repository.CasaShowRepository;
import com.gft.show.repository.EventoRepository;

@Controller
public class HomeController {
	@Autowired
	private EventoRepository events;
	
	
	@Autowired
	private CasaShowRepository cshow;
	
	@RequestMapping("/home")
	public ModelAndView casas() {
		ModelAndView mv = new ModelAndView("Home");
		List<Evento> todosEventos = events.findAll();
		mv.addObject("evento", todosEventos);
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("casashow", todasCasas);
		
		
		return mv;
	}
	
	

}
