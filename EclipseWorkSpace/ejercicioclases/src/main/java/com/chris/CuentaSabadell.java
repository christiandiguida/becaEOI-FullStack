package com.chris;

import java.time.LocalDate;

public final class CuentaSabadell extends Cuenta {
    private final String codigoBanco = "0081";
    private NivelCatalan nivelCatalan;

    public CuentaSabadell(NivelCatalan nivelCatalan) {
        this.nivelCatalan = nivelCatalan;
    }

    public CuentaSabadell(Cuenta c, NivelCatalan nivelCatalan) {
        super(c);
        this.nivelCatalan = nivelCatalan;
    }

    public CuentaSabadell(String dni, String nombre, LocalDate fecha, String codigoPais, double saldo,
            NivelCatalan nivelCatalan) {
        super(dni, nombre, fecha, codigoPais, saldo);
        this.nivelCatalan = nivelCatalan;
    }

    public CuentaSabadell(String linea, NivelCatalan nivelCatalan) {
        super(linea);
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
