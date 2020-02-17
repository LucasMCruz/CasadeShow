package com.gft.show.controller;

import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@RequestMapping("/venda/{codigo}")
	public ModelAndView comprar(@PathVariable Long codigo, RedirectAttributes attributess) {
			System.out.println(codigo);	
			ModelAndView mv = new ModelAndView("redirect:/");
		
			int des = 1;
			
			Optional<Evento> Evento = events.findById(codigo);
			if (Evento.get().getQtdingresso() > 0) {
					Evento.get().setQtdingresso(Evento.get().getQtdingresso() - des);
			mv.addObject(Evento.get().getQtdingresso());
			events.save(Evento.get());}
			else {
				attributess.addFlashAttribute("mensagem", "acabou");
			}
			mv.addObject("events", Evento.get());
			events.save(Evento.get());
			System.out.println(Evento.get().getNomeEvento());
			return mv;
		
	}
	@RequestMapping("/{codigo}")
	public ModelAndView venda(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("TelaVenda");
		mv.addObject(new Evento());
		Optional<Evento> Evento = events.findById(codigo);
		mv.addObject("events", Evento.get());
		return mv;
	}

}
