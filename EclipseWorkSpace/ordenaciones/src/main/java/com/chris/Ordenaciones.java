package com.chris;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Ordenaciones {

    public static void main(String[] args) {
        eOrdenaciones();
    }

    public static void eOrdenaciones() {
        // a, A, á
        // Diferencia primaria: a, b son diferentes
        // Diferencia secundaria: a, á son diferentes (tildes)
        // Diferencia terciaria: a, A son diferentes (case Sensitive)
        List<String> provincias = new ArrayList<String>(
                Arrays.asList("Alicante", "málaga", "Álava", "alava", "Alava", "Valencia", "álava"));
        String[] provinciasArray = provincias.toArray(new String[0]);
        // Arrays.sort(provinciasArray);
        // for (int i = 0; i < provinciasArray.length; i++) {
        // System.out.println(provinciasArray[i]);
        // }
        // Pasar de Array a Lista
        /*
         * List<String> listaDelArray = new
         * ArrayList<String>(Arrays.asList(provinciasArray)); listaDelArray.forEach(p ->
         * System.out.println(p));
         */

        List<String> provincias2 = new ArrayList<String>(provincias);
        List<String> provincias3 = new ArrayList<String>(provincias);
        List<String> provincias4 = new ArrayList<String>(provincias);
        List<String> provincias5 = new ArrayList<String>(provincias);

        Collator primaria = Collator.getInstance(new Locale("es"));
        Collator secundaria = Collator.getInstance(new Locale("es"));
        Collator terciaria = Collator.getInstance(new Locale("es"));
        Collator identical = Collator.getInstance(new Locale("es"));
        primaria.setStrength(Collator.PRIMARY);
        secundaria.setStrength(Collator.SECONDARY);
        terciaria.setStrength(Collator.TERTIARY);
        identical.setStrength(Collator.IDENTICAL);
        Collections.sort(provincias, Comparator.naturalOrder());
        provincias2.sort(primaria);
        provincias3.sort(secundaria);
        provincias4.sort(terciaria);
        provincias5.sort(identical);
        provincias.forEach(p -> System.out.println("Original " + p));
        System.out.println("**************");
        provincias2.forEach(p -> System.out.println("Primaria " + p));
        System.out.println("**************");
        provincias3.forEach(p -> System.out.println("Secundaria " + p));
        System.out.println("**************");
        provincias4.forEach(p -> System.out.println("Terciaria " + p));
        System.out.println("**************");
        provincias5.forEach(p -> System.out.println("Identical " + p));

    }
}
