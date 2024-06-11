package main.java.view;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.util.ArrayList;

import main.java.model.Mesa;

public class MesasView extends JFrame {
    private JTable tabelaMesas;
    private DefaultTableModel tableModel;
    private JComboBox<String> statusComboBox;
    private TableRowSorter<DefaultTableModel> sorter;

    public MesasView() {
        setTitle("Mesas");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[] { "Mesas", "Capacidade", "Status" }, 0);
        tabelaMesas = new JTable(tableModel);
        tabelaMesas.setFillsViewportHeight(true);
        sorter = new TableRowSorter<>(tableModel);
        tabelaMesas.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(tabelaMesas);
        add(scrollPane, BorderLayout.CENTER);

        JPanel filtroPainel = new JPanel();
        statusComboBox = new JComboBox<>(new String []{"Todos", "Disponível", "Ocupado"});
        JButton filterButton = new JButton("Filtrar");
        filtroPainel.add(new JLabel("Status"));
        filtroPainel.add(statusComboBox);
        filtroPainel.add(filterButton);
        add(filtroPainel, BorderLayout.NORTH);
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        tableModel.setRowCount(0);

        for (Mesa mesa : mesas) {
            String status;
            if (mesa.isOcupada()) {
                status = "Ocupado";
            } else {
                status = "Disponível";
            }
            Object[] row = {mesa.getNumero(), mesa.getQuantCadeiras(), status};
            tableModel.addRow(row);
        }
    }

}
