package com.chris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // eSet();
        // eList();
        eMap();
    }

    static List<String> strings1 = new ArrayList<String>(Arrays.asList("1", "2", "3"));

    public static void eSet() {
        // Conjunto de elementos no duplicados
        Set<String> cadenas = new HashSet<String>();
        cadenas.add("primera");
        cadenas.add("segunda");
        cadenas.add("tercera");
        Set<String> cadenas2 = new HashSet<String>(cadenas); // Crear un Set a partir de otro
        Set<String> cadenas3 = new HashSet<String>(strings1); // Crear un Set a partir de otro
        cadenas.forEach(c -> System.out.println(c));
        System.out.println(cadenas.contains("primera"));
        cadenas.addAll(strings1);
        cadenas.forEach(c -> System.out.println(c));

    }

    public static void eList() {
        List<String> cadenas = new ArrayList<>();
        cadenas.add("primera");
        cadenas.add("primera");
        cadenas.add("segunda");
        cadenas.add("tercera");
        cadenas.forEach(c -> System.out.println(c));
        System.out.println(cadenas.indexOf("primera"));
        cadenas.sort(Comparator.reverseOrder());
        cadenas.add(null);
        cadenas.forEach(c -> System.out.println(c));
        cadenas.sort(Comparator.nullsFirst(Comparator.reverseOrder()));
        cadenas.forEach(c -> System.out.println(c));
        Collections.replaceAll(cadenas, "primera", "nuevoPrimera");
        cadenas.forEach(c -> System.out.println(c));
        cadenas.addAll(strings1);
        cadenas.forEach(c -> System.out.println(c));
        System.out.println(Collections.binarySearch(cadenas, "segunda"));

    }

    public static void eMap() {
        Map<Integer, String> lenguajes = new HashMap<Integer, String>();
        lenguajes.put(1, "Java");
        lenguajes.put(2, "C#");
        lenguajes.put(3, "C++");
        lenguajes.put(1, "Python"); // No se pueden tener 2 elementos con la misma key. no falla, si no reemplaza lo
        // que ya habia.
        lenguajes.put(5, "Java"); // Se puede repetir el mismo valor
        // Iterar un Map de manera clasica
        Iterator<Integer> codigo = lenguajes.keySet().iterator();
        int posicion = 0;
        while (codigo.hasNext()) {
            posicion = codigo.next();
            System.out.println(posicion + " - " + lenguajes.get(posicion));
        }
        // Iterar un Map con Programacion funcional
        lenguajes.forEach((k, l) -> System.out.println("Clave " + k + " valor: " + l));

    }
}
