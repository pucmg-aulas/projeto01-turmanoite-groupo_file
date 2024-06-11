package main.java.controller;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

import main.java.dao.Historico;
import main.java.model.Atendimento;
import main.java.view.HistoricoAtendimentoView;

public class ListarHistoricoController {

    private HistoricoAtendimentoView view;
    private Historico historico;

    public ListarHistoricoController() {

        this.historico = Historico.getInstance();
        this.view = new HistoricoAtendimentoView();

        carregaTabela();

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela() {
        Object colunas[] = { "Nome", "CPF", "Data" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Atendimento> it = historico.getAtendimentos().iterator();
        while (it.hasNext()) {
            Atendimento a = it.next();
            String atendimento = a.toString();
            String linha[] = atendimento.split("%");
            tm.addRow(new Object[] { linha[0], linha[1], linha[7] });
        }
        view.getTabelaHistorico().setModel(tm);
    }

    // private void excluirCliente() {
    // if (view.getTbClientes().getSelectedRow() != -1) {
    // int linha = this.view.getTbClientes().getSelectedRow();
    // String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);

    // int op = JOptionPane.showConfirmDialog(view, "Deseja excluir o cliente com
    // CPF " + cpf + "?");
    // if (op == JOptionPane.YES_OPTION) {
    // Cliente cliente = clientes.buscarClientePorCpf(cpf);
    // clientes.excluirCliente(cliente);
    // Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
    // atendimentos.excluirAtendimento(atendimento);
    // JOptionPane.showMessageDialog(view, "Cliente com CPF " + cpf + " excluído com
    // sucesso!");
    // carregaTabela();
    // }
    // } else
    // JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
    // }

    // private void fazerPedido() {
    // int linha = this.view.getTbClientes().getSelectedRow();
    // String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
    // Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
    // new FazerPedidoController(atendimento);
    // }

    // private void listarComanda() {
    // int linha = this.view.getTbClientes().getSelectedRow();
    // String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
    // Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
    // new ListarComandaController(atendimento);
    // }

    // private void fecharComanda() {
    // int linha = this.view.getTbClientes().getSelectedRow();
    // String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
    // Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
    // new EncerrarAtendimentoController(atendimento);
    // }
}