package com.aprendec.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aprendec.empresa.entities.Nominas;

@Repository
public interface PayslipRepository extends JpaRepository<Nominas, String> {
	// search an employee salary
	@Query("SELECT nomina.sueldo FROM Nominas nomina WHERE nomina.dni = ?1")
	String findSalaryByDni(String dni);
	
	@Query("SELECT nomina FROM Nominas nomina WHERE nomina.dni = ?1")
	Nominas findNominaByDni(String dni);
}
