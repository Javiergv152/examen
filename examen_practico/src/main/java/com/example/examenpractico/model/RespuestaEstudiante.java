package com.example.examenpractico.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta_estudiante")
public class RespuestaEstudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "asignar_estudiante_examen_id", nullable = false)
	private EstudianteExamen estudianteExamen;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "respuesta_id", nullable = false)
	private Respuesta respuesta;
	
	
	public RespuestaEstudiante() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Respuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	public EstudianteExamen getEstudianteExamen() {
		return estudianteExamen;
	}
	public void setEstudianteExamen(EstudianteExamen estudianteExamen) {
		this.estudianteExamen = estudianteExamen;
	}
}
