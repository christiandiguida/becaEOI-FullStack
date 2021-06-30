package com.chris.jobmanager.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.jobmanager.models.dao.IEmployerDao;
import com.chris.jobmanager.models.entity.Employers;

@Service
public class EmployerServiceImpl implements IEmployerService {
	@Autowired
	private IEmployerDao employerDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employers> findAll() {
		return (List<Employers>) employerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employers findById(Integer id) {
		return employerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional // o se hace toda la transaccion o no se hace (todas las funciones en el metodo)
	public Employers save(Employers employer) {
		return employerDao.save(employer);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		employerDao.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() {
		employerDao.deleteAll();

	}
}
