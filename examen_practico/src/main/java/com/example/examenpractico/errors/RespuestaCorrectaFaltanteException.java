package com.example.examenpractico.errors;




public class RespuestaCorrectaFaltanteException extends RuntimeException {
	public RespuestaCorrectaFaltanteException() {
		super();
	}

	public RespuestaCorrectaFaltanteException(String mensaje) {
		super(mensaje);
	}
}
