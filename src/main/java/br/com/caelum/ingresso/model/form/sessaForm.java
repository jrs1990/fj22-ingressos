package br.com.caelum.ingresso.model.form;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;
import java.util.*;

import javax.validation.constraints.NotNull;


public class sessaForm {
	private Integer id;
	
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private Integer filmeid;
	
	@NotNull
	private Integer salaId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getFilmeid() {
		return filmeid;
	}

	public void setFilmeid(Integer filmeid) {
		this.filmeid = filmeid;
	}

	
	public Sessao toSessao(SalaDao saladao,FilmeDao filmedao)
	{
		Filme filme = filmedao.findOne(filmeid);
		Sala sala = saladao.findOne(salaId);
		
		Sessao sessao = new Sessao(horario,filme,sala);
		return sessao;
	}

}
