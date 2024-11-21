package com.aprendec.empresa.services;

import org.springframework.stereotype.Service;

import com.aprendec.empresa.entities.Empleados;

@Service
public class PayslipServiceImpl implements PayslipService {
	// calcular sueldo
	private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	@Override
	public Integer calcSalary(Empleados employeeImpl) {
		return SUELDO_BASE[employeeImpl.getCategoria()] + 5000 * employeeImpl.getAnyos();
	}
}
