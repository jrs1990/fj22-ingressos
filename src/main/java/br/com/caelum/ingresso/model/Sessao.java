package br.com.caelum.ingresso.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;


@Entity
public class Sessao {

	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	private BigDecimal preco;
	
	@OneToMany(mappedBy="sessao",fetch=FetchType.EAGER)
	private Set<Ingresso> ingressos = new HashSet<>();


	public Sessao()
	{
		
	}

	
	public Sessao(LocalTime horario, Filme filme, Sala sala)
	{
		this.horario=horario;
		this.filme = filme;
		this.sala=sala;
		
		this.preco = filme.getPreco().add(sala.getPreco());
		
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public Map<String,List<Lugar>> getMapaDeLugares()
	{
		return sala.getMapaDeLugares();
	}
	
	public boolean isDisponivel(Lugar lugarSelecionado)
	{
		return this.ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar -> lugar.equals(lugarSelecionado));
	}
	


}
