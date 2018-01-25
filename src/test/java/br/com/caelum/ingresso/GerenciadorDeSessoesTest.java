package br.com.caelum.ingresso;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.AssertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Sessao;
import junit.framework.Assert;



public class GerenciadorDeSessoesTest {
	
	private List<Sessao> sessoes;

	@Before
	public void PopulaValores 
	{
		
	}
	
	@Test
	public void deveInserirSeListaVazia() {
		GerenciadorDeSessao gds = new GerenciadorDeSessao(Collections.EMPTY_LIST);
		Assert.assertTrue(gds.Verifica(new Sessao()));
	}

}
