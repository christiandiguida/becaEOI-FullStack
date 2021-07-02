package com.chris.jobmanager.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.jobmanager.models.dao.IEmployeeDao;
import com.chris.jobmanager.models.entity.Employees;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employees> findAll() {
		return (List<Employees>) employeeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employees findById(Integer id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional // o se hace toda la transaccion o no se hace (todas las funciones en el metodo)
	public Employees save(Employees employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		employeeDao.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() {
		employeeDao.deleteAll();

	}
}
