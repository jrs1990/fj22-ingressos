package br.com.caelum.ingresso.controller;


import br.com.caelum.ingresso.GerenciadorDeSessao;
import br.com.caelum.ingresso.ImagemCapa;
import br.com.caelum.ingresso.clientJson;
import br.com.caelum.ingresso.GerenciadorDeSessao;

import br.com.caelum.ingresso.dao.*;
import java.time.*;
import br.com.caelum.ingresso.model.*;
import br.com.caelum.ingresso.model.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.*;

@Controller
public class SessaoController {
	
	
	@Autowired
	private SalaDao saladao;
	
	@Autowired
	private FilmeDao filmedao;
	
	@Autowired
	private SessaoDao sessaodao;

	
	@GetMapping("admin/sessao")
	public ModelAndView form(@RequestParam("salaId") Integer salaId,SessaoForm form)
	{
		form.setSalaId(salaId);
		ModelAndView modelandview = new ModelAndView("sessao/sessao");
		modelandview.addObject("sala",saladao.findOne(salaId));
		modelandview.addObject("filmes",filmedao.findAll());
		modelandview.addObject("form",form);
		return modelandview;
	}
	
	@PostMapping(value="/admin/sessao")
	@Transactional
	public ModelAndView salva(@Valid SessaoForm form,BindingResult result)
	{
		if(result.hasErrors())
		{
			return form(form.getSalaId(),form);
		}
		ModelAndView modelandview = new ModelAndView("redirect:/admin/sala/"+form.getSalaId()+"/sessoes");
		Sessao sessao = form.toSessao(saladao, filmedao);


		List<Sessao> sessoes = sessaodao.BuscaSessao(sessao.getSala());
		GerenciadorDeSessao gds = new GerenciadorDeSessao(sessoes);

		if(gds.Verifica(sessao))
		{
			sessaodao.Salva(sessao);
		}

		return modelandview;
	}
	
	@GetMapping("/sessao/{id}/lugares")
	public ModelAndView lugaresNaSessao(@PathVariable("id") int idSessao)
	{
		clientJson<ImagemCapa> client = new clientJson<ImagemCapa>();
		ModelAndView view = new ModelAndView("sessao/lugares");
		Sessao sessao = sessaodao.FindOne(idSessao);
		String parametros = "title="+sessao.getFilme().getNome();
		
		Optional<ImagemCapa> imagemcapa = client.ConsultaServico(parametros, ImagemCapa.class);
		

		view.addObject("sessao",sessao);
		view.addObject("detalhes",imagemcapa.orElse(new ImagemCapa()));
		view.addObject("tiposDeIngressos",TipoIngresso.values());
		return view;
		
	}

	

}
