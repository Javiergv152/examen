package com.example.examenpractico.dto;

import java.io.Serializable;

public class PaisDTO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2102935252899977625L;
	private Integer id;
	private String pais;
	private String continente;

	public PaisDTO(Integer id, String pais, String continente) {
		super();
		this.id = id;
		this.pais = pais;
		this.continente = continente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

}
