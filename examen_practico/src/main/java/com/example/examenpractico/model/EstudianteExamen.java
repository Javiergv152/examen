package com.example.examenpractico.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "asignar_estudiante_examen")
public class EstudianteExamen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estudiante_id", nullable = false)
	private Estudiante estudiante;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "examen_id", nullable = false)
	private Examen examen;

	@OneToMany(mappedBy = "estudianteExamen")
	private Set<RespuestaEstudiante> respuestasEstudiante;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaAsignacion;
	@Column(name = "calificacion")
	private Integer calificacion;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaPresentacion;
	
	public EstudianteExamen() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Set<RespuestaEstudiante> getRespuestasEstudiante() {
		return respuestasEstudiante;
	}

	public void setRespuestasEstudiante(Set<RespuestaEstudiante> respuestasEstudiante) {
		this.respuestasEstudiante = respuestasEstudiante;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public LocalDateTime getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(LocalDateTime fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

}
