package com.example.examenpractico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "respuesta")
	private String respuesta;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "pregunta_id", nullable = false)
	private Pregunta pregunta;
	@Column(name = "correcta")
	private Boolean respuestaCorrecta;
	@Column(name = "reactivo")
	private Character reactivo;

	

	public Respuesta(Integer id, String respuesta, Pregunta pregunta, Boolean respuestaCorrecta, Character reactivo) {
		super();
		this.id = id;
		this.respuesta = respuesta;
		this.pregunta = pregunta;
		this.respuestaCorrecta = respuestaCorrecta;
		this.reactivo = reactivo;
	}

	public Respuesta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Boolean getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(Boolean respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public Character getReactivo() {
		return reactivo;
	}

	public void setReactivo(Character reactivo) {
		this.reactivo = reactivo;
	}

}
