import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante implements Serializable{
    
    

    public Restaurante()
    {
        
    }
    

    
    
    public void requisitarMesa(List<Mesa> mesas)
    {
        ArrayList<RequisicaoPorMesa> requisicoes;
        requisicoes = new ArrayList <>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do Cliente:");
        String nomeCliente = scanner.nextLine();
               
        System.out.println("Quantidade de Pessoas:");
        int nPessoas = scanner.nextInt();
              
        scanner.nextLine();
                
        Mesa disponivel = mesas.stream().filter(Mesa::isOcupada).findFirst().orElse(null);
        if (disponivel != null) {
            disponivel.ocupar();
            RequisicaoPorMesa novaRequisicao = new RequisicaoPorMesa(nomeCliente, nPessoas, disponivel);
            if(novaRequisicao ==null)
            {
                throw new IllegalArgumentException("Error");
            }
            requisicoes.add(novaRequisicao);
            System.out.println("Mesa disponivel para o cliente");
        } else {
            System.out.println("Nenhuma mesa disponível no momento.");
        }
    }

    public String imprimirLista(List<RequisicaoPorMesa> filaEspera) {
        StringBuilder build = new StringBuilder();
        for (RequisicaoPorMesa requisicao : filaEspera) {
            build.append("Cliente: ").append(requisicao.getNomeCliente())
              .append(", Lugares: ").append(requisicao.getNPessoas())
              .append(", Mesa: ").append(requisicao.getMesaUtilizada().getCapacidade())
              .append(" lugares\n");
        }
        return build.toString();
    }

    /*public void mesaLiberada(int nMesa, List<Mesa> mesas) {
        if(nMesa > 10)
        {
            System.out.println("Mesa não existe");
        }else
        {
            for(nMesa : mesas){

            }
        }
    }

     public void mesaLiberada(int nMesa)
    {
        Mesa mesa = mesas.get(nMesa - 1);
        mesa.setOcupada(true);
        Cliente cliente = mesa.getCliente();
        mesa.setCliente(null);

        //Chamar próximo cliente
        if(!filaEspera.isEmpty())
        {
            RequisicaoPorMesa chamar = filaEspera.get(0);
            if(chamar.getMesa() == null && chamar!= null && chamar.getCliente().getQuantidadePessoas() <= mesa.getCapacidade())
            {
                filaEspera.remove(0); 
                mesa.setCliente(chamar.getCliente());
                mesa.setOcupada(false);
                
                System.out.println("Mesa "+mesa.getNumero()+ " desocupada, cliente "+cliente.getNome()+" alocado na mesma");
            }else{
                System.out.println("Mesa "+ mesa.getNumero()+" desocupada.");
            }
        }else{
            System.out.println("Mesa "+ mesa.getNumero()+" desocupada.");
        }
    }

    private Mesa procurar(int nPessoas)
    {
        for(Mesa mesa : mesas)
        {
            if(!mesa.isOcupada() && mesa.getCapacidade() >= nPessoas)
            {
                return mesa;
            }
        }

        return null;
    }

    public void carregar()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mesaindisponivel.txt"))) {
            mesas = (List<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void verLista()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_espera.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mesaindisponivel.txt"))) {
            oos.writeObject(mesas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarLista() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("lista_espera.txt"))) {
            for (RequisicaoPorMesa chamar : filaEspera) {
                Cliente cliente = chamar.getCliente();
                writer.println("Cliente: " + cliente.getNome() + " Pessoas: " + cliente.getQuantidadePessoas());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
  
}
