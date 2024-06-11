package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ComandaView extends JFrame {
    private JTable tabelaPedidos;
    private DefaultTableModel tableModel;

    public JTable getTabelaPedidos() {
        return tabelaPedidos;
    }

    public ComandaView() {
        setTitle("Comanda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // tabela
        tableModel = new DefaultTableModel(new Object[]{"Item", "Quantidade", "Preço"}, 0);
        tabelaPedidos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);

        // "css" da tabela
        tabelaPedidos.setFillsViewportHeight(true);
        tabelaPedidos.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaPedidos.setRowHeight(30);

        // cabeçalho
        JTableHeader header = tabelaPedidos.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);
        
        // corpo
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);

        // cor do fundo
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }
}
