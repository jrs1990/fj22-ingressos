package br.com.caelum.ingresso;

import br.com.caelum.ingresso.model.*;
import java.util.*;
import java.util.stream.Stream;

import org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl;

import java.time.*;

public class GerenciadorDeSessao {

	private List<Sessao> sessoes;
	
	public GerenciadorDeSessao(List<Sessao> sessoes)
	{
		this.sessoes=sessoes;
	}
	
	public boolean Verifica(Sessao nova)
	{
		Stream<Sessao> sSessoes = this.sessoes.stream();
		return sSessoes.allMatch(sExist -> horarioIsValido(sExist, nova));
		
		
	}
	
	private boolean horarioIsValido(Sessao sessaoExistente, Sessao sessaoAtual)
	{
		LocalDate hoje = LocalDate.now();
		LocalDateTime horarioSessao = sessaoExistente.getHorario().atDate(hoje);
		LocalDateTime horarioAtual = sessaoAtual.getHorario().atDate(hoje);
		
		boolean ehAntes = horarioAtual.isBefore(horarioSessao);
		
		if(ehAntes)
		{
			return horarioAtual
					.plus(sessaoAtual.getFilme().getDuracao())
					.isBefore(horarioSessao);
		}
		else
		{
			return horarioSessao
					.plus(sessaoExistente.getFilme().getDuracao())
					.isBefore(horarioAtual);
		}
		
	}
	
	
}
