package com.chris;

public class ProductoFinanciero {

    private int edadMinima;
    private int edadMaxima;
    private double saldoMinimo;
    private double saldoMaximo;
    private String nombreProducto;

    public ProductoFinanciero(int edadMinima, int edadMaxima, double saldoMinimo, double saldoMaximo,
            String nombreProducto) {
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.saldoMinimo = saldoMinimo;
        this.saldoMaximo = saldoMaximo;
        this.nombreProducto = nombreProducto;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public double getSaldoMaximo() {
        return saldoMaximo;
    }

    public void setSaldoMaximo(double saldoMaximo) {
        this.saldoMaximo = saldoMaximo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        return "ProductoFinanciero [edadMaxima=" + edadMaxima + ", edadMinima=" + edadMinima + ", nombreProducto="
                + nombreProducto + ", saldoMaximo=" + saldoMaximo + ", saldoMinimo=" + saldoMinimo + "]";
    }

}
