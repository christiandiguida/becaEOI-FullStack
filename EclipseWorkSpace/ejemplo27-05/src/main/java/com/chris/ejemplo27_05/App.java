package com.chris.ejemplo27_05;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
//	ejemploScanner();
//	ejemploTernarias();
//	curiosidadInteger();
//	ejemploConversiones();
//	ejemplosString();
	ejemplosInmutabilidad();

    }

    public static void ejemploScanner() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduzca texto: ");
	String texto = sc.nextLine();
	System.out.println(texto);
	System.out.println("Introduzca numero: ");
	int numero = sc.nextInt();
	System.out.println(numero);

    }

    public static void ejemploTernarias() {
	int a = 10;
	int b = a == 10 ? 3 : 2;
	System.out.println(b);

    }

    public static void ejemploWrapper() {

	int a = 10;
	Integer a2 = 10;
	int a3 = a2;
	Integer a4 = a;

	String cadena = String.valueOf(a2);
	System.out.println(cadena);
    }

    public static void ejemploConversiones() {
	int numero = 27;
	Integer numero2 = 27;
	int otroNumero = Integer.parseInt("2");
    }

    public static void curiosidadInteger() {
	Integer a = 127;
	Integer a1 = 127;
	System.out.println(a.compareTo(a1));
    }

    // los 3 tipos de comentario
    /*
     * los 3 tipos de comentario: multilinea
     */
    /**
     * Comentario por el Java Doc
     */
    public static void ejemplosString() {
	String cadena = "hola ";
//	System.out.println("Longitud: " + cadena.length());
//	System.out.println(cadena.toLowerCase().indexOf("mu"));
//	System.out.println("Introduce cadena a buscar: ");
//	Scanner sc = new Scanner(System.in);
//	String cadenaIntroducida = sc.nextLine().toLowerCase();
//	System.out.println(cadena.toLowerCase().indexOf(cadenaIntroducida));
//	System.out.println(cadena.substring(2, 4));
//	System.out.println(cadena.equals("hola Mundo"));
//	int numero = 20;
//	cadena = ejemplosConcatenar(cadena);
//	System.out.println(cadena);

    }

    public static void ejemplosInmutabilidad() {
// Nunca se distruye uno String si no siempre, 
//cuando es declarado otra vez, se destruye y se crea uno nuevo
//	String cadena = "Hola ";
//	cadena += "Mundo";
//	System.out.println(cadena);
//	StringBuffer cadenaBuffer = new StringBuffer("Hola");
//	StringBuilder cadenaBuilder = new StringBuilder("Hola");
//	ejemplosConcatenar(cadenaBuilder);
//	System.out.println(cadenaBuffer);
//	System.out.println(cadenaBuilder);
//	ejemplosConcatenar("Hola");
	int a = 1;
	int b = 2;
	System.out.println(e(a, b));
	System.out.println(2147483647 + 1);
	System.out.println(Long.MAX_VALUE - Long.MIN_VALUE);
    }

    public static int e(int a, int b) {
	return a += 1;
    }

    public static String ejemplosConcatenar(String param) {
	int a = 1;
	return param += "Fran";
    }

    public static void ejemplosConcatenar(StringBuilder param) {
	param.append(" Fran");
    }
}
