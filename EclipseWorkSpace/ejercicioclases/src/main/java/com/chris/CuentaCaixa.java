package com.chris;

import java.time.LocalDate;

enum NivelCatalan {
    ALTO, MEDIO, BAJO
}

public final class CuentaCaixa extends Cuenta {

    private final String codigoBanco = "2100";
    private NivelCatalan nivelCatalan;

    public CuentaCaixa(String linea, NivelCatalan nivelCatalan) {
        super(linea);
        this.nivelCatalan = nivelCatalan;
    }

    public CuentaCaixa(Cuenta c, NivelCatalan nivelCatalan) {
        super(c);
        this.nivelCatalan = nivelCatalan;
    }

    public CuentaCaixa() {

    }

    public CuentaCaixa(String dni, String nombre, LocalDate fecha, String codigoPais, double saldo,
            NivelCatalan nivelCatalan) {
        super(dni, nombre, fecha, codigoPais, saldo);
        this.nivelCatalan = nivelCatalan;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public NivelCatalan getNivelCatalan() {
        return nivelCatalan;
    }

    public void setNivelCatalan(NivelCatalan nivelCatalan) {
        this.nivelCatalan = nivelCatalan;
    }

}
