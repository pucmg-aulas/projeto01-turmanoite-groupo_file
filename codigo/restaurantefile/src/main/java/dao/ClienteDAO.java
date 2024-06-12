package dao;

import model.Cliente;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO extends AbstractDAO {

    private static final String FILE_PATH = "clientes.dat";
    private List<Cliente> clientes;

    public ClienteDAO() {
        clientes = (List<Cliente>) leitura(FILE_PATH);
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        gravar(FILE_PATH, clientes);
    }

    public List<Cliente> obterClientes() {
        return clientes;
    }
}
