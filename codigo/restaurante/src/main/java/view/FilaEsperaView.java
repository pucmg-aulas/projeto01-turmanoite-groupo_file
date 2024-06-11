package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class FilaEsperaView extends JFrame {
    private JTable tabelaFilaEspera;
    private DefaultTableModel tableModel;

    public JTable getTabelaFilaEspera() {
        return tabelaFilaEspera;
    }

    public void setTabelaFilaEspera(JTable tabelaFilaEspera) {
        this.tabelaFilaEspera = tabelaFilaEspera;
    }

    public FilaEsperaView() {
        setTitle("Fila de Espera");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Cliente", "Qtd de Pessoas"}, 0);
        tabelaFilaEspera = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaFilaEspera);

        tabelaFilaEspera.setFillsViewportHeight(true);
        tabelaFilaEspera.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaFilaEspera.setRowHeight(30);

        JTableHeader header = tabelaFilaEspera.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);

        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }
}
