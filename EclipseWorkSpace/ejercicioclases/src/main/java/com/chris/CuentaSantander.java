package com.chris;

import java.time.LocalDate;

public class CuentaSantander extends Cuenta {
    private final String codigoBanco = "0081";
    private boolean esDeSantander;
    private static int numeroCuentasSantander = 0;

    public CuentaSantander(String linea, boolean esDeSantander) {
        super(linea);
        this.esDeSantander = esDeSantander;
        numeroCuentasSantander++;
    }

    public CuentaSantander() {
        numeroCuentasSantander++;
    }

    public CuentaSantander(Cuenta c, boolean esDeSantander) {
        super(c);
        this.esDeSantander = esDeSantander;
        numeroCuentasSantander++;
    }

    public CuentaSantander(String dni, String nombre, LocalDate fecha, String codigoPais, double saldo,
            boolean esDeSantander) {
        super(dni, nombre, fecha, codigoPais, saldo);
        this.esDeSantander = esDeSantander;
        numeroCuentasSantander++;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public boolean isEsDeSantander() {
        return esDeSantander;
    }

    public void setEsDeSantander(boolean esDeSantander) {
        this.esDeSantander = esDeSantander;
    }

    public static int getNumeroCuentasSantander() {
        return numeroCuentasSantander;
    }

    public static void setNumeroCuentasSantander(int numeroCuentasSantander) {
        CuentaSantander.numeroCuentasSantander = numeroCuentasSantander;
    }

}
