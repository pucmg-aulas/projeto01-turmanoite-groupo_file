import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        FIlaDeEspera fila = new FIlaDeEspera();
        RequisicaoPorMesa novaRequisicao = null;
        Conta conta = null;
        int op;
        do
            {

                System.out.println("------ Menu ------");
                System.out.println("1. Cliente Novo");
                System.out.println("2. Fazer pedido");
                System.out.println("3. Fechar Conta");
                System.out.println("4. Lista de Espera");
                System.out.println("5. Sair");
                System.out.println("------------------");
                System.out.println("Escolha uma opção: ");
                op = scanner.nextInt();
                scanner.nextLine();

                if(op == 1)
                {
                    System.out.println("Digite o seu nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite agora a quantidade de Pessoas Desejadas");
                    int qtdDePessoas = scanner.nextInt();

                    Cliente novo = new Cliente(nome, qtdDePessoas);
                    novaRequisicao = new RequisicaoPorMesa(novo , restaurante, fila);

                }else if(op == 2){
                    if (novaRequisicao != null) {
                        System.out.println("Digite o nome do prato");
                        String prato = scanner.nextLine();
                        System.out.println("Digite o preço");
                        double preco = scanner.nextDouble();

                        Cardapio c = new Cardapio(prato, preco);

                        conta = new Conta(novaRequisicao.getMesa());
                        conta.addPedido(c);
                    }  else if(op == 3) {
                        if (novaRequisicao != null && conta != null) {
                            double total = conta.calcularTotal();
                            System.out.println("Total da conta: " + total);
                            conta = null;
                        } else {
                            System.out.println("Nenhuma conta aberta para fechar.");
                        }
                    }

                else if(op == 4){
                System.out.println("Lista de espera:");
                ArrayList<Cliente> filaEspera = fila.getFila();
                if (filaEspera.isEmpty()) {
                    System.out.println("A fila de espera está vazia.");
                } else {
                    for (int i = 0; i < filaEspera.size(); i++) {
                        Cliente cliente = filaEspera.get(i);
                        System.out.println("Cliente " + (i+1) + ": " + cliente.getNome());
                    }
                }
                }else if(op == 5){
                    break;
                }else{
                    System.out.println("Opção inválida");
                }

                }
        }while (op != 5);
        scanner.close();
    }
}