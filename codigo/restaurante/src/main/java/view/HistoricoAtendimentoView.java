package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class HistoricoAtendimentoView extends JFrame {
    private JTable tabelaHistorico;
    private DefaultTableModel tableModel;
    private JTextField campoPesquisa;
    private JButton botaoPesquisar;

    public HistoricoAtendimentoView() {
        setTitle("Histórico de Atendimentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // barra com a pesquisa
        JToolBar barraFerramentas = new JToolBar();
        barraFerramentas.setFloatable(false);
        campoPesquisa = new JTextField(20);
        botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setFont(new Font("Arial", Font.BOLD, 14));
        barraFerramentas.add(campoPesquisa);
        barraFerramentas.add(botaoPesquisar);
        add(barraFerramentas, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"CPF", "Nome", "Data"}, 0);
        tabelaHistorico = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);

        // "css" da tabela
        tabelaHistorico.setFillsViewportHeight(true);
        tabelaHistorico.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaHistorico.setRowHeight(30);

        JTableHeader header = tabelaHistorico.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);

        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }

    public JTable getTabelaHistorico() {
        return tabelaHistorico;
    }

    public JTextField getCampoPesquisa() {
        return campoPesquisa;
    }

    public JButton getBotaoPesquisar() {
        return botaoPesquisar;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
