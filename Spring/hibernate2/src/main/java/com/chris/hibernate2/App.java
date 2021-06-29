package com.chris.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	static SessionFactory sessionFactory = null;
	static Session session = null;

	// Abre la sesión
	public static void tearUp() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}

	// Cierra la sesión
	public static void tearDown() {
		session.close();
	}

	public static void probarConexionBBDD() {
		System.out.println((session != null) ? "Sesión abierta" : "Fallo en la sesión");
	}

	public static void main(String[] args) {

	}
}
