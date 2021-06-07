package com.chris;

public class Empleado implements IEmpleado {
    private String nif;
    private String nombre;
    private double sueldoBase;
    private double horasMesExtra;
    private double irpf;
    private boolean isCasado;
    private int numeroHijos;
    static private double importeHorasExtra;

    @Override
    public double calculoComplementoHorasExtras() {
        return Empleado.importeHorasExtra * this.horasMesExtra;
    }

    @Override
    public double calculoSueldoBruto() {

        return this.sueldoBase + calculoComplementoHorasExtras();
    }

    @Override
    public double calculoretencionesIRPF() {
        double irpfFInal = (this.isCasado) ? this.irpf - 2 : this.irpf;
        irpfFInal = (numeroHijos > 0) ? (irpfFInal - numeroHijos) : irpfFInal;
        return this.calculoSueldoBruto() * (irpfFInal / 100);
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena += this.nif + " " + this.nombre + "\n";
        cadena += "Sueldo base: " + this.sueldoBase + "\n";
        cadena += "Horas extra: " + this.horasMesExtra + "\n";
        cadena += "Tipo IRPF: " + this.irpf + "\n";
        cadena += "Casado: " + ((this.isCasado) ? "Si" : "No") + "\n";
        cadena += "Numero de Hijos: " + this.numeroHijos + "\n";
        return cadena;
    }

    public Empleado() {
    }

    public Empleado(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getHorasMesExtra() {
        return horasMesExtra;
    }

    public void setHorasMesExtra(double horasMesExtra) {
        this.horasMesExtra = horasMesExtra;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

    public boolean getIsCasado() {
        return isCasado;
    }

    public void setIsCasado(boolean isCasado) {
        this.isCasado = isCasado;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public static double getImporteHorasExtra() {
        return importeHorasExtra;
    }

    public static void setImporteHorasExtra(double importeHorasExtra) {
        Empleado.importeHorasExtra = importeHorasExtra;
    }

}
