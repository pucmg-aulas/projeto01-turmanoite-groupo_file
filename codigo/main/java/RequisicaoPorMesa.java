import java.time.LocalDateTime;

public class RequisicaoPorMesa {
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int numeroPessoas;
    private Mesa mesa;
    private Cliente cliente;
    


    public RequisicaoPorMesa(LocalDateTime dataEntrada, int numeroPessoas, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.numeroPessoas = numeroPessoas;
        this.cliente = cliente;
        

    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
    

    public void alocarMesa(Mesa mesa) {
        if (mesa.estaDisponivel() && mesa.getCapacidade() >= numeroPessoas) {
            this.mesa = mesa;
            mesa.setOcupada(true);
        } else {
            System.out.println("Não foi possível alocar uma mesa adequada para esta requisição.");
        }
    }

    public void finalizar() {
        if (mesa != null) {
            mesa.setOcupada(false);
        }
        dataSaida = LocalDateTime.now();
    }
}
