package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.caelum.ingresso.*;

@Entity
public class Ingresso {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;
	
	@ManyToOne
	private Lugar lugar;
	
	@Enumerated(EnumType.STRING)
	private TipoIngresso tipoIngresso;
	
	public Ingresso()
	{
		
	}
	public Ingresso(Sessao sessao,TipoIngresso tipoDeIngresso,Lugar lugar)
	{
		this.sessao = sessao;
		this.preco = tipoDeIngresso.aplicarDesconto(sessao.getPreco());
		this.lugar=lugar;
		this.tipoIngresso = tipoDeIngresso;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoIngresso getTipoDeIngresso() {
		return this.tipoIngresso;
	}

	public void setTipoDeIngresso(TipoIngresso tipoDeIngresso) {
		this.tipoIngresso = tipoDeIngresso;
	}
	
	
}
