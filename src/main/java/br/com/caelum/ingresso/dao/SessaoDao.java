package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.*;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessaoDao {

	@PersistenceContext
	private EntityManager mananger;
	
	public void Salva(Sessao sessao)
	{
		mananger.persist(sessao);
	}
	
	public List<Sessao> BuscaSessao(Sala sala)
	{
		 return   mananger.createQuery("select s from Sessao s where s.sala = :sala",Sessao.class)
				 .setParameter("sala",sala)
				 .getResultList();

	}
	
	public List<Sessao> BuscaSessoesDoFilme(Filme filme)
	{
		 return   mananger.createQuery("select s from Sessao s where s.filme = :filme",Sessao.class)
				 .setParameter("filme",filme)
				 .getResultList();

	}
	
	public Sessao FindOne(int sessaoID)
	{
		return   mananger.find(Sessao.class, sessaoID);
	}
}
