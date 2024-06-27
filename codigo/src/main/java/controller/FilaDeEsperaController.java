package controller;


import dao.*;
import model.*;
import view.*;
import javax.swing.table.DefaultTableModel;

public class FilaDeEsperaController {
    private final FilaDeEsperaView view;
    private final FilaDeEspera filaDeEspera;

    public FilaDeEsperaController() {
        this.view = new FilaDeEsperaView();
        this.filaDeEspera = FilaDeEspera.getInstance();
        
        carregaTabela();

        this.view.getBtnVoltar().addActionListener(e -> sair());

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "Quantidade de Pessoas" }, 0);

        for (Atendimento atendimento : filaDeEspera.getAtendimentos()) {
            model.addRow(new Object[] {
                    atendimento.getCliente().getNome(),
                    atendimento.getQuantPessoas()
            });
        }

        view.getTblFila().setModel(model);
    }
}
