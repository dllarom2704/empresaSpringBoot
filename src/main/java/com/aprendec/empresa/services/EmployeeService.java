package com.aprendec.empresa.services;

import java.sql.SQLException;
import java.util.List;

import com.aprendec.empresa.entities.EmployeeDTO;


public interface EmployeeService {
	List<EmployeeDTO> getEmployees() throws SQLException;

	String getSalary(String dni) throws SQLException;

	List<EmployeeDTO> getEmployeeData(String datum) throws SQLException;

	EmployeeDTO getEmployee(String dni) throws SQLException;

	boolean edit(EmployeeDTO employee, String searchedEmployeeDni) throws SQLException;
}
