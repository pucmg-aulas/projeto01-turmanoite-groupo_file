import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Restaurante implements Serializable{
    
    private List<Mesa> mesas;
    private List<RequisicaoPorMesa> filaEspera;

    public Restaurante()
    {
    mesas = new ArrayList <>();
    filaEspera = new ArrayList <>();

    mesas.add(new Mesa(1,2));
    mesas.add(new Mesa(2,2));
    mesas.add(new Mesa(3,4));
    mesas.add(new Mesa(4,4));
    mesas.add(new Mesa(5,6));
    mesas.add(new Mesa(6,6));
    mesas.add(new Mesa(7,8));
    mesas.add(new Mesa(8,8));
    mesas.add(new Mesa(9,10));
    mesas.add(new Mesa(10,10));
    }
    

    public List<Mesa> getMesas()
    {
        return mesas;
    }
    
    public void requisitarMesa(String nome, int nPessoas)
    {
        Cliente cliente = new Cliente(nome,nPessoas);
        Mesa mesaDisponivel = procurar(cliente.getQuantidadePessoas());

        if(mesaDisponivel != null)
        {
            mesaDisponivel.setOcupada(false);
            mesaDisponivel.setCliente(cliente);
            
            System.out.println("Mesa disponivel para " + nome );
        }else {
            if(cliente.getQuantidadePessoas() <= 10)
            {
                
                filaEspera.add(new RequisicaoPorMesa( null, cliente));
                System.out.println("Não há mesa disponivel.");
            }else{
                System.out.println("Não possuimos mesas com mais de 10 lugares");
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

  
}
