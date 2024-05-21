import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = null;
        List<Mesa> mesas;
        List<Menu> menu;
        menu = new ArrayList <>();
        RequisicaoPorMesa novaRequisicao = null;
        List<RequisicaoPorMesa> filaEspera;
        mesas = new ArrayList <>();
        filaEspera = new ArrayList <>();
        ArrayList<RequisicaoPorMesa> requisicoes = new ArrayList<>();

        mesas.add(new Mesa(1,4,false,0));
        mesas.add(new Mesa(2,4,false,0));
        mesas.add(new Mesa(3,4,false,0));
        mesas.add(new Mesa(4,4,false,0));
        mesas.add(new Mesa(5,6,false,0));
        mesas.add(new Mesa(6,6,false,0));
        mesas.add(new Mesa(7,6,false,0));
        mesas.add(new Mesa(8,6,false,0));
        mesas.add(new Mesa(9,8,false,0));
        mesas.add(new Mesa(10,8,false,0));

        menu.add(new Menu(1, 9.90));
        menu.add(new Menu(2, 19.90));
        menu.add(new Menu(3, 29.90));
        menu.add(new Menu(4, 39.90));
        menu.add(new Menu(5, 49.90));
        menu.add(new Menu(6, 59.90));
        menu.add(new Menu(7, 69.90));
        menu.add(new Menu(8, 79.90));
        menu.add(new Menu(9, 89.90));
        menu.add(new Menu(10, 99.90));
        menu.add(new Menu(11, 109.90));

        Restaurante restaurante = new Restaurante(mesas);
        
       
        for(;;)
        {
            
            System.out.println("------ Menu ------");
            System.out.println("1. Cliente Novo");
            System.out.println("2. Liberar Mesa");
            System.out.println("3. Mesas Disponiveis");
            System.out.println("4. Lista de Espera");
            System.out.println("5. Fazer Pedido");
            System.out.println("6. Fechar Conta");
            System.out.println("7. Sair");
            System.out.println("------------------");
            System.out.println("Escolha uma opção: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            if(op == 1)
            {
                
                restaurante.requisitarMesa(requisicoes);
                
            }else if(op == 2){
                //Método Liberar Mesa
                System.out.println("Mesa a ser liberada:");
                int nMesa = scanner.nextInt();
                restaurante.mesaLiberada(nMesa);
                

             }else if(op == 3){
                //Método quais mesas estão disponiveis
                System.out.println("Mesas Disponiveis");
                restaurante.mesasDisponiveis();
             }else if(op == 4){
                System.out.println("Lista de espera:");
                System.out.println(restaurante.imprimirLista(filaEspera));
            }else if(op == 5){
                        System.out.println("Digite o número da mesa:");
                        int numeroMesa = scanner.nextInt();
                        scanner.nextLine();

                        Mesa mesaSelecionada = mesas.stream()
                        .filter(mesa -> mesa.getNumero() == numeroMesa)
                        .findFirst()
                        .orElse(null);


                        System.out.println("--------------=---------------=-----------");
                        System.out.println("COMIDAS");
                        System.out.println("1-Moqueca de Tilápia");
                        System.out.println("2-Falafel Assado");
                        System.out.println("3-Salada Primavera com Macarrão Konjac");
                        System.out.println("4-Escondidinho de Frango");
                        System.out.println("5-Strogonoff");
                        System.out.println("6-Caçarola de carne com legumes");
                        System.out.println("--------------=---------------=-----------");
                        System.out.println("BEBIDAS");
                        System.out.println("7-Água");
                        System.out.println("8-Suco");
                        System.out.println("9-Refrigerante");
                        System.out.println("10-Cerveja");
                        System.out.println("11-Taça de Vinho");
                        System.out.println("--------------=---------------=-----------");
                        System.out.println("Digite o número do prato");
                        System.out.println("Digite 0 para parar");
                        for(;;)
                        {
                           
                            int prato = scanner.nextInt();
                            scanner.nextLine();

                            if (prato == 0)
                            {
                                break;
                            }

                            // Encontre o prato no menu
                             Menu itemPedido = menu.stream()
                            .filter(m -> m.getNComida() == prato)
                            .findFirst()
                            .orElse(null);

                            if (itemPedido != null) {
                                mesaSelecionada.getContaMesa().adicionarPedido(itemPedido);
                            } else {
                                System.out.println("Prato não encontrado.");
                            }
                        }

                        
            }else if(op == 6){
                System.out.println("Digite o número da mesa:");
                int numeroMesa = scanner.nextInt();
                scanner.nextLine();

                Mesa mesaSelecionada = mesas.stream()
                        .filter(mesa -> mesa.getNumero() == numeroMesa)
                        .findFirst()
                        .orElse(null);

                if (mesaSelecionada != null && mesaSelecionada.isOcupada() && mesaSelecionada.temContaAberta()) {
                    System.out.println("Deseja fechar a conta? (s/n)");
                    String fecharConta = scanner.nextLine();
                    if (fecharConta.equalsIgnoreCase("s")) {
                        mesaSelecionada.desocupar();
                    }
                } else {
                    System.out.println("Mesa não encontrada ou não está ocupada.");
                }
            } else if (op == 7) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }
}
