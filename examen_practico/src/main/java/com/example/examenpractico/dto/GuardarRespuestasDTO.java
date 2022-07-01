package com.example.examenpractico.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;

public class GuardarRespuestasDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2085887480313153339L;
	@NotNull (message = "El atributo examenEstudianteId es obligatorio")
	private Integer examenEstudianteId;
	@NotNull (message = "El atributo preguntas es obligatorio")
	private List<@Valid PreguntaDTO> preguntas;
	@NotNull  (message = "El atributo fechaPresentacion es obligatorio")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@NotNull
	private LocalDateTime fechaPresentacion;

	public Integer getExamenEstudianteId() {
		return examenEstudianteId;
	}

	public void setExamenEstudianteId(Integer examenEstudianteId) {
		this.examenEstudianteId = examenEstudianteId;
	}

	public List<PreguntaDTO> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}

	public LocalDateTime getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(LocalDateTime fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

}
