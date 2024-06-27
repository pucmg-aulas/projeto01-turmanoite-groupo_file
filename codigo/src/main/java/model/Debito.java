package model;

public class Debito extends MetodoPagamento {
    public Debito() {
        super(14, 1.4);
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        return valorOriginal * (descontoPercentual / 100);
    }
}