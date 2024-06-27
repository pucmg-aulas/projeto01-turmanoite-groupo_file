package controller;

import javax.swing.*;
import dao.*;
import model.*;
import view.*;

public class AddMesaController {
    private final AddMesaView view;
    private final Mesas mesas;

    public AddMesaController() {
        this.mesas = Mesas.getInstance();
        this.view = new AddMesaView();

        this.view.getBtnSalvar().addActionListener(e -> addMesa());
        this.view.getBtnCancelar().addActionListener(e -> cancelar());

        this.view.setTitle("Cadastrar Mesa");
        this.view.setVisible(true);
    }

    private void addMesa() {
        try {
            int quantCadeiras = Integer.parseInt(view.getTxtQuantidade().getText());

            if (quantCadeiras <= 0) throw new NumberFormatException("Número de cadeiras deve ser positivo.");

            Mesa m = new Mesa(quantCadeiras);
            mesas.addMesa(m);
            JOptionPane.showMessageDialog(view, "Mesa salva com sucesso!");
            limparTela();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Entrada inválida: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void limparTela() {
        this.view.getTxtQuantidade().setText("");
    }
}
