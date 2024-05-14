import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        List<Mesa> mesas;
        List<RequisicaoPorMesa> filaEspera;
        mesas = new ArrayList <>();
        filaEspera = new ArrayList <>();

        mesas.add(new Mesa(1,4,true));
        mesas.add(new Mesa(2,4,true));
        mesas.add(new Mesa(3,4,true));
        mesas.add(new Mesa(4,4,true));
        mesas.add(new Mesa(5,6,true));
        mesas.add(new Mesa(6,6,true));
        mesas.add(new Mesa(7,6,true));
        mesas.add(new Mesa(8,6,true));
        mesas.add(new Mesa(9,8,true));
        mesas.add(new Mesa(10,8,true));
        
       
        for(;;)
        {
            
            System.out.println("------ Menu ------");
            System.out.println("1. Cliente Novo");
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
                
                restaurante.requisitarMesa(mesas);
                
            }else if(op == 2){
                //Método Liberar Mesa
                System.out.println("Mesa a ser liberada:");
                int nMesa = scanner.nextInt();
                restaurante.mesaLiberada(nMesa, mesas);
                

             /*}else if(op == 3){
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
             */}else if(op == 4){
                System.out.println("Lista de espera:");
                restaurante.imprimirLista(filaEspera);
           }else if(op == 5){
                break;
            }else{
                System.out.println("Opção inválida");
            }
            
        }
        scanner.close();
    }
}
