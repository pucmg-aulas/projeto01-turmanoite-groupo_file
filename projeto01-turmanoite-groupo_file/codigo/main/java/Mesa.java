class Mesa {

    private int numero;
    private boolean ocupada;
    private int capacidade;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.ocupada = false;
        this.capacidade = capacidade;
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

    public boolean estaDisponivel(int numeroPessoas)
    {
        
        return !ocupada;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
