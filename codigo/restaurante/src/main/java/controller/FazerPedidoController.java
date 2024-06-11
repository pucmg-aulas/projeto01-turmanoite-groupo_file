package main.java.controller;

import java.util.Iterator;

import javax.swing.JOptionPane;

import main.java.dao.Alimentos;
import main.java.dao.Atendimentos;
import main.java.model.Alimento;
import main.java.model.Atendimento;
import main.java.model.Pedido;
import main.java.view.FazerPedidoView;

public class FazerPedidoController {
    private FazerPedidoView view;
    private Alimentos alimentos;
    private Atendimentos atendimentos;
    private Atendimento atendimento;

    public FazerPedidoController(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.atendimentos = Atendimentos.getInstance();
        this.alimentos = Alimentos.getInstance();
        this.view = new FazerPedidoView();

        this.view.getSalvarPedidoButton().addActionListener((e) -> {
            addPedido();
        });

        carregaComboBox();

        this.view.setTitle("Fazer Pedido");
        this.view.setVisible(true);
    }

    public void addPedido() {
        int quantidade = Integer.parseInt(view.getQuantidadeTextField().getText());
        String nomeAlimento = (String) view.getItemComboBox().getSelectedItem();
        Alimento alimento = alimentos.buscarAlimentoPorNome(nomeAlimento);
        Pedido pedido = new Pedido(alimento, quantidade);
        atendimento.getComanda().addPedidos(pedido);
        atendimentos.altera(atendimento, atendimento.getCliente().getCpf());
        JOptionPane.showMessageDialog(view, "Pedido salvo com sucesso!");
        limparTela();
    }

    @SuppressWarnings("unchecked")
    private void carregaComboBox() {
        Iterator<Alimento> it = alimentos.getAlimentos().iterator();
        while (it.hasNext()) {
            Alimento alimento = it.next();
            this.view.getItemComboBox().addItem(alimento.getNome());
        }
    }

    private void limparTela() {
        this.view.getQuantidadeTextField().setText("");
    }
}