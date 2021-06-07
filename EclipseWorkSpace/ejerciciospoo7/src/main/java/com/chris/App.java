package com.chris;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce el numero de empleados");
        int numEmpleados = Integer.parseInt(sc.nextLine());
        if (numEmpleados > 20) {
            numEmpleados = 20;
        }
        Empleado[] empleados = new Empleado[numEmpleados];
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Introduzca Nif: ");
            empleados[i] = new Empleado(sc.nextLine());
            System.out.println("Introduzca Nombre: ");
            empleados[i].setNombre(sc.nextLine());
            System.out.println("Introduzca SueldoBase: ");
            empleados[i].setSueldoBase(sc.nextDouble());
            System.out.println("Introduzca Horas Extra: ");
            empleados[i].setHorasMesExtra(sc.nextDouble());
            System.out.println("Introduzca  IRPF: ");
            empleados[i].setIrpf(sc.nextDouble());
            System.out.println("Introduzca  si esta casado: (s/n): ");
            empleados[i].setIsCasado(sc.next().toLowerCase().charAt(0) == 's' ? true : false);
            System.out.print("Introduzca  numero de hjos: ");
            empleados[i].setNumeroHijos(sc.nextInt());
            sc.nextLine();
        }
        System.out.println("Introduzca el precio de la horas extra:");
        Empleado.setImporteHorasExtra(sc.nextDouble());

        Arrays.sort(empleados, (e1, e2) -> Double.compare(e1.calculoSueldoBruto() - e1.calculoretencionesIRPF(),
                e2.calculoSueldoBruto() - e2.calculoretencionesIRPF()));
        System.out.println(empleados[numEmpleados - 1]);
        System.out.println(empleados[0]);
        Arrays.sort(empleados,
                (e1, e2) -> Double.compare(e1.calculoComplementoHorasExtras(), e2.calculoComplementoHorasExtras()));
        System.out.println(empleados[numEmpleados - 1]);
        System.out.println(empleados[0]);
        Arrays.sort(empleados, (e1, e2) -> Double.compare(e1.calculoSueldoBruto(), e2.calculoSueldoBruto()));
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}
