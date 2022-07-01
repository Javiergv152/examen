package com.example.examenpractico.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EstudianteDTO implements Serializable {
	private static final long serialVersionUID = 2244600092620219281L;
	private Integer id;
	@NotBlank (message = "El atributo nombre es obligatorio")
	@Size(max = 45)
	private String nombre;
	@NotBlank(message = "El atributo apellido paterno es obligatorio")
	@Size(max = 45)
	private String apellidoPaterno;
	@NotBlank(message = "El atributo apellido materno es obligatorio")
	@Size(max = 45)
	private String apellidoMaterno;
	@NotNull (message = "El atributo edad es obligatorio")
	private Integer edad;
	@NotNull (message = "El atributo idCiudad es obligatorio")
	private Integer idCiudad;
	@NotNull (message = "El atributo zonaHoraria es obligatorio")
	private Integer zonaHoraria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(Integer zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

}
