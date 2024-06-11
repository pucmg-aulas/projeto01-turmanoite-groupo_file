package main.java.controller;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

import main.java.model.Atendimento;
import main.java.model.Pedido;
import main.java.view.ComandaView;

public class ListarComandaController {

    private ComandaView view;

    public ListarComandaController(Atendimento atendimento) {

        this.view = new ComandaView();

        carregaTabela(atendimento);

        this.view.setVisible(true);
    }

    private void carregaTabela(Atendimento atendimento) {
        view.setTitle("Comanda do Cliente " + atendimento.getCliente().getNome());
        Object colunas[] = { "Quantidade", "Item", "Valor", "Quantidade", "Valor Total" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Pedido> it = atendimento.getComanda().getPedidos().iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            String pedido = p.toString();
            String linha[] = pedido.split("%");
            tm.addRow(new Object[] { linha[1], linha[2], linha[3], linha[4], linha[5] });
        }
        view.getTabelaPedidos().setModel(tm);

    }
}