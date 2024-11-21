package com.aprendec.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aprendec.empresa.entities.Empleados;

public interface EmployeeRepository extends JpaRepository<Empleados, String> {
	// search an employee by dni
	Empleados findByDni(String dni);

	// search employees by categoria or anyo
	@Query("SELECT employee FROM Empleados employee WHERE employee.categoria = ?1 OR employee.anyos = ?1")
	List<Empleados> findByCategoriaOrAnyos(Integer employeeCategoriaOrAnyo);

	// search employees by sexo
	@Query("SELECT employee FROM Empleados employee WHERE employee.sexo = ?1")
	List<Empleados> findBySexo(Character sexo);

	// search employees by nombre or dni
	@Query("SELECT employee FROM Empleados employee WHERE employee.nombre LIKE ?1 OR employee.dni LIKE ?2")
	List<Empleados> findByNombreLikeOrDniLike(String nombre, String dni);
}
