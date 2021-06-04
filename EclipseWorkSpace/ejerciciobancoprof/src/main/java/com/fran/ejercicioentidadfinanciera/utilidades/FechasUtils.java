package com.fran.ejercicioentidadfinanciera.utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FechasUtils {

	private static DateTimeFormatter esFechaCorta = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static DateTimeFormatter DateFormatLargoSistema = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss").withLocale(new Locale(System.getProperty("user.language"),System.getProperty("user.country")));
	private static DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	private static DateTimeFormatter esDateFormatLargo = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss")
			.withLocale(new Locale("es","ES"));
	private static DateTimeFormatter enDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
	private static DateTimeFormatter enDateFormatLargo = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy hh:mm:ss")
			.withLocale(new Locale("en","GB"));
	
	public final static int MAYORIA_EDAD = 18;
	
	/**
	 * Obtenemos una cadena de texto en formato largo (ej. miércoles, 02 de junio de 2021 a las 11:44:42)
	 * @param codigoPais Introducimos "ES" para España, y cualquier otro código será en inglés
	 * @return String con un formato como el ejemplo
	 */
	public static String obtenerFechaFormatoLargoPais(String codigoPais) {
		if(codigoPais.equals("ES")) {
			return LocalDateTime.now().format(esDateFormatLargo);
		} else {
			return LocalDateTime.now().format(enDateFormatLargo);
		}
	}
	
	/**
	 * Nos devuelve el número de años que tiene la persona.
	 * @param fechaNacimiento debe ser en formato (dd/mm/aaaa)
	 * @return int con los años
	 */
	public static int devolverEdad(String fechaNacimiento) {
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return Period.between(fechaNac, LocalDate.now()).getYears();
	}
	
	public static boolean esMayorEdad(String fechaNacimiento) {
		if(devolverEdad(fechaNacimiento)>=MAYORIA_EDAD) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean esMayorDe(String fechaNacimiento,int anyos) {
		if(devolverEdad(fechaNacimiento)>=anyos) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String devolverFechaMayor(List<String> fechas, DateTimeFormatter formato) {
		List<LocalDate> fechasLocalDate = new ArrayList<LocalDate>();
		fechas.forEach(f->fechasLocalDate.add(LocalDate.parse(f,formato)));
		return devolverFechaMayorLocalDate(fechasLocalDate).format(formato).toString();	
	}
	
	public static String devolverFechaMayor(List<String> fechas) {
		return devolverFechaMayor(fechas, esFechaCorta);
	}
	
	public static String devolverFechaMenor(List<String> fechas) {
		List<LocalDate> fechasLocalDate = new ArrayList<LocalDate>();
		fechas.forEach(f->fechasLocalDate.add(LocalDate.parse(f,esFechaCorta)));
		return devolverFechaMenorLocalDate(fechasLocalDate).format(esFechaCorta).toString();	
	}
	
	public static LocalDate devolverFechaMenorLocalDate(List<LocalDate> fechas) {
		Collections.sort(fechas);
		return fechas.get(0);
		/*List<LocalDate> fechasOrdenadas = fechas.stream()
				.sorted()
				.collect(Collectors.toList());*/
	}
	
	public static LocalDate devolverFechaMayorLocalDate(List<LocalDate> fechas) {
		Collections.sort(fechas,Collections.reverseOrder());
		return fechas.get(0);
	}

}
