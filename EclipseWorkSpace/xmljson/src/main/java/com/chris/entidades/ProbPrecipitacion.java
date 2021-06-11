package com.chris.entidades;

public class ProbPrecipitacion {
    private String periodo;
    private int probabilidad;

    public ProbPrecipitacion() {
    }

    public ProbPrecipitacion(String periodo, int probabilidad) {
        this.periodo = periodo;
        this.probabilidad = probabilidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

}
