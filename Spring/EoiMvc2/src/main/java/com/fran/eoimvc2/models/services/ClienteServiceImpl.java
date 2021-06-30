package com.fran.eoimvc2.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.eoimvc2.models.dao.IclienteDao;
import com.fran.eoimvc2.models.entity.Clientes;

@Service
public class ClienteServiceImpl implements IclienteService {

	@Autowired
	private IclienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Clientes> findAll() {
		return (List<Clientes>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Clientes findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional // o se hace toda la transaccion o no se hace (todas las funciones en el metodo)
	public Clientes save(Clientes cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() {
		clienteDao.deleteAll();

	}

}
