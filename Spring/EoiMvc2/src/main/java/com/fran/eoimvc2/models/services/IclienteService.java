package com.fran.eoimvc2.models.services;

import java.util.List;

import com.fran.eoimvc2.models.entity.Clientes;

public interface IclienteService {

	public List<Clientes> findAll(); // buscar todos los clientes

	public Clientes findById(Long id); // buscar un cliente por Id

	public Clientes save(Clientes cliente); // Inserta un cliente en la base de datos

	public void deleteById(Long id); // Borrara un cliente de la base de datos

	public void deleteAll(); // Borrara un cliente de la base de datos
}
