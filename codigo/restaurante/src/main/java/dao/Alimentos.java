package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Alimento;

public class Alimentos extends AbstractDao implements Serializable {

    private List<Alimento> alimentos;
    private static Alimentos instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Alimentos.dat";

    private Alimentos() {
        this.alimentos = new ArrayList<>();
        carregaAlimentos();
    }

    public static Alimentos getInstance() {
        if (instance == null) {
            instance = new Alimentos();
        }
        return instance;
    }

    public void addAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
        grava();
    }

    private void carregaAlimentos() {
        this.alimentos = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, alimentos);
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void excluirAlimento(Alimento alimento) {
        alimentos.remove(alimento);
        grava();
    }

    public Alimento buscarAlimentoPorNome(String nome) {

        for (Alimento alimento : alimentos) {
            if (alimento.getNome().equals(nome)) {
                return alimento;
            }
        }
        return null;
    }
}
