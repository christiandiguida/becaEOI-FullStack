package com.chris.utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class FechasUtils {
    private static DateTimeFormatter euDateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static DateTimeFormatter esDateFormatLargoSistema = DateTimeFormatter
            .ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss ").withLocale(new Locale("es", "ES"));
    private static DateTimeFormatter enDateFormatLargoSistema = DateTimeFormatter
            .ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss ").withLocale(new Locale("en", "GB"));

    public static String obtenerFechaFormatoLargoPais(String codigoPais) {
        if (codigoPais.equals("ES")) {
            return LocalDateTime.now().format(esDateFormatLargoSistema);
        } else {
            return LocalDateTime.now().format(enDateFormatLargoSistema);
        }

    }

    public static int devolverEdad(String fechaNacimiento) {
        return Period.between(LocalDate.parse(fechaNacimiento, euDateFormat), LocalDate.now()).getYears();
    }

    public static int devolverEdadProf(String fechaNacimiento) {
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

    public static String devolverFechaMayor(List<String> fechas) {
        List<LocalDate> fechasLocalDate = new ArrayList<LocalDate>();
        fechas.forEach(f -> fechasLocalDate.add(LocalDate.parse(f, euDateFormat)));
        return devolverFechaMayorLocalDate(fechasLocalDate).format(euDateFormat).toString();
    }

    public static LocalDate devolverFechaMayorLocalDate(List<LocalDate> fechas) {
        Collections.sort(fechas);
        Collections.sort(fechas, Collections.reverseOrder());
        return fechas.get(0);
    }

    public static String devolverFechaMenor(List<String> fechas) {
        List<LocalDate> fechasLocalDate = new ArrayList<LocalDate>();
        fechas.forEach(f -> fechasLocalDate.add(LocalDate.parse(f, euDateFormat)));
        return devolverFechaMenorLocalDate(fechasLocalDate).format(euDateFormat).toString();
    }

    public static LocalDate devolverFechaMenorLocalDate(List<LocalDate> fechas) {
        Collections.sort(fechas);
        return fechas.get(0);
    }

}
