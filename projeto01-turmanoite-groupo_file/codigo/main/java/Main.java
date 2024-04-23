import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante(10); // Criando um restaurante com 10 mesas

        while (true) {
            System.out.println("------ Menu ------");
            System.out.println("1. Registrar chegada de cliente");
            System.out.println("2. Finalizar requisição por mesa");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número
            Cliente cliente = new Cliente("",0, LocalDateTime.now(),null ,0);
            RequisicaoPorMesa requisicao = cliente.requisitarMesa();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    cliente.setNome(nomeCliente);
                    System.out.print("Número de pessoas: ");
                    int numeroPessoas = scanner.nextInt();
                    cliente.setQuantidadePessoas(numeroPessoas);
                    System.out.println("Qual a sua id:");
                    int id = scanner.nextInt();
                    cliente.setId(id);
                    scanner.nextLine(); // Consumir a quebra de linha após o número

                    boolean mesaAlocada = false;
                    
                    for (Mesa mesa : restaurante.getMesas()) {
                        if (mesa.estaDisponivel(numeroPessoas) && mesa.getCapacidade() >= numeroPessoas) {
                            requisicao.alocarMesa(mesa);
                            mesaAlocada = true;
                            break;
                        }
                    }

                case 2:
                    System.out.print("Número da mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número
                    
                    requisicao.finalizar(numeroMesa);
                    System.out.println("Requisição por mesa finalizada com sucesso!");
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}
