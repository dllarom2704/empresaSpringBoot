package com.aprendec.empresa.entities.exceptions;

public class DatosNoCorrectosException extends Exception {

	/**
	 * Contructor de la excepción, tenemos que añadirle un mensaje a la hora de lanzarla
	 * @param message Mensaje de error
	 */
	public DatosNoCorrectosException(String message) {
		super(message);
	}

}
