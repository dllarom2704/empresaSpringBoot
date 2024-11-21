package com.aprendec.empresa.controllers;

import org.springframework.ui.Model;

import com.aprendec.empresa.entities.EmployeeDTO;

public interface EmpleadoController {
	String listarEmpleados(Model model);

	String buscarDni();

	String buscarPorDato(String datum, Model model);

	String editarEmpleado(EmployeeDTO employeeDTO, String dniEmpleadoBuscado, Model model);
}
