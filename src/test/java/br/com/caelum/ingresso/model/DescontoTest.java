package br.com.caelum.ingresso.model;

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


public class DescontoTest {

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal()
	{
		Lugar lugar = new Lugar("A",1);
		Sala sala = new Sala("Eldorado IMAX",new BigDecimal("20.5"));
		Filme filme = new Filme("Rougue One",Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12"));
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme,sala);
		
		Ingresso ingressp = new Ingresso(sessao, TipoIngresso.INTEIRO,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("32.5");
		
		Assert.assertEquals(precoEsperado, ingressp.getPreco());
		
		
	}
}
