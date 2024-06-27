package controller;

import dao.*;
import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemController {
    private AddItemView view;
    private Cardapio alimentos;

    public AddItemController() {
        this.view = new AddItemView();
        this.alimentos = Cardapio.getInstance();

        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarItem();
            }
        });

        this.view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        this.view.setVisible(true);
    }

    private void salvarItem() {
        String nome = view.getTxtNome().getText();
        double valor = Double.parseDouble(view.getTxtValor().getText());
        
        ItensCardapio alimento;

        alimento = new ItensCardapio(nome, valor);

        alimentos.addAlimento(alimento);
        
        cancelar();
    }

    private void cancelar() {
        this.view.dispose();
    }
}