package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.model.Atendimento;

public class Historico extends AbstractDao implements Serializable {

    private List<Atendimento> historico;
    private static Historico instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Historico.dat";

    private Historico() {
        this.historico = new ArrayList<>();
        carregaAtendimentos();
    }

    public static Historico getInstance() {
        if (instance == null) {
            instance = new Historico();
        }
        return instance;
    }

    public void addAtendimento(Atendimento atendimento) {
        this.historico.add(atendimento);
        grava();
    }

    private void carregaAtendimentos() {
        this.historico = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, historico);
    }

    public List<Atendimento> getAtendimentos() {
        return historico;
    }

    public void excluirAtendimento(Atendimento atendimento) {
        historico.remove(atendimento);
        grava();
    }

    public Atendimento buscarAtendimentoPorCpf(String cpf) {
        for (Atendimento atendimento : historico) {
            if (atendimento.getCliente().getCpf().equals(cpf))
                return atendimento;
        }
        return null;
    }

    public boolean altera(Atendimento atendimentoExistente, String cpf) {
        try {
            ArrayList<Atendimento> listaTemp = new ArrayList<Atendimento>();

            for (Iterator<Atendimento> it = historico.iterator(); it.hasNext();) {
                Atendimento atendimento = it.next();
                if (!atendimento.getCliente().getCpf().equals(cpf))
                    listaTemp.add(atendimento);
                else
                    listaTemp.add(atendimentoExistente);
            }

            historico.removeAll(historico);
            historico.addAll(listaTemp);
            grava();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
