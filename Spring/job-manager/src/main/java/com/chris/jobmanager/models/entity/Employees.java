package com.chris.jobmanager.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees", schema = "public")
public class Employees implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Employers employers;
	private String name;
	private String surname;
	private String email;
	private String phone;

	public Employees() {
	}

	public Employees(int id, Employers employers, String name, String surname, String email, String phone) {
		this.id = id;
		this.employers = employers;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idemp")
	public Employers getEmployers() {
		return this.employers;
	}

	public void setEmployers(Employers employers) {
		this.employers = employers;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", nullable = false)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
