package com.chris.ejerciciosGenerales.utilidades;

public class MathUtils {

    public static boolean sonAmigos(int numA, int numB) {
	int sumA = 0, sumB = 0;
	int mayor = (numA >= numB) ? numA : numB;
	for (int i = 1; i <= (mayor / 2); i++) {
	    if (numA % i == 0) {
		sumA += i;
	    }

	    if (numB % i == 0) {

		sumB += i;
	    }
	}

	return (sumA == numB && sumB == numA) ? true : false;

    }

}
