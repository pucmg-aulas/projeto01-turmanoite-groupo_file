public class Mesa {
    private int numero;
    private int capacidade;
    private boolean ocupada;
    public Mesa(int capacidade) {
        this.capacidade = capacidade;
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
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public boolean estaDisponivel() {
        return !ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}