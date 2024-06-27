package controller;

import dao.*;
import model.*;
import view.NovoClienteView;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class AddClienteController {
    private final NovoClienteView view;
    private final FilaDeEspera filaDeEspera;
    private final Mesas mesas;

    public AddClienteController() {
        this.view = new NovoClienteView();
        this.mesas = Mesas.getInstance();
        this.filaDeEspera = FilaDeEspera.getInstance();

        this.view.getBtnCancelar().addActionListener(e -> cancelar());
        this.view.getBtnSalvar().addActionListener(e -> addCliente());

        this.view.setTitle("Cadastrar Cliente");
        this.view.setVisible(true);
    }

    private void addCliente() {
        String nome = view.getTxtNomeCliente().getText();
        Cliente cliente = new Cliente(nome);

        addAtendimento(cliente);
    }

    private void addAtendimento(Cliente cliente) {
        int quantidade = (Integer) view.getNumQuantidade().getValue();
        Atendimento atendimento = new Atendimento(cliente, quantidade);

        List<Mesa> mesasDisponiveis = mesasDisponiveis(quantidade);
        if (!mesasDisponiveis.isEmpty()) {
            new MesasDisponiveisController(atendimento, mesasDisponiveis);
        } else {
            filaDeEspera.addAtendimento(atendimento);
            JOptionPane.showMessageDialog(view, "Cliente na fila de espera!");
        }
        cancelar();
    }

    private void cancelar() {
        this.view.dispose();
    }

    private List<Mesa> mesasDisponiveis(int quantidade) {
        return mesas.getMesas().stream()
                .filter(mesa -> !mesa.isOcupada() && mesa.getQuantidade() >= quantidade)
                .collect(Collectors.toList());
    }
}
