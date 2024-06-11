package main.java.controller;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

import main.java.dao.Alimentos;
import main.java.model.Alimento;
import main.java.view.CardapioView;

public class ListarCardapioController {

    private CardapioView view;
    private Alimentos alimentos;

    public ListarCardapioController() {

        this.alimentos = Alimentos.getInstance();
        this.view = new CardapioView();

        carregaTabela();

        this.view.setVisible(true);
    }

    private void carregaTabela() {
        Object colunas[] = { "Nome", "Descrição", "Valor" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Alimento> it = alimentos.getAlimentos().iterator();
        while (it.hasNext()) {
            Alimento m = it.next();
            String mesa = m.toString();
            String linha[] = mesa.split("%");
            tm.addRow(new Object[] { linha[1], linha[2], linha[3] });
        }
        view.getTable().setModel(tm);
    }
}