package model;

import java.io.Serializable;

public class Mesa implements Serializable {

    private int numero;
    private int quantidade;
    private boolean ocupada;

    public Mesa(int quantidade) {
        this.quantidade = quantidade;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isOcupada() { // retorna o status da mesa
        return ocupada;
    }

    public void setOcupada(boolean ocupada) { // mudar o status da mesa quando um cliente ocupa/libera
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return numero + "%" + quantidade + "%" + ocupada;
    }
}