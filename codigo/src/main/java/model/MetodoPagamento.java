package model;

import java.io.Serializable;

public abstract class MetodoPagamento implements Serializable {
    protected int prazoDias;
    protected double descontoPercentual;

    public MetodoPagamento(int prazoDias, double descontoPercentual) {
        this.prazoDias = prazoDias;
        this.descontoPercentual = descontoPercentual;
    }

    public abstract double calcularDesconto(double valorOriginal);

    public int getPrazoDias() {
        return prazoDias;
    }

}