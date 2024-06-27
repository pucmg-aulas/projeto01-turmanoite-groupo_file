package controller;

import dao.*;
import view.*;

import javax.swing.table.DefaultTableModel;

public class ListarCardapioController {
    private final ListarCardapioView view;
    private final Cardapio alimentos;

    public ListarCardapioController() {
        this.alimentos = Cardapio.getInstance();
        this.view = new ListarCardapioView();


        carregaTabela();
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome",  "Valor" }, 0);

        alimentos.getAlimentos().stream().forEach(alimento -> {
            model.addRow(new Object[] {
                    alimento.getNome(),
                    alimento.getValor()
            });
        });

        view.getTblCardapio().setModel(model);
    }

}
