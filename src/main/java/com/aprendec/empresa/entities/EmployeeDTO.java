package com.aprendec.empresa.entities;

public class EmployeeDTO {
	// PROPERTIES
	private String nombre, dni;
	private char sexo;
	private Integer categoria;
	public Integer anyos;

	// GETTERS & SETTERS
	// nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// dni
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// sexo
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	// anyos
	public Integer getAnyos() {
		return anyos;
	}

	public void setAnyos(Integer anyos) {
		this.anyos = anyos;
	}

	// categoria
	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
}
