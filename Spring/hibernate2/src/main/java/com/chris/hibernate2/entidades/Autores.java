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
@Table(name = "autores")
public class Autores implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String cod;
	private String nombre;
	private Set<Libros> libroses = new HashSet<Libros>(0);

	public Autores() {
	}

	public Autores(String cod) {
		this.cod = cod;
	}

	public Autores(String cod, String nombre, Set<Libros> libroses) {
		this.cod = cod;
		this.nombre = nombre;
		this.libroses = libroses;
	}

	@Id

	@Column(name = "cod", unique = true, nullable = false, length = 5)
	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Column(name = "nombre", length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "escribir", joinColumns = {
			@JoinColumn(name = "codautor", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "codlibro", nullable = false, updatable = false) })
	public Set<Libros> getLibroses() {
		return this.libroses;
	}

	public void setLibroses(Set<Libros> libroses) {
		this.libroses = libroses;
	}

}
