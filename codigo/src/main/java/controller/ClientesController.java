package controller;

import dao.*;
import model.*;
import view.*;
import java.util.List;
import java.util.Optional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientesController {
    private final ClientesView view;
    private final Mesas mesas;
    private final Clientes clientes;
    private final Atendimentos atendimentos;

    public ClientesController() {
        this.atendimentos = Atendimentos.getInstance();
        this.mesas = Mesas.getInstance();
        this.clientes = Clientes.getInstance();
        
        this.view = new ClientesView();

        carregaTabela();

        this.view.getBtnPedido().addActionListener(e -> pedido()); 
        this.view.getBtnFecharComanda().addActionListener(e -> conta());
        this.view.getBtnExcluir().addActionListener(e -> excluirCliente());
        
        this.view.setVisible(true);
    }

    

    private void excluirCliente() {
        int selectedRow = view.getTblNomes().getSelectedRow();

        if (selectedRow >= 0) {
            String nome = (String) view.getTblNomes().getValueAt(selectedRow, 0);
            int opcao = JOptionPane.showConfirmDialog(view, "Tem certeza que quer excluir ?");

            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    Optional<Atendimento> clienteEscolhido = atendimentos.buscarAtendimentoPorNome(nome);
                    Cliente cliente = clientes.buscarClientePorNome(nome)
                            .orElseThrow(() -> new Exception("Cliente não encontrado"));
                    clientes.excluirCliente(cliente); 
                    if (clienteEscolhido.isPresent()) {
                        Atendimento atendimento = clienteEscolhido.get();
                        mesas.buscarMesaPorNumero(atendimento.getMesa().getNumero()).setOcupada(false);
                        atendimentos.excluirAtendimento(atendimento);
                    }
                    JOptionPane.showMessageDialog(view, "Cliente excluído com sucesso!");
                    carregaTabela();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Erro ao excluir cliente " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha!");
        }
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(new Object[] { "Nome" }, 0);

        List<Cliente> clienteList = clientes.getClientes();
        clienteList.stream()
                .map(cliente -> new Object[] { cliente.getNome()})
                .forEach(model::addRow);

        view.getTblNomes().setModel(model);
    }

   

    private void conta() {
        int linha = this.view.getTblNomes().getSelectedRow();
    
        if (linha == -1) {
            JOptionPane.showMessageDialog(view, "Nenhuma linha selecionada.");
            return;
        }
        String nome = (String) this.view.getTblNomes().getValueAt(linha, 0);
        Optional<Atendimento> clienteEscolhido = atendimentos.buscarAtendimentoPorNome(nome);
        if (clienteEscolhido.isPresent()) {
            new FecharContaController(clienteEscolhido.get());
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Atendimento não encontrado ");
        }
    }

    private void pedido() {
        int linha = this.view.getTblNomes().getSelectedRow();
        String nome = (String) this.view.getTblNomes().getValueAt(linha, 0);
        Optional<Atendimento> clienteEscolhido = atendimentos.buscarAtendimentoPorNome(nome);
        if (clienteEscolhido.isPresent()) {
            new AnotarPedidoController(clienteEscolhido.get());
        } else {
            JOptionPane.showMessageDialog(view, "Atendimento não encontrado para  " + nome);
        }
    }

}