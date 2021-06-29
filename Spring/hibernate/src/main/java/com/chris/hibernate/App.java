package com.chris.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chris.hibernate.entidades.Autores;
import com.chris.hibernate.entidades.Libros;

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

	public static void mostrarLibros() {
//		Query<Libros> consulta = session.createQuery("from libros ");
//		List<Libros> resultados = consulta.list();
		List<Libros> resultados = session.createQuery("from Libros").list();
		System.out.println("Imprimiendo los libros: ");
		resultados.forEach(l -> System.out.println(l));
	}

	public static void mostrarAutores() {
		List<Autores> resultados = session.createQuery("from Autores").list();
		System.out.println("Imprimiendo los autores: ");
		for (Autores autor : resultados) {
			System.out.println(autor.getCod() + " " + autor.getNombre() + " ha escrito ");
			autor.getLibroses().forEach(l -> System.out.println(l.getTitulo()));
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
		tearUp();
//		probarConexionBBDD();
//		mostrarLibros();
		mostrarAutores();
		tearDown();
	}

}
