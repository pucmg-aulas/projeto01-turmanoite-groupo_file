package main.java.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.dao.FilaDeEspera;
import main.java.dao.Mesas;
import main.java.model.Atendimento;
import main.java.model.Cliente;
import main.java.model.Mesa;
import main.java.view.AdicionarClienteView;

public class AdicionarClienteController {
    private AdicionarClienteView view;
    private Clientes clientes;
    private Atendimentos atendimentos;
    private FilaDeEspera filaDeEspera;
    private Mesas mesas;

    public AdicionarClienteController() {
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.mesas = Mesas.getInstance();
        this.filaDeEspera = FilaDeEspera.getInstance();
        this.view = new AdicionarClienteView();

        this.view.getBtnSalvar().addActionListener((e) -> {
            addCliente();
        });

        this.view.getBtnVoltar().addActionListener((e) -> {
            cancelar();
        });

        this.view.setTitle("Cadastrar Cliente");
        this.view.setVisible(true);
    }

    public void addCliente() {
        String nome = view.getTxtNomeCLiente().getText();
        String cpf = view.getNumCPFCliente().getText();
        Cliente c = new Cliente(nome, cpf);
        clientes.addCliente(c);
        addAtendimento(c);
    }

    public void addAtendimento(Cliente c) {
        int quantidade = (Integer) view.getNumQuantidadePessoas().getValue();
        Atendimento atendimento = new Atendimento(c, quantidade);
        List<Mesa> mesasDisponiveis = mesasDisponiveis(quantidade);
        if (mesasDisponiveis.size() > 0) {
            atendimentos.addAtendimento(atendimento);
            new EscolherMesaController(atendimento, mesasDisponiveis);
        } else {
            filaDeEspera.addAtendimento(atendimento);
            JOptionPane.showMessageDialog(view,
                    "Nenhuma mesa disponível no momento. Cliente adicionado a fila de espera!");
        }
        limparTela();
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void limparTela() {
        this.view.getTxtNomeCLiente().setText("");
        this.view.getNumCPFCliente().setText("");
    }

    private List<Mesa> mesasDisponiveis(int quantidade) {
        List<Mesa> mesasDisponiveis = new ArrayList<>();

        Iterator<Mesa> it = mesas.getMesas().iterator();
        while (it.hasNext()) {
            Mesa mesa = it.next();
            if (!mesa.isOcupada() && mesa.getQuantCadeiras() >= quantidade) {
                mesasDisponiveis.add(mesa);
            }
        }
        return mesasDisponiveis;
    }
}