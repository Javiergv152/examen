package com.example.examenpractico.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "examen")
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nombre_examen")
	private String nombreExamen;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="examen_pregunta", joinColumns = {
            @JoinColumn(name="id_examen", referencedColumnName="id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="id_pregunta", referencedColumnName="id")
        })
	private Set<Pregunta> preguntas= new HashSet<>();

	public Examen(Integer id, String nombreExamen, Set<Pregunta> preguntas, Set<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.nombreExamen = nombreExamen;
		this.preguntas = preguntas;
	}

	public Examen() {
		super();
	}

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

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

}
