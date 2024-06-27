package model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + "%";
    }
}