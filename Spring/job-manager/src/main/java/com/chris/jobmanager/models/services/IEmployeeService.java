package com.chris.jobmanager.models.services;

import java.util.List;

import com.chris.jobmanager.models.entity.Employees;

public interface IEmployeeService {
	public List<Employees> findAll(); // buscar todos los clientes

	public Employees findById(Integer id); // buscar un cliente por Id

	public Employees save(Employees emloyee); // Inserta un cliente en la base de datos

	public void deleteById(Integer id); // Borrara un cliente de la base de datos

	public void deleteAll(); // Borrara un cliente de la base de datos
}
