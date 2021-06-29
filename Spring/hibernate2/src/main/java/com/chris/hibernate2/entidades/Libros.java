package com.chris.hibernate2.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libros implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private Set<Autores> autoreses = new HashSet<Autores>(0);

	public Libros() {
	}

	public Libros(int id) {
		this.id = id;
	}

	public Libros(int id, String titulo, Set<Autores> autoreses) {
		this.id = id;
		this.titulo = titulo;
		this.autoreses = autoreses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "titulo", length = 60)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "escribir", joinColumns = {
			@JoinColumn(name = "codlibro", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "codautor", nullable = false, updatable = false) })
	public Set<Autores> getAutoreses() {
		return this.autoreses;
	}

	public void setAutoreses(Set<Autores> autoreses) {
		this.autoreses = autoreses;
	}

}
