package com.aprendec.empresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nominas")
public class Nominas {
	// PROPERTIES
	@Id
	private String dni;

	private Integer sueldo;

	// CONSTRUCTORS
	public Nominas() {
		super();
	}

	public Nominas(String dni, Integer sueldo) {
		super();
		this.dni = dni;
		this.sueldo = sueldo;
	}

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
