import java.time.LocalDateTime;

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public RequisicaoPorMesa requisitarMesa(int numeroPessoas) { // Cria uma nova requisição por mesa
        RequisicaoPorMesa requisicao = new RequisicaoPorMesa(LocalDateTime.now(), numeroPessoas);
        return requisicao;
    }

    public String getNome() { //Método get para retornar nome
        return nome;
    }

    public void setNome(String nome) { //Método set para alterar nome
        this.nome = nome;
    }
}
