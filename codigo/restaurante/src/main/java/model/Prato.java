package main.java.model;

public class Prato extends Alimento {
    private int quantidade;

    public Prato(int quantidade, String nome, String descricao, double valor) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return this.getQuantidade() + "%" + this.getNome() + "%" + this.getDescricao() + "%" + this.getValor();
    }
}
