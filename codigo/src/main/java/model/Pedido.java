package model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private ItensCardapio alimento;
    private int quantidade;
    private double valorTotal;

    public Pedido(ItensCardapio alimento, int quantidade) {
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.valorTotal = alimento.getValor() * quantidade;
    }

    public Pedido(ItensCardapio alimento, int quantidade, double valorTotal) {
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public ItensCardapio getAlimento() {
        return alimento;
    }

    public void setAlimento(ItensCardapio alimento) {
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

    public double getValorUnitario() {
        return alimento.getValor();
    }

    @Override
    public String toString() {
        return alimento.getNome() + "%" + quantidade + "%" + getValorUnitario() + "%" + getValorTotal();
    }
}
