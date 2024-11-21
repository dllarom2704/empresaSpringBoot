package com.aprendec.empresa.services;

import com.aprendec.empresa.entities.EmployeeDTO;
import com.aprendec.empresa.entities.Empleados;

public class EmployeeMapper {

	// Convert EmployeeImpl (Entity) to EmployeeDTO (DTO)
	public static EmployeeDTO toDTO(Empleados employeeImpl) {
		EmployeeDTO employeeDTO = new EmployeeDTO();

		employeeDTO.setNombre(employeeImpl.getNombre());
		employeeDTO.setDni(employeeImpl.getDni());
		employeeDTO.setSexo(employeeImpl.getSexo());
		employeeDTO.setCategoria(employeeImpl.getCategoria());
		employeeDTO.setAnyos(employeeImpl.getAnyos());

		return employeeDTO;
	}

	// Convert EmployeeDTO (DTO) to EmployeeImpl (Entity)
	public static Empleados toEntity(EmployeeDTO employeeDTO) {
		Empleados employeeImpl = new Empleados();

		employeeImpl.setNombre(employeeDTO.getNombre());
		employeeImpl.setDni(employeeDTO.getDni());
		employeeImpl.setSexo(employeeDTO.getSexo());
		employeeImpl.setCategoria(employeeDTO.getCategoria());
		employeeImpl.setAnyos(employeeDTO.getAnyos());

		return employeeImpl;
	}

}
