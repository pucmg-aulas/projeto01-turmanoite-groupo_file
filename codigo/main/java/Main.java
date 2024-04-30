import java.io.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();  // Criando um restaurante com 10 mesas
        

        File mesasIndisponiveisFile = new File("mesaindisponivel.txt");
        File listaEsperaFile = new File("lista_espera.txt");

        if (mesasIndisponiveisFile.exists()) {
            restaurante = new Restaurante();
        } else {
            restaurante = new Restaurante();
        }
        for(;;)
        {
            
            System.out.println("------ Menu ------");
            System.out.println("1. Chegada de Cliente");
            System.out.println("2. Liberar Mesa");
            System.out.println("3. Mesas Ocupadas");
            System.out.println("4. Lista de Espera");
            System.out.println("5. Sair");
            System.out.println("------------------");
            System.out.println("Escolha uma opção: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            if(op == 1)
            {
                
                System.out.println("Nome do Cliente:");
                String nomeCliente = scanner.nextLine();
               
                System.out.println("Quantidade de Pessoas:");
                int nPessoas = scanner.nextInt();
              
                scanner.nextLine();
                
                restaurante.requisitarMesa(nomeCliente, nPessoas);
                restaurante.salvar();
                restaurante.salvarLista();
                
            }else if(op == 2){
                //Método Liberar Mesa
                System.out.println("Mesa a ser liberada:");
                int nMesa = scanner.nextInt();
                restaurante.mesaLiberada(nMesa);
                restaurante.salvar();
                restaurante.salvarLista();

            }else if(op == 3){
                //Método quais mesas estão ocupadas
                System.out.println("Mesas Indisponiveis");
                int i = 0;
                for(Mesa mesa : restaurante.getMesas()){
                    if(mesa.isOcupada() == false)
                    {
                        
                        System.out.println("Mesa " + i );
                        
                    }
                    i++;
                }
            }else if(op == 4){
                //Método para ver lista de espera
                restaurante.verLista();
            }else if(op == 5){
                break;
            }else{
                System.out.println("Opção inválida");
            }
            
        }
        scanner.close();
    }
}
