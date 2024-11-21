package com.aprendec.empresa.entities;

public class PayslipDTO {
	// PROPERTIES
	private String dni;
	private Integer sueldo;

	// GETTERS & SETTERS
	// dni
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// sueldo
	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
}
