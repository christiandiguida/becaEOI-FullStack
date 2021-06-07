package com.chris;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chris.serializacion.utilidades.SerializacionUtils;

public class App {
    public static void main(String[] args) {
        // SerializacionUtils.serializarObjecto("EclipseWorkSpace/serializacion/src/main/java/com/chris/objectos.dat");
        // SerializacionUtils.desSerializarObjecto("EclipseWorkSpace/serializacion/src/main/java/com/chris/objectos.dat");
        // List<Persona> personas = new ArrayList<Persona>();
        // personas.add(new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi
        // Casa", 'S', 1000, 12345));
        // personas.add(new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi
        // Casa", 'S', 1000, 12345));
        // personas.add(new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi
        // Casa", 'S', 1000, 12345));
        // personas.add(new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi
        // Casa", 'S', 1000, 12345));
        // personas.add(new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi
        // Casa", 'S', 1000, 12345));
        // personas.add(new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi
        // Casa", 'S', 1000, 12345));
        // SerializacionUtils.serializarListaObjectos(
        // "EclipseWorkSpace/serializacion/src/main/java/com/chris/objectos.dat",
        // personas);
        List<Persona> personas = SerializacionUtils.desSerializarListaObjectosGenericos(
                "EclipseWorkSpace/serializacion/src/main/java/com/chris/objectos.dat");
        personas.forEach(p -> System.out.println(p));

    }
}
