package com.chris.jobmanager.models.services;

import java.util.List;

import com.chris.jobmanager.models.entity.Employers;

public interface IEmployerService {
	public List<Employers> findAll(); // buscar todos los clientes

	public Employers findById(Integer id); // buscar un cliente por Id

	public Employers save(Employers employer); // Inserta un cliente en la base de datos

	public void deleteById(Integer id); // Borrara un cliente de la base de datos

	public void deleteAll(); // Borrara un cliente de la base de datos
}
