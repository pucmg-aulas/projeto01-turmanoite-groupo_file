package model;

public class Dinheiro extends MetodoPagamento {
    public Dinheiro() {
        super(0, 0);
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        return 0;
    }
}