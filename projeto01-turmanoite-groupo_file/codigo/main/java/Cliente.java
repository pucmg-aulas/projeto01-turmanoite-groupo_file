import java.time.LocalDateTime;

public class Cliente {
    private String nome;
    private int id;
    private LocalDateTime dataHoraEntrada ;
    private LocalDateTime dataHoraSaida ;
    private int quantidadePessoas;


    public Cliente(String nome, int id, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, int quantidadePessoas) {
        this.nome = nome;
        this.id = id;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.quantidadePessoas = quantidadePessoas;
    }

    public RequisicaoPorMesa requisitarMesa() { // Cria uma nova requisição por mesa
        RequisicaoPorMesa requisicao = new RequisicaoPorMesa(LocalDateTime.now(), this.quantidadePessoas,this);
        return requisicao;
    }


    public String getNome() { //Método get para retornar nome
        return nome;
    }

    public void setNome(String nome) { //Método set para alterar nome
        this.nome = nome;
    }

    public int getId() { //Método get para retornar Id
        return id;
    }

    public void setId(int id) { //Método set para alterar Id
        this.id = id;
    }

    public LocalDateTime getDataHoraEntrada() { //Método get para retornar DataHoraEntrada
        return dataHoraEntrada;
    }

    public void  setDataHoraEntrada(LocalDateTime dataHoraEntrada) { //Método set para alterar DataHoraEntrada
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() { //Método get para retornar dataHoraSaida
        return dataHoraSaida;
    }

    public void  setDataHoraSaida(LocalDateTime dataHoraSaida) { //Método set para alterar dataHoraSaida
        this.dataHoraSaida = dataHoraSaida;
    }
    public int getQuantidadePessoas() { //Método get para retornar quantidadePessoas
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) { //Método set para alterar quantidadePessoas
        this.quantidadePessoas = quantidadePessoas;
    }

    
}
