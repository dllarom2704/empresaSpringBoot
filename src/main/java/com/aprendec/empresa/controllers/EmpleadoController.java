package com.aprendec.empresa.controllers;

import org.springframework.ui.Model;

import com.aprendec.empresa.entities.EmployeeDTO;

public interface EmpleadoController {
	String welcome();

	String listarEmpleados(Model model);

	String buscarDni();

	String buscarDatos();

	String editarEmpleado(String dni, Model model);

	String error();

	String buscarSalario(String dni, Model model);

	String buscarPorDato(String datum, Model model);

	String editarEmpleado(EmployeeDTO employeeDTO, String dniEmpleadosBuscado, Model model);
}
