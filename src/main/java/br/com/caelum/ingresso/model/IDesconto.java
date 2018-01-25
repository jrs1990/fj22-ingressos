package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public interface IDesconto {

	BigDecimal aplicarDesconto(BigDecimal precoOriginal);
}
