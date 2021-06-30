package com.chris.jobmanager.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chris.jobmanager.models.entity.Employers;

public interface IEmployerDao extends CrudRepository<Employers, Integer> {

}
