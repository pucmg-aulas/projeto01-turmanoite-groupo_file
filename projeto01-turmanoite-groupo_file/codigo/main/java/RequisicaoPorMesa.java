import java.time.LocalDateTime;

public class RequisicaoPorMesa {
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int numeroPessoas;
    private Restaurante restaurante;
    private Cliente cliente;
    private Mesa mesa;
    


    public RequisicaoPorMesa(LocalDateTime dataEntrada, int numeroPessoas, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.numeroPessoas = numeroPessoas;
        this.cliente = cliente;
        this.restaurante = new Restaurante(10);

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

        for(int i = 0 ; i < 10 ; i++){
            mesa = restaurante.getMesas()[i];
            if (!(mesa.isOcupada())){
                mesa.setOcupada(true);
                break;
            }
            else if (i == 9){
                FIlaDeEspera addCLiente = new FIlaDeEspera( this.cliente);
                System.out.println("Você foi redirecionado para a fila de espera");
            }
        }
    }

    public void finalizar(int numeroMesa) {
        for(int i = 0 ; i < 10 ; i++){
            mesa = restaurante.getMesas()[i];
            if (mesa.getNumero() == numeroMesa){
                mesa.setOcupada(false);
            }
        }
        dataSaida = LocalDateTime.now();
    }
}
