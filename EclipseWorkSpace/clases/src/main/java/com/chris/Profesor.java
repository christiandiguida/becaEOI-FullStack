package com.chris;

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

}
