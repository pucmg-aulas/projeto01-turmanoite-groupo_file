import java.time.LocalTime;

public class Mesa {
    private int numero;
    private boolean ocupada;
    private int capacidade;
    private Cliente cliente;
    private LocalTime horarioChegada;
    private LocalTime horarioSaida;
    private Conta contaMesa;

    public Mesa(int numero, int capacidade, boolean ocupada) {
        this.numero = numero;
        this.ocupada = ocupada;
        this.capacidade = capacidade;
        this.contaMesa = new Conta(numero);
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public Conta getContaMesa() {
        return contaMesa;
    }

    public LocalTime getHorarioChegada() {
        return horarioChegada;
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

    public void ocupar() {
        this.ocupada = true;
        this.horarioChegada = LocalTime.now();
    }

    public void desocupar() {
        this.ocupada = false;
        this.horarioSaida = LocalTime.now();
        if (contaMesa != null) {
            contaMesa.fecharConta();
            this.contaMesa = null;
        }
    }

    public boolean temContaAberta() {
        return contaMesa != null;
    }
}
