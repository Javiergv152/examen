package com.example.examenpractico.dto;

import java.io.Serializable;

public class ZonaHorariaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 972934693495801168L;
	private Integer id;
	private String utc;
	private String zonaHoraria;
	private String pais;
	private Integer paisId;



	public ZonaHorariaDTO(Integer id, String utc, String zonaHoraria, String pais, Integer paisId) {
		super();
		this.id = id;
		this.utc = utc;
		this.zonaHoraria = zonaHoraria;
		this.pais = pais;
		this.paisId = paisId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUtc() {
		return utc;
	}

	public void setUtc(String utc) {
		this.utc = utc;
	}

	public String getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(String zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}
}
