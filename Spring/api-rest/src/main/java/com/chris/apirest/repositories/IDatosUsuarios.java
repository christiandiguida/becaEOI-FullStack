package com.chris.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.apirest.models.entity.DatosUsuario;

public interface IDatosUsuarios extends JpaRepository<DatosUsuario, Integer> {

}
