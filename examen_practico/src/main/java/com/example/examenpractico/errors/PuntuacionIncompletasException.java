package com.example.examenpractico.errors;




public class PuntuacionIncompletasException extends RuntimeException {
	public PuntuacionIncompletasException() {
		super();
	}

	public PuntuacionIncompletasException(String mensaje) {
		super(mensaje);
	}
}
