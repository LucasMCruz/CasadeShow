package com.gft.show.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.model.CasaShow;
import com.gft.show.repository.CasaShowRepository;

;

@Controller
public class CasaShowController {
	
	@Autowired
	private CasaShowRepository cshow;
	

	
	
	@RequestMapping(value="/casas")
	public ModelAndView view() {
		List<CasaShow> todasCasas = cshow.findAll();
		ModelAndView mv = new ModelAndView("CadastroCasa");
		mv.addObject("cshow", todasCasas);
		mv.addObject(new CasaShow());
		
		return mv;
	}
	
	
	@RequestMapping(value="/casas", method = RequestMethod.POST)
	public ModelAndView salvar(CasaShow casashow) {
		List<CasaShow> todasCasas = cshow.findAll();
		ModelAndView mv = new ModelAndView("CadastroCasa");
		mv.addObject("cshow", todasCasas);
		mv.addObject(new CasaShow());
		
		mv.addObject("mensagem", "Casa Cadastrada com sucesso");
		
		cshow.save(casashow);

		//Salvar no banco de dados
		
		return view();
	}
	
	@RequestMapping(value="/casas/{codigo}")
	public ModelAndView edicao(@PathVariable ("codigo")Long codigo, RedirectAttributes red) {
		CasaShow casashow = cshow.findById(codigo).get();
		ModelAndView mv = new ModelAndView("CadastroCasa");
		mv.addObject(casashow);
		
		
		return mv;
	}
	
	
	
	/*public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		cshow.deleteById(codigo);
	}
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") CasaShow casashow) {

		ModelAndView mv = new ModelAndView("CadastroCasa");
		mv.addObject(casashow);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		this.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Produto excluido com sucesso");
		return "redirect:/titulo";
	}*/
	

}
