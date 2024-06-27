package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.*;

/**
 *
 * @author danil
 */
public class Atendimentos extends AbstractDAO implements Serializable {

    private List<Atendimento> atendimentos;
    private static Atendimentos instance;

    private final String arq = "./src/main/java/data/Atendimentos.dat";

    private Atendimentos() {
        this.atendimentos = new ArrayList<>();
        carregaAtendimentos();
    }

    public static Atendimentos getInstance() {
        if (instance == null) {
            instance = new Atendimentos();
        }
        return instance;
    }

    public void addAtendimento(Atendimento atendimento) {
        this.atendimentos.add(atendimento);
        grava();
    }

    private void carregaAtendimentos() {
        this.atendimentos = super.leitura(arq);
    }

    private void grava() {
        super.grava(arq, atendimentos);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void excluirAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
        grava();
    }

    public Optional<Atendimento> buscarAtendimentoPorNome(String nome) {
        return atendimentos.stream()
                           .filter(atendimento -> atendimento.getCliente().getNome().equals(nome))
                           .findFirst();
    }

    public boolean altera(Atendimento atendimentoExistente, Cliente nome) {
        try {
            atendimentos = atendimentos.stream()
                                       .map(atendimento -> atendimento.getCliente().getNome().equals(nome) ? atendimentoExistente : atendimento)
                                       .collect(Collectors.toList());
            grava();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
