import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante implements Serializable{
    private List<Mesa> mesas;
    public List<String> listadeespera;
    

    public Restaurante(List<Mesa> mesas)
    {
        this.mesas = mesas;
        listadeespera= new ArrayList<>();
    }
    

    
    
    public void requisitarMesa(List<RequisicaoPorMesa> requisicoes)
    {
        

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do Cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Quantidade de Pessoas:");
        int nPessoas = scanner.nextInt();

        scanner.nextLine();

        // Filtrar mesas disponíveis com capacidade suficiente para a quantidade de pessoas
        Mesa disponivel = mesas.stream()
                .filter(mesa -> mesa.isOcupada() == false && mesa.getCapacidade() >= nPessoas)
                .findFirst()
                .orElse(null);

        if (disponivel != null) {
            disponivel.ocupar(); // Ocupamos a mesa
            RequisicaoPorMesa novaRequisicao = new RequisicaoPorMesa(nomeCliente, nPessoas, disponivel);
            requisicoes.add(novaRequisicao);
            System.out.println("Mesa disponível para o cliente.");
        } else {
            System.out.println("Nenhuma mesa disponível com capacidade suficiente no momento.");
            listadeespera.add(nomeCliente);
        }

       
    }
    

    public void imprimirLista() {
        StringBuilder build = new StringBuilder();
        for (String nomes : listadeespera) {
            System.out.println(nomes);
        }
       
    }

    public void mesaLiberada(int nMesa) {
        if(nMesa > 10)
        {
            System.out.println("Mesa não existe");
        }else
        {
            for(Mesa mesa: mesas){
                if(mesa.getNumero() == nMesa)
                {
                    mesa.desocupar();
                    System.out.println("Mesa "+ mesa.getNumero()+" desocupada." );
                    
                    break;
                }
            }
        }
    }

    public void mesasDisponiveis() {
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) { 
                System.out.println("Número: " + mesa.getNumero() + ", Capacidade: " + mesa.getCapacidade());
            }
        }
    }
  
}
