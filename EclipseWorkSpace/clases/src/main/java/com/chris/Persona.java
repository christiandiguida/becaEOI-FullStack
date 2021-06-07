package com.chris;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Persona {

    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private char sexo;
    private String domicilio;
    private char estadoCivil;
    private double deuda;
    private int cuenta;

    final private int MAYORIAEDAD = 18;

    public Persona() {
    }

    public Persona(Persona p) {
        this.nombre = p.nombre;
        this.dni = p.dni;
        this.fechaNacimiento = p.fechaNacimiento == null ? LocalDate.of(1976, 7, 27) : p.fechaNacimiento;
        this.sexo = p.sexo;
        this.domicilio = p.domicilio;
        this.estadoCivil = p.estadoCivil;
        this.deuda = p.deuda;
        this.cuenta = p.cuenta;
    }

    public Persona(String nombre, String dni, LocalDate fechaNacimiento, char sexo, String domicilio, char estadoCivil,
            double deuda, int cuenta) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.domicilio = domicilio;
        this.estadoCivil = estadoCivil;
        this.deuda = deuda;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Persona [cuenta=" + cuenta + ", deuda=" + deuda + ", dni=" + dni + ", domicilio=" + domicilio
                + ", estadoCivil=" + estadoCivil + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre
                + ", sexo=" + sexo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    // Comparacion nombre-DNI
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    public boolean mayorEdad() {
        return this.getFechaNacimiento().getYear() >= MAYORIAEDAD ? true : false;

    }
}
