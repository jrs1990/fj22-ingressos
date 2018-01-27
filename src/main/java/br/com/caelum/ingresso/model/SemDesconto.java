package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class SemDesconto implements IDesconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal;
	}

	@Override
	public String getDescricao() {
		return "Normal";
	}

}
