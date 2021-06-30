package com.fran.eoimvc2.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fran.eoimvc2.models.entity.Clientes;

public interface IclienteDao extends CrudRepository<Clientes,Long> {

}
