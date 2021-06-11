package com.chris.entidades;

public class Localidad {
    private String nombre;
    private String provincia;
    private Prediccion prediccion;

    public Localidad(String nombre, String provincia, Prediccion prediccion) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.prediccion = prediccion;
    }

    public Localidad() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Prediccion getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(Prediccion prediccion) {
        this.prediccion = prediccion;
    }

    @Override
    public String toString() {
        return "Localidad [nombre=" + nombre + ", prediccion=" + prediccion + ", provincia=" + provincia + "]";
    }

}
