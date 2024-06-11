package main.java.controller;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

import main.java.dao.FilaDeEspera;
import main.java.model.Atendimento;
import main.java.view.FilaEsperaView;

public class FilaDeEsperaController {

    private FilaEsperaView view;
    private FilaDeEspera filaDeEspera;

    public FilaDeEsperaController() {

        this.filaDeEspera = FilaDeEspera.getInstance();
        this.view = new FilaEsperaView();

        carregaTabela();

        this.view.setVisible(true);
    }

    private void carregaTabela() {
        Object colunas[] = { "Nome", "CPF", "Quantidade de pessoas" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Atendimento> it = filaDeEspera.getAtendimentos().iterator();
        while (it.hasNext()) {
            Atendimento atendimento = it.next();
            String atendimentoString = atendimento.toString();
            String linha[] = atendimentoString.split("%");
            tm.addRow(new Object[] { linha[0], linha[1], linha[2] });
        }
        view.getTabelaFilaEspera().setModel(tm);
    }
}