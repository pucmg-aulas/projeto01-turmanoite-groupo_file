import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteView extends JFrame {
    private RestauranteController controller;
    private JTextField nomeClienteField;
    private JTextField quantidadePessoasField;
    private JTextField numeroMesaField;
    private JTextArea outputArea;

    public RestauranteView(RestauranteController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        setTitle("Restaurante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
        lblNomeCliente.setBounds(10, 10, 120, 25);
        getContentPane().add(lblNomeCliente);

        nomeClienteField = new JTextField();
        nomeClienteField.setBounds(140, 10, 200, 25);
        getContentPane().add(nomeClienteField);
        nomeClienteField.setColumns(10);

        JLabel lblQuantidadePessoas = new JLabel("Quantidade de Pessoas:");
        lblQuantidadePessoas.setBounds(10, 45, 160, 25);
        getContentPane().add(lblQuantidadePessoas);

        quantidadePessoasField = new JTextField();
        quantidadePessoasField.setBounds(180, 45, 160, 25);
        getContentPane().add(quantidadePessoasField);
        quantidadePessoasField.setColumns(10);

        JButton btnRequisitarMesa = new JButton("Requisitar Mesa");
        btnRequisitarMesa.setBounds(10, 80, 150, 25);
        getContentPane().add(btnRequisitarMesa);

        JLabel lblNumeroMesa = new JLabel("Número da Mesa:");
        lblNumeroMesa.setBounds(10, 115, 120, 25);
        getContentPane().add(lblNumeroMesa);

        numeroMesaField = new JTextField();
        numeroMesaField.setBounds(140, 115, 200, 25);
        getContentPane().add(numeroMesaField);
        numeroMesaField.setColumns(10);

        JButton btnLiberarMesa = new JButton("Liberar Mesa");
        btnLiberarMesa.setBounds(10, 150, 150, 25);
        getContentPane().add(btnLiberarMesa);

        JButton btnMostrarMesas = new JButton("Mostrar Mesas Disponíveis");
        btnMostrarMesas.setBounds(10, 185, 200, 25);
        getContentPane().add(btnMostrarMesas);

        JButton btnImprimirLista = new JButton("Imprimir Lista de Espera");
        btnImprimirLista.setBounds(10, 220, 200, 25);
        getContentPane().add(btnImprimirLista);

        JButton btnAdicionarPedido = new JButton("Adicionar Pedido");
        btnAdicionarPedido.setBounds(10, 255, 150, 25);
        getContentPane().add(btnAdicionarPedido);

        JButton btnFecharConta = new JButton("Fechar Conta");
        btnFecharConta.setBounds(10, 290, 150, 25);
        getContentPane().add(btnFecharConta);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 325, 560, 100);
        getContentPane().add(outputArea);

        btnRequisitarMesa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = nomeClienteField.getText();
                int quantidadePessoas = Integer.parseInt(quantidadePessoasField.getText());
                controller.requisitarMesa(nomeCliente, quantidadePessoas);
                appendToOutput("Mesa requisitada por " + nomeCliente + " para " + quantidadePessoas + " pessoas.");
            }
        });

        btnLiberarMesa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroMesa = Integer.parseInt(numeroMesaField.getText());
                controller.liberarMesa(numeroMesa);
                appendToOutput("Mesa " + numeroMesa + " liberada.");
            }
        });

        btnMostrarMesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                controller.mostrarMesasDisponiveis();
            }
        });

        btnImprimirLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                controller.imprimirListaEspera();
            }
        });

        btnAdicionarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroMesa = Integer.parseInt(numeroMesaField.getText());
                // Supondo que o item do menu e seu preço são fornecidos de alguma forma
                Menu menu = new Menu(1, 29.90); // Exemplo de item de menu
                controller.adicionarPedido(numeroMesa, menu);
                appendToOutput("Pedido adicionado à mesa " + numeroMesa + ".");
            }
        });

        btnFecharConta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroMesa = Integer.parseInt(numeroMesaField.getText());
                controller.fecharConta(numeroMesa);
                appendToOutput("Conta da mesa " + numeroMesa + " fechada.");
            }
        });
    }

    private void appendToOutput(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(1, 4, false));
        mesas.add(new Mesa(2, 2, false));
        mesas.add(new Mesa(3, 6, false));
        Restaurante restaurante = new Restaurante(mesas);
        List<RequisicaoPorMesa> requisicoes = new ArrayList<>();
        RestauranteController controller = new RestauranteController(restaurante, requisicoes);

        RestauranteView frame = new RestauranteView(controller);
        frame.setVisible(true);
    }
}
