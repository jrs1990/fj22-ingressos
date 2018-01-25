package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;
	
	public Ingresso(Sessao sessao,IDesconto desconto)
	{
		this.sessao = sessao;
		this.preco = desconto.aplicarDesconto(sessao.getPreco());
	}
	
}
