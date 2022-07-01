package com.example.examenpractico.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExamenDTO implements Serializable {

	private static final long serialVersionUID = 356648057889379260L;
	private Integer id;

	@NotBlank (message = "El atributo nombreExamen es obligatorio")
	@Size(max = 250)
	private String nombreExamen;
	@NotNull (message = "El atributo preguntas es obligatorio")
	private List<@Valid PreguntaDTO> preguntas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreExamen() {
		return nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	public List<PreguntaDTO> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}

}
