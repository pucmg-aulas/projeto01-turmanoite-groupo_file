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

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Número de pessoas: ");
                    int numeroPessoas = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número

                    Cliente cliente = new Cliente(nomeCliente);
                    RequisicaoPorMesa requisicao = cliente.requisitarMesa(numeroPessoas);
                    // Encontra uma mesa disponível e a aloca para a requisição
                    boolean mesaAlocada = false;
                    for (Mesa mesa : restaurante.getMesas()) {
                        if (mesa.estaDisponivel() && mesa.getCapacidade() >= numeroPessoas) {
                            requisicao.alocarMesa(mesa);
                            mesaAlocada = true;
                            break;
                        }
                    }
                    if (!mesaAlocada) {
                        System.out.println("Não foi possível alocar uma mesa adequada para esta requisição.");
                    } else {
                        System.out.println("Requisição por mesa registrada com sucesso!");
                    }
                    break;
                case 2:
                    System.out.print("Número da mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número

                    restaurante.finalizarRequisicao(numeroMesa);
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