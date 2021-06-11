package com.chris.entidades;

import java.time.LocalDate;

public class Prediccion {
    private LocalDate fecha;
    private ProbPrecipitacion probPrecipitacion;

    public Prediccion() {
    }

    public Prediccion(LocalDate fecha, ProbPrecipitacion probPrecipitacion) {
        this.fecha = fecha;
        this.probPrecipitacion = probPrecipitacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ProbPrecipitacion getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(ProbPrecipitacion probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }
}
