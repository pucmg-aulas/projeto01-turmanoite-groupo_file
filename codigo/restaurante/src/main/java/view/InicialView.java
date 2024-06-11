package main.java.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class InicialView extends JFrame {

    private JButton iniciarAtendimentoButton;
    private JButton encerrarAtendimentoButton;
    private JButton exibirMesasButton;
    private JButton exibirListaEsperaButton;
    private JButton removerAtendimentoButton;
    private JButton exibirCardapioButton;
    private JButton fazerPedidoButton;
    private JButton exibirComandaButton;
    private JButton sairButton;

    public InicialView() {
        setTitle("Restaurante À La Classe");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        iniciarAtendimentoButton = new JButton("Iniciar Atendimento");
        encerrarAtendimentoButton = new JButton("Encerrar Atendimento");
        exibirMesasButton = new JButton("Exibir Mesas");
        exibirListaEsperaButton = new JButton("Lista de Espera");
        removerAtendimentoButton = new JButton("Remover da Espera");
        exibirCardapioButton = new JButton("Cardápio");
        fazerPedidoButton = new JButton("Fazer Pedido");
        exibirComandaButton = new JButton("Ver Comanda");
        sairButton = new JButton("Sair");

        add(iniciarAtendimentoButton);
        add(encerrarAtendimentoButton);
        add(exibirMesasButton);
        add(exibirListaEsperaButton);
        add(removerAtendimentoButton);
        add(exibirCardapioButton);
        add(fazerPedidoButton);
        add(exibirComandaButton);
        add(sairButton);
    }

    public JButton getIniciarAtendimentoButton() {
        return this.iniciarAtendimentoButton;
    }

    public JButton getEncerrarAtendimentoButton() {
        return this.encerrarAtendimentoButton;
    }

    public JButton getExibirMesasButton() {
        return this.exibirMesasButton;
    }

    public JButton getExibirListaEsperaButton() {
        return this.exibirListaEsperaButton;
    }

    public JButton getRemoverAtendimentoButton() {
        return this.removerAtendimentoButton;
    }

    public JButton getExibirCardapioButton() {
        return this.exibirCardapioButton;
    }

    public JButton getFazerPedidoButton() {
        return this.fazerPedidoButton;
    }

    public JButton getExibirComandaButton() {
        return this.exibirComandaButton;
    }

    public JButton getSairButton() {
        return this.sairButton;
    }
}
