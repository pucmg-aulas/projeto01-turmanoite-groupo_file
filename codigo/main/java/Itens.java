public class Itens {
    private String nome;
    private double preco;

    public Itens(String nome, double preco) {

        this.nome = nome;
        this.preco = preco;

    }

    public String getNome() {

        return nome;
    }

    public double getPreco() {

        return preco;
    }

    @Override
    public String toString() {
        
        return nome + " - R$ " + preco;
    }
}