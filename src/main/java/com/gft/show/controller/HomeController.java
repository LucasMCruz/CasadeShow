package com.gft.show.controller;

import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/")
	public ModelAndView casas() {
		ModelAndView mv = new ModelAndView("Home");
		List<Evento> todosEventos = events.findAll();
		mv.addObject("events", todosEventos);
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
		
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public String comprar(@PathVariable Long codigo, RedirectAttributes attributess) {
			System.out.println(codigo);	
			ModelAndView mv = new ModelAndView("Home");
			
			Optional<Evento> todosEventos = events.findById(codigo);
			int des = 1 ;
			if (todosEventos.get().getQtdingresso() > 0) {
					todosEventos.get().setQtdingresso(todosEventos.get().getQtdingresso() - des);
			mv.addObject(todosEventos.get().getQtdingresso());
			events.save(todosEventos.get());}
			else {
				attributess.addFlashAttribute("Otario acabou");
			}
			
			//events.save(todosEventos.get());
			System.out.println(todosEventos.get().getQtdingresso());
			return "redirect:/";
		
	}
	

}
