package controller;

import dao.*;
import model.*;
import view.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;

public class FecharContaController {
    private final FecharContaView view;
    private final Atendimento atendimento;
    private final Atendimentos atendimentos;
    private final Clientes clientes;
    private final Mesas mesas;
    private final Pagamentos pagamentos;

    public FecharContaController(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.view = new FecharContaView();
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.mesas = Mesas.getInstance();
        this.pagamentos = Pagamentos.getInstance();

        this.view.getBtnFechar().addActionListener(e -> encerrarAtendimento());
        this.view.getBtnCancelar().addActionListener(e -> cancelar());
        this.view.getBtnExcluir().addActionListener(e -> excluirItem());


        carregaTela();
        this.view.setVisible(true);
    }

    private void carregaTela() {
        view.getTxtValor().setText(String.format("%.2f", atendimento.getComanda().calculaValor()));

        conta();
    }

    private void conta() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[] { "Item", "Quantidade", "Valor", "Valor Total" }, 0);

        for (Pedido p : atendimento.getComanda().getPedidos()) {
        String[] linha = p.toString().split("%");

        if (linha.length >= 4) {
            model.addRow(new Object[] { linha[0], linha[1], linha[2], linha[3] });
        } else {
            System.out.println("Erro: O pedido não contém todas as partes esperadas. Dados: " + p.toString());
        }
    }

    view.getTblConta().setModel(model);
    }

    private void excluirItem() {
        int linha = view.getTblConta().getSelectedRow();
        if (linha >= 0) {
            atendimento.getComanda().getPedidos().remove(linha);
            atendimentos.altera(atendimento, atendimento.getCliente());
            carregaTela();
        }
    }

    private void encerrarAtendimento() {
        String nome = atendimento.getCliente().getNome();
        int option = JOptionPane.showConfirmDialog(view, "Deseja encerrar o atendimento do cliente " + nome + "?");

        if (option == JOptionPane.YES_OPTION) {
            try {
                
                clientes.excluirCliente(clientes.buscarClientePorNome(nome).orElseThrow(() -> new Exception("Cliente não encontrado")));
                mesas.buscarMesaPorNumero(atendimento.getMesa().getNumero()).setOcupada(false);
                atendimentos.excluirAtendimento(atendimento);

                atendimento.setHoraSaida(LocalTime.now());
                atendimento.setMetodoPagamento(getMetodoPagamento());
               

                double valorFinal = atendimento.getComanda().calculaValor() -
                        atendimento.getMetodoPagamento().calcularDesconto(atendimento.getComanda().calculaValor());
                LocalDate dataVencimento = LocalDate.now().plusDays(atendimento.getMetodoPagamento().getPrazoDias());
                
                pagamentos.addPagamento(new Pagamento(valorFinal, dataVencimento));

                JOptionPane.showMessageDialog(view, "Atendimento encerrado!");

                cancelar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Erro ao encerrar atendimento: " + e.getMessage());
            }
        }
    }

    private MetodoPagamento getMetodoPagamento() {
        String pagamento = (String) this.view.getComboPagamento().getSelectedItem();
        switch (pagamento) {
            case "Crédito":
                return new Credito();
            case "Debito":
                return new Debito();
            case "Dinheiro":
                return new Dinheiro();
            case "Pix":
                return new Debito();
            default:
                return new Credito();
        }
    }

    private void cancelar() {
        this.view.dispose();
    }
}
