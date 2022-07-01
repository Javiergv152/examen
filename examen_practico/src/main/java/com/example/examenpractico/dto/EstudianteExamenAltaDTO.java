package com.example.examenpractico.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EstudianteExamenAltaDTO {
	private Integer estudianteId;
	@NotNull
	private Integer examenId;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@NotNull
	private LocalDateTime fechaAsignacion;

	public Integer getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Integer estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Integer getExamenId() {
		return examenId;
	}

	public void setExamenId(Integer examenId) {
		this.examenId = examenId;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

}
