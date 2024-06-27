package controller;

import dao.*;
import model.*;
import view.*;

import java.util.Optional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MesasController {
    private final MesasView view;
    private final Mesas mesas;

    public MesasController() {
        this.mesas = Mesas.getInstance();
        this.view = new MesasView();

        carregaTabela();

        this.view.getBtnExcluir().addActionListener(e -> excluirMesa());
        this.view.getBtnVoltar().addActionListener(e -> sair());

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Número", "Cadeiras", "Ocupada" }, 0);

        mesas.getMesas().stream().forEach(mesa -> {
            model.addRow(new Object[] {
                mesa.getNumero(),
                mesa.getQuantidade(),
                mesa.isOcupada() ? "Sim" : "Não"
            });
        });

        view.getTbMesas().setModel(model);
    }

    private void excluirMesa() {
        int selectedRow = view.getTbMesas().getSelectedRow();
        if (selectedRow >= 0) {
            int numero = (int) view.getTbMesas().getValueAt(selectedRow, 0);
            int option = JOptionPane.showConfirmDialog(view, "Deseja excluir a mesa " + numero + "?");
    
            if (option == JOptionPane.YES_OPTION) {
                Optional<Mesa> mesaOptional = mesas.getMesas().stream()
                    .filter(mesa -> mesa.getNumero() == numero)
                    .findFirst()
                ;
    
                if (mesaOptional.isPresent()) {
                    Mesa mesa = mesaOptional.get();
                    if (!mesa.isOcupada()) {
                        mesas.excluirMesa(mesa);
                        JOptionPane.showMessageDialog(view, "Mesa " + numero + " excluída com sucesso!");
                        carregaTabela();
                    } else JOptionPane.showMessageDialog(view, "Não é possível excluir uma mesa ocupada.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else JOptionPane.showMessageDialog(view, "Mesa não encontrada.");
            }
        } else JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
    }
}