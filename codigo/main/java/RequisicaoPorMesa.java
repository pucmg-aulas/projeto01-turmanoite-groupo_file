import java.time.LocalDateTime;

public class RequisicaoPorMesa {
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int numeroPessoas;
    private Mesa mesa;

    public RequisicaoPorMesa(LocalDateTime dataEntrada, int numeroPessoas) {
        this.dataEntrada = dataEntrada;
        this.numeroPessoas = numeroPessoas;
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

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
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