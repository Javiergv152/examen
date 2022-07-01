package com.example.examenpractico.errors;




public class RespuestasIncompletasException extends RuntimeException {
	public RespuestasIncompletasException() {
		super();
	}

	public RespuestasIncompletasException(String mensaje) {
		super(mensaje);
	}
}
