package com.chris;

public class Clientes {
    private String dni;
    private String nombre;
    private double saldoTotal;

    public Clientes(String dni, String nombre, double saldoTotal) {
        this.dni = dni;
        this.nombre = nombre;
        this.saldoTotal = saldoTotal;
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

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    @Override
    public String toString() {
        return "Clientes [dni=" + dni + ", nombre=" + nombre + ", saldoTotal=" + saldoTotal + "]";
    }

}
