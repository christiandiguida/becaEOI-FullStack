package com.chris.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.apirest.models.entity.Evento;

public interface IUsuario extends JpaRepository<Evento, Integer> {

}
