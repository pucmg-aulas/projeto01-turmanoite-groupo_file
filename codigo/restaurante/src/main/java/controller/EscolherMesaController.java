package main.java.controller;

import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import main.java.dao.Atendimentos;
import main.java.dao.Mesas;
import main.java.model.Atendimento;
import main.java.model.Mesa;
import main.java.view.EscolherMesaView;

public class EscolherMesaController {

    private EscolherMesaView view;
    private Atendimento atendimento;
    private Atendimentos atendimentos;
    private List<Mesa> mesasDisponiveis;
    private Mesas mesas;

    public EscolherMesaController(Atendimento atendimento, List<Mesa> mesasDisponiveis) {
        this.atendimento = atendimento;
        this.atendimentos = Atendimentos.getInstance();
        this.mesasDisponiveis = mesasDisponiveis;
        this.mesas = Mesas.getInstance();
        this.view = new EscolherMesaView();

        carregaTabela();

        this.view.getBtnEscolher().addActionListener((e) -> {
            escolherMesa();
        });

        this.view.getBtnVoltar().addActionListener((e) -> {
            sair();
        });

        this.view.setVisible(true);

    }

    private void sair() {
        this.view.dispose();
    }

    private void escolherMesa() {
        int linha = this.view.getTbMesas().getSelectedRow();
        int numero = Integer.parseInt((String) this.view.getTbMesas().getValueAt(linha, 0));
        Mesa mesa = mesas.buscarMesaPorNumero(numero);
        mesa.setOcupada(true);
        mesas.altera(mesa, numero);
        atendimento.setMesa(mesa);
        System.out.println(mesa.toString());
        System.out.println(atendimento.getMesa().toString());
        atendimentos.addAtendimento(atendimento);
        this.view.dispose();
    }

    private void carregaTabela() {
        Object colunas[] = { "Número", "Cadeiras" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Mesa> it = mesasDisponiveis.iterator();
        while (it.hasNext()) {
            Mesa m = it.next();
            String mesa = m.toString();
            String linha[] = mesa.split("%");
            tm.addRow(new Object[] { linha[0], linha[1] });

        }
        view.getTbMesas().setModel(tm);
    }
}