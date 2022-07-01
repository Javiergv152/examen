package com.example.examenpractico.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pregunta")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "pregunta")
	private String pregunta;
	@Column(name = "puntos")
	private Integer puntos;

	@ManyToMany(mappedBy = "preguntas", fetch = FetchType.LAZY)
	private Set<Examen> examenes = new HashSet<>();

	@OneToMany(mappedBy = "pregunta")
	private Set<Respuesta> respuestas;
	
	

	public Pregunta(Integer id, String pregunta, Integer puntos, Set<Examen> examenes, Set<Respuesta> respuestas) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.puntos = puntos;
		this.examenes = examenes;
		this.respuestas = respuestas;
	}

	public Pregunta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Set<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}
