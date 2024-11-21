package com.aprendec.empresa.entities;

import com.aprendec.empresa.entities.exceptions.DatosNoCorrectosException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleados implements Employee {
	// PROPERTIES
	@Id
	private String dni;
	
	private String nombre;
	private char sexo;
	private Integer categoria;
	public Integer anyos;

	// CONSTRUCTORS
	public Empleados() {
	}

	public Empleados(String nombre, char sexo) {
		this.nombre = nombre;
		this.sexo = sexo;

	}

	public Empleados(String nombre, String dni, char sexo) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		categoria = 1;
		anyos = 0;
	}

	public Empleados(String nombre, String dni, char sexo, Integer categoria, Integer anyos)
			throws DatosNoCorrectosException {
		if (!(categoria >= 1 && categoria <= 10 || !(anyos >= 0))) {
			throw new DatosNoCorrectosException("Datos no correctos");
		}

		this.categoria = categoria;
		this.anyos = anyos;
	}

	// IMPLEMENTED METHODS
	@Override
	public void incrAnyo() {
		anyos++;
	}

	@Override
	public void imprime() {
		System.out.println("Nombre: " + nombre + "\nDni: " + dni + "\nSexo: " + sexo + "\nCategoría: " + categoria
				+ "\nAños trabajados: " + anyos);
	}

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

	// categoria
	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	// anyos
	public Integer getAnyos() {
		return anyos;
	}

	public void setAnyos(Integer anyos) {
		this.anyos = anyos;
	}

}
