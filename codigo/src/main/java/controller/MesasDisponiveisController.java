package controller;

import dao.*;
import model.*;
import view.*;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MesasDisponiveisController {
    private final MesasDisponiveisView view;
    private final Atendimento atendimento;
    private final Atendimentos atendimentos;
    private final Clientes clientes;
    private final List<Mesa> mesasDisponiveis;
    private final Mesas mesas;

    public MesasDisponiveisController(Atendimento atendimento, List<Mesa> mesasDisponiveis) {
        this.view = new MesasDisponiveisView();
        this.atendimento = atendimento;
        this.atendimentos = Atendimentos.getInstance();
        this.mesasDisponiveis = mesasDisponiveis;
        this.mesas = Mesas.getInstance();
        this.clientes = Clientes.getInstance();

        carregaTabela();

        this.view.getBtnEscolher().addActionListener(e -> escolherMesa());
        this.view.getBtnVoltar().addActionListener(e -> sair());

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void escolherMesa() {
        clientes.addCliente(atendimento.getCliente());
        atendimentos.addAtendimento(atendimento);
        int linha = this.view.getTblMesas().getSelectedRow();
        
        if (linha >= 0) {
            int numero = (Integer) this.view.getTblMesas().getValueAt(linha, 0);
            Mesa mesa = mesas.buscarMesaPorNumero(numero);
            mesa.setOcupada(true);
            atendimento.setMesa(mesa);
            atendimentos.addAtendimento(atendimento);
            this.view.dispose();
        }
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[] { "Número", "Cadeiras" }, 0);

            mesasDisponiveis.stream()
                .forEach(m -> model.addRow(new Object[] { m.getNumero(), m.getQuantidade() }));

        view.getTblMesas().setModel(model);
    }
}
