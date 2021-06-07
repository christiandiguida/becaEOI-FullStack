package com.chris;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

public class App {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi Casa", 'S', 1000, 12345);
        Persona p3 = new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi Casa", 'S', 1000, 12345);

        if (p3.equals(p1)) {
            System.out.println("Son la misma persona");
        } else {
            System.out.println("No son la misma persona");
        }

        Persona p6 = new Persona(p3);
        if (p6.equals(p3)) {
            System.out.println("Son la misma persona");
        } else {
            System.out.println("No son la misma persona");
        }
        if (p3.mayorEdad()) {
            System.out.println("Es mayor edad");
        }

        Profesor pr1 = new Profesor();

        pr1.setNombre("Christian");
        System.out.println(pr1);

    }
}
