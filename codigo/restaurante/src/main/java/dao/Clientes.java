package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.model.Cliente;

public class Clientes extends AbstractDao implements Serializable {

    private List<Cliente> clientes;
    private static Clientes instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Clientes.dat";

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
        this.clientes = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, clientes);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void excluirCliente(Cliente cliente) {
        clientes.remove(cliente);
        grava();
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome))
                return cliente;
        }
        return null;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf))
                return cliente;
        }
        return null;
    }

    public boolean altera(Cliente clienteExistente, String nomeAnterior) {
        try {
            ArrayList<Cliente> listaTemp = new ArrayList<Cliente>();

            for (Iterator<Cliente> it = clientes.iterator(); it.hasNext();) {
                Cliente cliente = it.next();
                if (!cliente.getNome().equals(nomeAnterior))
                    listaTemp.add(cliente);
                else
                    listaTemp.add(clienteExistente);
            }

            clientes.removeAll(clientes);
            clientes.addAll(listaTemp);
            grava();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}