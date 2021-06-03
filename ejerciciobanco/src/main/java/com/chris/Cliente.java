package com.chris;

import java.time.LocalDate;

public class Cliente {
    private String dniCliente;
    private String nombreCliente;
    private LocalDate fechaNacimiento;
    private int edad;
    private String codigoPais;
    private double saldo;
    private ProductoFinanciero productoFinanciero;

    public ProductoFinanciero getProductoFinanciero() {
        return productoFinanciero;
    }

    public void setProductoFinanciero(ProductoFinanciero productoFinanciero) {
        this.productoFinanciero = productoFinanciero;
    }

    public Cliente() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cliente(String dniCliente, String nombreCliente, LocalDate fechaNacimiento, String codigoPais,
            double saldo) {
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.codigoPais = codigoPais;
        this.saldo = saldo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        return "Cliente [codigoPais=" + codigoPais + ", dniCliente=" + dniCliente + ", edad=" + edad
                + ", fechaNacimiento=" + fechaNacimiento + ", nombreCliente=" + nombreCliente + ", productoFinanciero="
                + productoFinanciero + ", saldo=" + saldo + "]";
    }

}
