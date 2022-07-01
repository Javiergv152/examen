package com.example.examenpractico.errors;




public class RegistroNoEncontradoException extends RuntimeException {
	public RegistroNoEncontradoException() {
		super();
	}

	public RegistroNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
