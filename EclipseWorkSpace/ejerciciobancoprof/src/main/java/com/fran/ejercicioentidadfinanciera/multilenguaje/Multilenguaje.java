package com.fran.ejercicioentidadfinanciera.multilenguaje;

public class Multilenguaje {
	
	public static String hello;
	public static String bye;
	public static String correct_opcion;
	
	public Multilenguaje(String lenguaje) {
		construirLenguaje(lenguaje);
	}
	
	private void construirLenguaje(String lenguaje) {
		if(lenguaje.equals("ES")) {
			this.hello = "Hola";
			this.bye = "Adiós";
			this.correct_opcion = "Introduzca la opción correcta:";
		} else if(lenguaje.equals("CA")) {
			this.hello = "Hola";
			this.bye = "Adeu";
			this.correct_opcion = "Introduzca la opción correcta:";
		} else {
			this.hello = "Hello";
			this.bye = "Bye";
			this.correct_opcion = "Choose the correct answer:";
		}			
	}
}
