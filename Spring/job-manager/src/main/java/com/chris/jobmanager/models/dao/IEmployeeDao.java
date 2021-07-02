package com.chris.jobmanager.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chris.jobmanager.models.entity.Employees;

public interface IEmployeeDao extends CrudRepository<Employees, Integer> {

}
