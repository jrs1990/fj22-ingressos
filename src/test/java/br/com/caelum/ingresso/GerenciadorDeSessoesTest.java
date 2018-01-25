package br.com.caelum.ingresso;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.AssertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import junit.framework.Assert;
import java.util.*;



public class GerenciadorDeSessoesTest {
	
	private List<Sessao> sessoes;
	private Filme rougueOne;
	private Sala sala3D;
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreze;
	private Sessao sessaoDasDezoito;
	

	@org.junit.Before
	public void PopulaValores() 
	{
		this.rougueOne = new Filme("Rougue One",Duration.ofMinutes(120),"SCI-FI",BigDecimal.ONE);
		this.sala3D = new Sala("Sala 3D",BigDecimal.ONE);
		
		this.sessaoDasDez = new Sessao(LocalTime.parse("10:00:00"),rougueOne,sala3D);
		this.sessaoDasTreze = new Sessao(LocalTime.parse("13:00:00"),rougueOne,sala3D);
		this.sessaoDasDezoito = new Sessao(LocalTime.parse("18:00:00"),rougueOne,sala3D);
		
		
	}
	/*
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario()
	{
		List<Sessao> sessoes = Arrays.asList(this.sessaoDasDez);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.Verifica(this.sessaoDasDez));
		
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente()
	{
		List<Sessao> sessoes = Arrays.asList(this.sessaoDasDez);
		Sessao sessao = new Sessao(this.sessaoDasDez.getHorario().minusHours(1),this.rougueOne,this.sala3D);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.Verifica(sessao));
		
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente()
	{
		List<Sessao> sessoes = Arrays.asList(this.sessaoDasDez);
		Sessao sessao = new Sessao(this.sessaoDasDez.getHorario().plusHours(1),this.rougueOne,this.sala3D);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.Verifica(sessao));
		
	}
	
	@Test
	public void garanteQueNaoDevePermitirUmaInsercaoEntrDoisFilmes()
	{
		List<Sessao> sessoes = Arrays.asList(this.sessaoDasDez,this.sessaoDasDezoito);
		Sessao sessao = new Sessao(this.sessaoDasDez.getHorario().plusHours(1),this.rougueOne,this.sala3D);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.Verifica(this.sessaoDasTreze));
		
	}
	

	
	@Test
	public void deveInserirSeListaVazia() {
		GerenciadorDeSessao gds = new GerenciadorDeSessao(Collections.EMPTY_LIST);
		Assert.assertTrue(gds.Verifica(new Sessao()));
	}
*/
}
