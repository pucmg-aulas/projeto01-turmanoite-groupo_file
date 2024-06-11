public class Cliente {
    private String nome;
    private int quantidadePessoas;

    public Cliente(String nome, int quantidadePessoas) {
        this.setNome(nome);
        this.setQuantidadePessoas(quantidadePessoas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }
}
