import java.time.LocalDateTime;
import java.io.Serializable;
public class Cliente  implements Serializable{
    private String nome;
    private int quantidadePessoas;


    public Cliente(String nome, int quantidadePessoas) {
        this.nome = nome;
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getNome() { //Método get para retornar nome
        return nome;
    }

    public void setNome(String nome) { //Método set para alterar nome
        this.nome = nome;
    }

   
    public int getQuantidadePessoas() { //Método get para retornar quantidadePessoas
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) { //Método set para alterar quantidadePessoas
        this.quantidadePessoas = quantidadePessoas;
    }

    
}
