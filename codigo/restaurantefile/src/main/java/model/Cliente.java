package model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private int quantidade;

    public Cliente(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    // Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
