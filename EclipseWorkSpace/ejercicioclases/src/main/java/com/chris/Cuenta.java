package com.chris;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Cuenta implements Comparable<Cuenta> {

    private String dni;
    private String nombre;
    private LocalDate fecha;
    private String codigoPais;
    private double saldo;

    public Cuenta() {

    }

    public Cuenta(Cuenta c) {
        this.dni = c.dni;
        this.nombre = c.nombre;
        this.fecha = c.fecha;
        this.codigoPais = c.codigoPais;
        this.saldo = c.saldo;
    }

    public Cuenta(String dni, String nombre, LocalDate fecha, String codigoPais, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecha = fecha;
        this.codigoPais = codigoPais;
        this.saldo = saldo;
    }

    public Cuenta(String linea) {
        String[] valores = linea.split(";");
        this.dni = valores[0];
        this.nombre = valores[1];
        this.fecha = LocalDate.parse(valores[2], DateTimeFormatter.ofPattern("d/M/yyyy"));
        this.codigoPais = valores[3];
        this.saldo = Double.parseDouble(valores[4]);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [codigoPais=" + codigoPais + ", dni=" + dni + ", fecha=" + fecha + ", nombre=" + nombre
                + ", saldo=" + saldo + "]";
    }

    @Override

    public int compareTo(Cuenta o) {
        if (this.getDni().compareTo(o.getDni()) < 0) {
            return -1;
        } else if (this.getDni().compareTo(o.getDni()) > 0) {
            return 1;
        } else {
            if (this.saldo < o.saldo) {
                return -1;
            } else if (this.saldo > o.saldo) {
                return 1;
            } else
                return 0;
        }
    }

    public static <T extends Cuenta> void imprimirLista(List<T> lista) {
        lista.forEach(l -> System.out.println(l));
    }

    public static <T extends Cuenta> void imprimirLista(List<T> lista, Class<T> clase) {
        System.out.println("*****" + clase.getName() + "*****");
        lista.forEach(l -> System.out.println(l));
    }

    public static <T extends Cuenta> void imprimirListaHijos(List<T> lista) {
        lista.forEach(l -> {
            if (l instanceof CuentaCaixa) {
                System.out.println("Cuenta Caixa: " + l + "\n");
            } else if (l instanceof CuentaSabadell) {
                System.out.println("Cuenta Sabadell: " + l + "\n");

            } else if (l instanceof CuentaSantander) {
                System.out.println("Cuenta Santander: " + l + "\n");
            }
        });
    }

}
