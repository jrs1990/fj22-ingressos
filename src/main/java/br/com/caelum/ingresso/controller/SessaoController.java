package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.*;
import br.com.caelum.ingresso.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessaoController {
	
	
	@Autowired
	private SalaDao saladao;
	
	@Autowired
	private FilmeDao filmedao;
	
	
	@GetMapping("admin/sessao")
	public ModelAndView form(@RequestParam("salaId") Integer salaId)
	{
		ModelAndView modelandview = new ModelAndView("sessao/sessao");
		modelandview.addObject("sala",saladao.findOne(salaId));
		modelandview.addObject("filme",filmedao.findAll());
		
		return modelandview;
	}

}
