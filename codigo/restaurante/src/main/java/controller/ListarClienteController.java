package main.java.controller;

import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.model.Atendimento;
import main.java.model.Cliente;
import main.java.view.ListarClienteView;

public class ListarClienteController {

    private ListarClienteView view;
    private Clientes clientes;
    private Atendimentos atendimentos;

    public ListarClienteController() {

        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.view = new ListarClienteView();

        carregaTabela();

        this.view.getBtnExcluir().addActionListener((e) -> {
            excluirCliente();
        });

        this.view.getBtnFazerPedido().addActionListener((e) -> {
            fazerPedido();
        });

        this.view.getBtnComanda().addActionListener((e) -> {
            listarComanda();
        });

        this.view.getBtnEncerrar().addActionListener((e) -> {
            fecharComanda();
        });

        this.view.getBtnVoltar().addActionListener((e) -> {
            sair();
        });

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela() {
        Object colunas[] = { "Nome", "CPF" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Cliente> it = clientes.getClientes().iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            String cliente = c.toString();
            String linha[] = cliente.split("%");
            tm.addRow(new Object[] { linha[0], linha[1] });
        }
        view.getTbClientes().setModel(tm);
    }

    private void excluirCliente() {
        if (view.getTbClientes().getSelectedRow() != -1) {
            int linha = this.view.getTbClientes().getSelectedRow();
            String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);

            int op = JOptionPane.showConfirmDialog(view, "Deseja excluir o cliente com CPF " + cpf + "?");
            if (op == JOptionPane.YES_OPTION) {
                Cliente cliente = clientes.buscarClientePorCpf(cpf);
                clientes.excluirCliente(cliente);
                Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
                atendimentos.excluirAtendimento(atendimento);
                JOptionPane.showMessageDialog(view, "Cliente com CPF " + cpf + " excluído com sucesso!");
                carregaTabela();
            }
        } else
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
    }

    private void fazerPedido() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
        new FazerPedidoController(atendimento);
    }

    private void listarComanda() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
        new ListarComandaController(atendimento);
    }

    private void fecharComanda() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
        new EncerrarAtendimentoController(atendimento);
    }
}