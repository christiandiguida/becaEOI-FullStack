package com.fran.ejercicioentidadfinanciera.utilidades;

import java.util.List;

public class MenuUtils {

	public static void imprimirMenu(List<String> opciones) {
		for(int i=0; i<opciones.size();i++) {
			System.out.println((i+1) + ". " + opciones.get(i));
		}
	}
	
	public static void imprimirMenu(String... opciones) {
		int iterador = 1;
		for(String opcion : opciones) {
			System.out.println(iterador++ + ". " + opcion);			
		}
		System.out.println("0. Salir");
	}
	
	
}
