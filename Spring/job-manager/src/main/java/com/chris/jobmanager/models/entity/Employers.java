package com.chris.jobmanager.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employers", schema = "public")
public class Employers implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private String company;
	private String email;
	private List<Employees> employees = new ArrayList<Employees>();

	public Employers() {
	}

	public Employers(int id, String name, String surname, String company, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.company = company;
		this.email = email;
	}

	public Employers(int id, String name, String surname, String company, String email, List<Employees> employeeses) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.company = company;
		this.email = email;
		this.employees = employeeses;
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

	@Column(name = "company", nullable = false)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employers", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Employees> getEmployeeses() {
		return this.employees;
	}

	public void setEmployeeses(List<Employees> employeeses) {
		this.employees = employeeses;
	}

}
