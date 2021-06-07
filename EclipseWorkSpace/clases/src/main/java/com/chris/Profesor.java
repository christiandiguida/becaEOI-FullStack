package com.chris;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Profesor extends Persona {

    private String centroTrabajo;
    private double salario;

    public Profesor() {

    }

    public Profesor(String nombre, String dni, LocalDate fechaNacimiento, char sexo, String domicilio, char estadoCivil,
            double deuda, int cuenta, String centroTrabajo, double salario) {
        super(nombre, dni, fechaNacimiento, sexo, domicilio, estadoCivil, deuda, cuenta);
        this.centroTrabajo = centroTrabajo;
        this.salario = salario;
    }

    public Profesor(Persona p, String centroTrabajo, double salario) {
        super(p);
        this.centroTrabajo = centroTrabajo;
        this.salario = salario;
    }

    public Profesor(String dni, double salario) {
        super(dni);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor [centroTrabajo=" + centroTrabajo + ", salario=" + salario + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((centroTrabajo == null) ? 0 : centroTrabajo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profesor other = (Profesor) obj;
        if (centroTrabajo == null) {
            if (other.centroTrabajo != null)
                return false;
        } else if (!centroTrabajo.equals(other.centroTrabajo))
            return false;
        return true;
    }

    public int compareTo(Profesor o) {
        return (this.getDni().equals(o.getDni()) && this.salario == o.salario) ? 1 : 0;
    }
}
