package com.example.examenpractico.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RespuestaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7925939421884916250L;
	private Integer id;
	@Size(max = 200)
	private String respuesta;
	private Boolean respuestaCorrecta;
	private Character reactivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(Boolean respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public Character getReactivo() {
		return reactivo;
	}

	public void setReactivo(Character reactivo) {
		this.reactivo = reactivo;
	}

}
