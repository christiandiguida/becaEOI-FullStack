package com.fran.eoimvc2.models.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String email;
	private String nombre;

	public ClienteDTO() {
	}

	public ClienteDTO(long id, String email, String nombre) {
		super();
		this.id = id;
		this.email = email;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
