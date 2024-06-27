package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.*;

/**
 *
 * @author danil
 */
public class FilaDeEspera extends AbstractDAO implements Serializable {

    private List<Atendimento> filaDeEspera;
    private static FilaDeEspera instance;

    private final String arq = "./src/main/java/data/FilaDeEspera.dat";

    private FilaDeEspera() {
        this.filaDeEspera = new ArrayList<>();
        carregaAtendimentos();
    }

    public static FilaDeEspera getInstance() {
        if (instance == null) {
            instance = new FilaDeEspera();
        }
        return instance;
    }

    public void addAtendimento(Atendimento atendimento) {
        this.filaDeEspera.add(atendimento);
        grava();
    }

    private void carregaAtendimentos() {
        this.filaDeEspera = super.leitura(arq);
    }

    private void grava() {
        super.grava(arq, filaDeEspera);
    }

    public List<Atendimento> getAtendimentos() {
        return filaDeEspera;
    }

    public void excluirAtendimento(Atendimento atendimento) {
        filaDeEspera.remove(atendimento);
        grava();
    }

   

    public boolean altera(Atendimento atendimentoExistente, String nome) {
        try {
            ArrayList<Atendimento> listaTemp = new ArrayList<Atendimento>();

            for (Iterator<Atendimento> it = filaDeEspera.iterator(); it.hasNext();) {
                Atendimento atendimento = it.next();
                if (!atendimento.getCliente().getNome().equals(nome)) {
                    listaTemp.add(atendimento);
                } else {
                    listaTemp.add(atendimentoExistente);
                }
            }

            filaDeEspera.removeAll(filaDeEspera);
            filaDeEspera.addAll(listaTemp);
            grava();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
