import java.io.Serializable;

class Mesa implements Serializable{

    private int numero;
    private boolean ocupada;
    private int capacidade;
    private Cliente cliente;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.ocupada = false;
        this.capacidade = capacidade;
        this.cliente = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

   
}
