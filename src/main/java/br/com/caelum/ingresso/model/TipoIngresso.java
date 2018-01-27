package br.com.caelum.ingresso.model;

import java.math.BigDecimal;


public enum TipoIngresso {
	
	INTEIRO (new SemDesconto()),
	ESTUDANTE(new DescontoEstudantes()),
	BANCO (new DescontoBancos());
	
	private final IDesconto desconto;
	
	TipoIngresso(IDesconto desconto) {
		this.desconto=desconto;
	}
	
	public BigDecimal aplicarDesconto(BigDecimal valor)
	{
		return this.desconto.aplicarDesconto(valor);
	}
	
	public String getDescricao()
	{
		return this.desconto.getDescricao();
	}

}
