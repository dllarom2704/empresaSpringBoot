package com.aprendec.empresa.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aprendec.empresa.entities.EmployeeDTO;
import com.aprendec.empresa.services.EmployeeService;

@Controller
@RequestMapping("/empresa")
public class EmpleadoControllerImpl implements EmpleadoController {
	private final EmployeeService employeeService;

	// CONSTRUCTORS
	public EmpleadoControllerImpl(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// GETS
	// home
	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	// list employees
	@GetMapping("/listar")
	public String listarEmpleados(Model model) {
		try {
			List<EmployeeDTO> employees = employeeService.getEmployees();
			model.addAttribute("employees", employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "listar";
	}

	// search by dni
	@GetMapping("/buscarDni")
	public String buscarDni() {
		return "buscarDNI";
	}

	// search by datum
	@GetMapping("/buscarDato")
	public String buscarDatos() {
		return "buscarDato";
	}

	// edit
	@GetMapping("/editar")
	public String editarEmpleado(@RequestParam("dni") String dni, Model model) {
		try {
			EmployeeDTO employeeDTO = employeeService.getEmployee(dni);

			model.addAttribute("employee", employeeDTO);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "editar";
	}

	// error
	@GetMapping("/error")
	public String error() {
		return "error";
	}

	// POSTS
	// search salary by dni
	@PostMapping("/buscarDni")
	public String buscarSalario(@RequestParam("dni") String dni, Model model) {
		try {
			String salary = employeeService.getSalary(dni);

			model.addAttribute("salary", salary);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "salario";
	}

	// search employee by datum
	@PostMapping("/buscarDato")
	public String buscarPorDato(@RequestParam("datum") String datum, Model model) {
		try {
			List<EmployeeDTO> employees = employeeService.getEmployeeData(datum);

			model.addAttribute("employees", employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "listarEmpleadosBusquedaDatos";
	}

	// edit employee
	@PostMapping("/editar")
	public String editarEmpleado(@ModelAttribute EmployeeDTO employeeDTO,
			@RequestParam("dniEmpleadoBuscado") String dniEmpleadoBuscado, Model model) {
		try {
			boolean result = employeeService.edit(employeeDTO, dniEmpleadoBuscado);

			if (result) {
				model.addAttribute("message", "Empleado editado correctamente");
			} else {
				model.addAttribute("message", "Error al editar el empleado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "redirect:/empresa/buscarDato";
	}

}
