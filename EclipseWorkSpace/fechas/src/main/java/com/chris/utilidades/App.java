package com.chris.utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(FechasUtils.obtenerFechaFormatoLargoPais("ES"));
        System.out.println(FechasUtils.devolverEdad("29/09/1996"));
        List<String> fechas = new ArrayList<>(Arrays.asList("10/01/2000", "10/09/2021", "29/8/1998"));
        System.out.println(FechasUtils.devolverFechaMenor(fechas));
        System.out.println(FechasUtils.devolverFechaMayor(fechas));

    }
}
