package model;

public class Mesa {
    private int id;
    private int capacidade;
    private boolean status;

    public Mesa(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.status = false; // Por padrão, a mesa começa desocupada
    }

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
