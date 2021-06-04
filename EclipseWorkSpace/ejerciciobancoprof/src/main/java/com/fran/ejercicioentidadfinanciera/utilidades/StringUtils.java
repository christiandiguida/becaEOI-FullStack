package com.fran.ejercicioentidadfinanciera.utilidades;

import java.util.List;

public class StringUtils {

	public static String obtenerParte(String linea, String separador, int parte) {
		String[] partes = linea.split(separador);  // te separa la linea en trozos
		return partes[parte];
	}
	
	public static double sumarValorPosicion(List<String> lineas, String separador, int parte) {
		double resultado = 0.0;
		//lineas.forEach(l->resultado+=Double.parseDouble(obtenerParte(l,separador,parte)));
		for(String linea: lineas) {
			resultado += Double.parseDouble(obtenerParte(linea,separador,parte));
		}
		return resultado;
	}
	
}
