package controller;

import model.*;
import view.*;
import javax.swing.table.DefaultTableModel;

public class ListarComandaController {
    private final ListarComandaView view;
    private final Atendimento atendimento;

    public ListarComandaController(Atendimento atendimento) {
        this.view = new ListarComandaView();
        this.atendimento = atendimento;

        carregaTabela();

        this.view.setTitle("Comanda do Cliente " + atendimento.getCliente().getNome());
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Quantidade", "Item", "Valor Unitário", "Quantidade", "Valor Total" }, 0);

        for (Pedido pedido : atendimento.getComanda().getPedidos()) {
            model.addRow(new Object[] {
                pedido.getQuantidade(),
                pedido.getAlimento().getNome(),
                pedido.getAlimento().getValor(),
                pedido.getQuantidade(),
                pedido.getValorTotal()
            });
        }

        view.getTblComanda().setModel(model);
    }
}
