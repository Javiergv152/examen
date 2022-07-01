package com.example.examenpractico.dto;

import java.io.Serializable;

public class CiudadDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7746724835436132832L;
	
	private Integer id;
	private String ciudad;
	private String pais;
	private Integer paisID;


	public CiudadDTO(Integer id, String ciudad, String pais, Integer paisID) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.pais = pais;
		this.paisID = paisID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getPaisID() {
		return paisID;
	}

	public void setPaisID(Integer paisID) {
		this.paisID = paisID;
	}
}
