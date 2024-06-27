package controller;

import dao.*;
import view.*;
import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

public class ListarFaturamentoController {
    private final ListarFaturamentoView view;
    private final Pagamentos pagamentos;

    public ListarFaturamentoController() {
        this.pagamentos = Pagamentos.getInstance();
        this.view = new ListarFaturamentoView();

        carregaTabela();

        this.view.getBtnPesquisa().addActionListener(e -> pesquisa());
        this.view.getBtnVoltar().addActionListener(e -> voltar());
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Data", "Valor" }, 0);

        pagamentos.getPagamentos().stream().forEach(pagamento -> {
            model.addRow(new Object[] {
                    pagamento.getData(),
                    String.format("%.2f", pagamento.getValor())
            });
        });

        view.getTblFaturamento().setModel(model);
    }

    private void voltar() {
        this.view.dispose();
    }


    private void pesquisa() {
        String txtData = view.getTxtDate().getText();
        LocalDate dataPesquisada = LocalDate.parse(txtData);
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Data", "Valor" }, 0);

        pagamentos.getPagamentos().stream()
                .filter(pagamento -> pagamento.getData().equals(dataPesquisada))
                .forEach(pagamento -> {
                    model.addRow(new Object[] {
                            pagamento.getData(),
                            String.format("%.2f", pagamento.getValor())
                    });
                });

        view.getTblFaturamento().setModel(model);
    }
}
