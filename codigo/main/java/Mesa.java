public  class Mesa
{
    private int numero;
    private boolean ocupada;
    private int capacidade;
    private Cliente cliente;

    public Mesa (int numero,int capacidade, boolean ocupada )
    {
        this.numero = numero;
        this.ocupada = ocupada;
        this.capacidade = capacidade;
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return this.ocupada;
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

    public void ocupar() {
        this.ocupada = false;
      }
    
      public void desocupar() {
        this.ocupada = true;
      }
}
