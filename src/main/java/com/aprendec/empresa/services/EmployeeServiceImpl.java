package com.aprendec.empresa.services;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aprendec.empresa.entities.EmployeeDTO;
import com.aprendec.empresa.entities.Nominas;
import com.aprendec.empresa.entities.Empleados;
import com.aprendec.empresa.repositories.EmployeeRepository;
import com.aprendec.empresa.repositories.PayslipRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final PayslipRepository payslipRepository;
	private final PayslipService payslipService;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, PayslipService payslipService,
			PayslipRepository payslipRepository) {
		this.employeeRepository = employeeRepository;
		this.payslipRepository = payslipRepository;
		this.payslipService = payslipService;
	}

	@Override
	public List<EmployeeDTO> getEmployees() throws SQLException {
		List<Empleados> employees = employeeRepository.findAll();

		return employees.stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public String getSalary(String dni) throws SQLException {
		return payslipRepository.findSalaryByDni(dni);
	}

	@Override
	public List<EmployeeDTO> getEmployeeData(String datum) throws SQLException {
		List<Empleados> employees = null;

		try {
			Integer employeeCategoriaOrAnyo = Integer.parseInt(datum);

			employees = employeeRepository.findByCategoriaOrAnyos(employeeCategoriaOrAnyo);
		} catch (NumberFormatException e) {
			if (datum.length() == 1) {
				employees = employeeRepository.findBySexo(datum.charAt(0));
			} else {
				employees = employeeRepository.findByNombreLikeOrDniLike("%" + datum + "%", "%" + datum + "%");
			}

		}

		return employees.stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO getEmployee(String dni) throws SQLException {
		Empleados employee = employeeRepository.findByDni(dni);

		return EmployeeMapper.toDTO(employee);
	}

	@Override
	public boolean edit(EmployeeDTO employeeDTO, String searchedEmployeeDni) throws SQLException {
		Empleados newEmployee = EmployeeMapper.toEntity(employeeDTO);

		Empleados existingEmployee = employeeRepository.findByDni(searchedEmployeeDni);

		if (existingEmployee != null) {
			if (!existingEmployee.getDni().equals(newEmployee.getDni())) {
				Empleados employeeWithNewDni = employeeRepository.findByDni(newEmployee.getDni());

				if (employeeWithNewDni != null) {
					throw new SQLException();
				}

				Empleados updatedEmployee = new Empleados();

				updatedEmployee.setDni(newEmployee.getDni());
				updatedEmployee.setNombre(newEmployee.getNombre());
				updatedEmployee.setCategoria(newEmployee.getCategoria());
				updatedEmployee.setSexo(newEmployee.getSexo());
				updatedEmployee.setAnyos(newEmployee.getAnyos());

				employeeRepository.save(updatedEmployee);

				Nominas existingNomina = payslipRepository.findNominaByDni(searchedEmployeeDni);

				Nominas updatedPayslip = new Nominas();

				updatedPayslip.setDni(newEmployee.getDni());
				updatedPayslip.setSueldo(payslipService.calcSalary(newEmployee));

				payslipRepository.save(updatedPayslip);

				payslipRepository.delete(existingNomina);

				employeeRepository.delete(existingEmployee);

			} else {
				existingEmployee.setNombre(newEmployee.getNombre());
				existingEmployee.setCategoria(newEmployee.getCategoria());
				existingEmployee.setSexo(newEmployee.getSexo());
				existingEmployee.setAnyos(newEmployee.getAnyos());

				employeeRepository.save(existingEmployee);
			}

			return true;
		} else {
			throw new SQLException();
		}
	}
}
