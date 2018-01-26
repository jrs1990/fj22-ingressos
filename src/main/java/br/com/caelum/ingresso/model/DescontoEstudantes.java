package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class DescontoEstudantes implements IDesconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal.divide(new BigDecimal("0.2"));
	}

}
