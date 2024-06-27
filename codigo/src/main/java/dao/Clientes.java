package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.*;

/**
 *
 * @author danil
 */
public class Clientes extends AbstractDAO implements Serializable {

    private List<Cliente> clientes;
    private static Clientes instance;

    private final String arq = "./src/main/java/data/Clientes.dat";

    private Clientes() {
        this.clientes = new ArrayList<>();
        carregaClientes();
    }

    public static Clientes getInstance() {
        if (instance == null)
            instance = new Clientes();
        return instance;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        grava();
    }

    private void carregaClientes() {
        this.clientes = super.leitura(arq);
    }

    private void grava() {
        super.grava(arq, clientes);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void excluirCliente(Cliente cliente) {
        clientes.remove(cliente);
        grava();
    }

    public Optional<Cliente> buscarClientePorNome(String nome) {
        return clientes.stream()
                       .filter(cliente -> cliente.getNome().equals(nome)) 
                       .findFirst();
    }


    public boolean altera(Cliente clienteExistente, String nomeAnterior) {
        try {
            grava();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}