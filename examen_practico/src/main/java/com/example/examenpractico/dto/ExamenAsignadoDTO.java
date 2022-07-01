package com.example.examenpractico.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExamenAsignadoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -348591500195926416L;
	private Integer examenEstudianteId;
	private Integer examenId;
	private String nombreExamen;
	@JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime fechaAsignacion;
	@NotNull(message = "El atributo fechaPresentacion es obligatorio")
	@JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime fechaPresentacion;

	private Integer puntuacion;



	public ExamenAsignadoDTO(Integer examenEstudianteId, Integer examenId, String nombreExamen,
			LocalDateTime fechaAsignacion,
			@NotNull(message = "El atributo fechaPresentacion es obligatorio") LocalDateTime fechaPresentacion,
			Integer puntuacion) {
		super();
		this.examenEstudianteId = examenEstudianteId;
		this.examenId = examenId;
		this.nombreExamen = nombreExamen;
		this.fechaAsignacion = fechaAsignacion;
		this.fechaPresentacion = fechaPresentacion;
		this.puntuacion = puntuacion;
	}

	public LocalDateTime getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(LocalDateTime fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public Integer getExamenEstudianteId() {
		return examenEstudianteId;
	}

	public void setExamenEstudianteId(Integer examenEstudianteId) {
		this.examenEstudianteId = examenEstudianteId;
	}

	public Integer getExamenId() {
		return examenId;
	}

	public void setExamenId(Integer examenId) {
		this.examenId = examenId;
	}

	public String getNombreExamen() {
		return nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

}
