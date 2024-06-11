package main.java.view;

import javax.swing.*;
import java.awt.*;

public class FazerPedidoView extends JFrame {
    private JComboBox<String> itemComboBox;
    private JTextField quantidadeTextField;
    private JButton salvarPedidoButton;

    public FazerPedidoView() {
        setTitle("Fazer Pedido");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // seção do "formulário"
        JPanel itemQuantidadePanel = new JPanel(new GridBagLayout());
        itemQuantidadePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        itemQuantidadePanel.add(new JLabel("Item:"), gbc);

        gbc.gridx = 1;
        itemComboBox = new JComboBox<>();
        itemComboBox.setPreferredSize(new Dimension(200, 30));
        itemQuantidadePanel.add(itemComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        itemQuantidadePanel.add(new JLabel("Quantidade:"), gbc);

        gbc.gridx = 1;
        quantidadeTextField = new JTextField(10);
        quantidadeTextField.setPreferredSize(new Dimension(100, 30));
        itemQuantidadePanel.add(quantidadeTextField, gbc);

        // seção do botão
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        salvarPedidoButton = new JButton("Salvar Pedido");
        salvarPedidoButton.setFont(new Font("Arial", Font.BOLD, 14));
        salvarPedidoButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(salvarPedidoButton);

        add(itemQuantidadePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // cor do fundo
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }

    public JComboBox<String> getItemComboBox() {
        return this.itemComboBox;
    }

    public JTextField getQuantidadeTextField() {
        return this.quantidadeTextField;
    }

    public JButton getSalvarPedidoButton() {
        return this.salvarPedidoButton;
    }

    public void setQuantidade(int quantidade) {
        quantidadeTextField.setText(String.valueOf(quantidade));
    }

}
