package com.gft.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository events;
	
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/eventos")
	public String Work() {
		return "CadastroEvento";
	}
	
	@RequestMapping(value="/eventos", method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Evento evento, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastroCasa");
		
		if(errors.hasErrors()) {
			List<Evento> todosEventos = events.findAll();
			mv.addObject("cshow", todosEventos);
			return mv;
		}
		events.save(evento);
		
		mv.addObject("mensagem", "Casa Cadastrada com sucesso");
		mv.addObject(new CasaShow());
		List<Evento> todosEventos = events.findAll();
		mv.addObject("events", todosEventos);
		
	

		//Salvar no banco de dados
		
		return mv;
	}
	
	

}

