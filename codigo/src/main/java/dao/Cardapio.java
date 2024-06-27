package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 *
 * @author danil
 */
public class Cardapio extends AbstractDAO implements Serializable {

    private List<ItensCardapio> alimentos;
    private static Cardapio instance;

    private final String arq = "./src/main/java/data/Alimentos.dat";

    private Cardapio() {
        this.alimentos = new ArrayList<>();
        carregaAlimentos();
    }

    public static Cardapio getInstance() {
        if (instance == null) {
            instance = new Cardapio();
        }
        return instance;
    }

    public void addAlimento(ItensCardapio alimento) {
        this.alimentos.add(alimento);
        grava();
    }

    private void carregaAlimentos() {
        this.alimentos = super.leitura(arq);
    }

    private void grava() {
        super.grava(arq, alimentos);
    }

    public List<ItensCardapio> getAlimentos() {
        return alimentos;
    }

    public void excluirAlimento(ItensCardapio alimento) {
        alimentos.remove(alimento);
        grava();
    }

    public ItensCardapio buscarAlimentoPorNome(String nome) {
    return alimentos.stream()
                    .filter(alimento -> alimento.getNome().equals(nome))
                    .findFirst()
                    .orElse(null);
    }
}
