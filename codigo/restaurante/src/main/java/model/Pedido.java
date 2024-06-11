package main.java.model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private Alimento alimento;
    private int quantidade;
    private double valorTotal;

    public Pedido(Alimento alimento, int quantidade) {
        this.alimento = alimento;
        this.quantidade = quantidade;
    }

    public Pedido(Alimento alimento, int quantidade, double valorTotal) {
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        valorTotal = alimento.getValor() * quantidade;
        return valorTotal;
    }

    @Override
    public String toString() {
        return alimento + "%" + quantidade + " %" + getValorTotal();
    }
}
