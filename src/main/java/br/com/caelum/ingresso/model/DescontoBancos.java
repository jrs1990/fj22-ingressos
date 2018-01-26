package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class DescontoBancos implements IDesconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
	}
	
	public BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal)
	{
		return precoOriginal.multiply(new BigDecimal("0.3"));
	}

}
