package com.aprendec.empresa.services;

import com.aprendec.empresa.entities.Empleados;

public interface PayslipService {
	Integer calcSalary(Empleados employeeImpl);
}
