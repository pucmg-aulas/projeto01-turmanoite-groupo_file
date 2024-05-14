public  class Mesa
{
    private int numero;
    private boolean ocupada;
    private int capacidade;
    private Cliente cliente;

    public Mesa (int n,int capa , Cliente c)
    {
        this.setNumero(n);
        this.setOcupada(false);
        this.setCapacidade(capa);
        this.setCliente(c);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
