package main.java.view;

import javax.swing.*;
import java.awt.*;

public class AdicionarItemView extends JFrame {

    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField valorField;
    private JTextField quantidadeField;
    private JComboBox<String> tipoComboBox;
    private JLabel quantidadeLabel;
    private JButton salvarButton;
    private JButton cancelarButton;

    public AdicionarItemView() {
        setTitle("Adicionar Item");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // formulário
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // campos do formulário
        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        formPanel.add(descricaoField);

        formPanel.add(new JLabel("Valor:"));
        valorField = new JTextField();
        formPanel.add(valorField);

        formPanel.add(new JLabel("Tipo:"));
        tipoComboBox = new JComboBox<>(new String[]{"Tipo Alimento", "Prato", "Bebida"});
        formPanel.add(tipoComboBox);

        quantidadeLabel = new JLabel("Quantidade/Tamanho:");
        formPanel.add(quantidadeLabel);
        quantidadeField = new JTextField();
        formPanel.add(quantidadeField);

        salvarButton = new JButton("Salvar");
        salvarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(salvarButton);
        buttonPanel.add(cancelarButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // adicionar cor no fundo
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getDescricaoField() {
        return descricaoField;
    }

    public JTextField getValorField() {
        return valorField;
    }

    public JTextField getQuantidadeField() {
        return quantidadeField;
    }

    public JComboBox<String> getTipoComboBox() {
        return tipoComboBox;
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }
}
