package com.example.examenpractico.errors;




public class ZonaHorariaErroneaException extends RuntimeException {
	public ZonaHorariaErroneaException() {
		super();
	}
	public ZonaHorariaErroneaException(String mensaje) {
		super(mensaje);
	}
}
