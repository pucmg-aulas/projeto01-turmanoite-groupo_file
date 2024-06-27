package model;

public class Credito extends MetodoPagamento {
    public Credito() {
        super(30, 3.1);
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        return valorOriginal * (descontoPercentual / 100);
    }
}