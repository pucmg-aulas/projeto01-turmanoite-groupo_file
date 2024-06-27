package controller;

import dao.*;
import model.*;
import view.*;
import javax.swing.*;


public class AnotarPedidoController {
    private final FazerPedidoView view;
    private final Cardapio alimentos;
    private final Atendimentos atendimentos;
    private final Atendimento atendimento;

    public AnotarPedidoController(Atendimento atendimento) {
        this.view = new FazerPedidoView();
        this.atendimento = atendimento;
        this.atendimentos = Atendimentos.getInstance();
        this.alimentos = Cardapio.getInstance();

        this.view.getBtnSalvar().addActionListener(e -> addPedido());
        this.view.getBtnCancelar().addActionListener(e -> cancelar());
        carregaComboBox();

        this.view.setTitle("Fazer Pedido");
        this.view.setVisible(true);
    }

    private void addPedido() {
        try {
            int quantidade = Integer.parseInt(view.getTxtQuantidade().getText());
            if (quantidade <= 0) {
                throw new NumberFormatException("Número inválido!");
            }

            String nomeAlimento = (String) view.getComboItens().getSelectedItem();
            ItensCardapio alimento = alimentos.buscarAlimentoPorNome(nomeAlimento);
            if (alimento != null) {
                Pedido pedido = new Pedido(alimento, quantidade);
                atendimento.getComanda().addPedidos(pedido);
                atendimentos.altera(atendimento, atendimento.getCliente());
                JOptionPane.showMessageDialog(view, "Pedido salvo com sucesso!");

                this.view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Alimento não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Quantidade inválida" + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void carregaComboBox() {
    alimentos.getAlimentos().stream()
             .map(ItensCardapio::getNome)
             .forEach(nome -> this.view.getComboItens().addItem(nome));
    }
}
