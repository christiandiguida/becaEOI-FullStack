package com.chris.ejerciciosGenerales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chris.ejerciciosGenerales.utilidades.MathUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// ejercicio1();
		// ejercicio2();
		// ejercicio3();
		// ejercicio5();
		// ejercicio6();
		// ejercicio7();
		ejercicio12();
	}

	public static void ejercicio1() {
		System.out.print("Insertar el primer valor que se quiere intercambiar: ");
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.print("Insertar el segundo valor que se quiere intercambiar: ");
		b = sc.nextInt();
		System.out.println("Los valores iniciales son: A = " + a + " y B = " + b);
		c = a;
		a = b;
		b = c;
		System.out.println("Los valores intercambiados son: A = " + a + " y B = " + b);
	}

	public static void ejercicio2() {
		System.out.println("Insertar un numero por calcular su numero de cifras: ");
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextLong()) {
			System.out.println("El valor insertado no es un numero. Inserta un nuevo numero: ");
			sc.next();
		}
		Long numeroPorCalcular = sc.nextLong();
		System.out.println("El numero insertado es " + numeroPorCalcular
				+ " y el numero de cifras del numero insertado es: " + numeroPorCalcular.toString().length());
	}

	public static void ejercicio3() {
		String repetir;
		do {
			System.out.println("Covertidor de grados centigrados a Kelvin.");
			System.out.println("Insertar los grados centigrados que se quieren convertir:");
			Scanner sc = new Scanner(System.in);
			int temperatura = sc.nextInt();
			System.out.println(temperatura + " °C son " + (temperatura + 273) + " °K.");
			System.out.println("Quieres repetir el proceso? (S/N)");
			repetir = sc.next();
			System.out.println(repetir);
		} while (repetir.toUpperCase().equals("S"));
		System.out.println("Programa Terminado. Hasta Lluego!");
	}

	public static void ejercicio5() {
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		int counter = 0;
		System.out.println("Insertar un numero hasta que sea negativo");
		while (numero >= 0) {
			numero = sc.nextInt();
			if (numero % 10 == 2) {
				counter++;
			}
		}
		System.out.println("Programa terminado.");
		System.out.println("Se han insertado " + counter + " numeros que terminan con 2.");
	}

	public static void ejercicio6() {
		System.out.println("Insertar dos numero para comprobar si son amigos.");
		System.out.println("Insertar el primer numero: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("Insertar el segundo numero: ");
		int b = sc.nextInt();
		if (MathUtils.sonAmigos(a, b)) {
			System.out.println(a + " y " + b + " son numeros amigos.");
		} else {
			System.out.println(a + " y " + b + " no son numeros amigos.");
		}

	}

	public static void ejercicio7() {
		System.out.println("Insertar un numero: ");
		Scanner sc = new Scanner(System.in);
		int num1 = 1, num2 = 0;
		List<Integer> list = new ArrayList<Integer>();
		int primerosNumeros = sc.nextInt();
		for (int i = 0; i < primerosNumeros; i += 2) {
			num1 += num2;
			list.add(num1);
			num2 += num1;
			list.add(num2);
		}
		list.forEach(n -> System.out.println(n));
	}

	public static void ejercicio12() {
		System.out.println("Insertar un numero: ");
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		StringBuffer newString = new StringBuffer(n.toString()).reverse();
		System.out.println((n.toString().equals(newString.toString())) ? "Numero capicúa" : "Numero no capicúa");

	}
}
