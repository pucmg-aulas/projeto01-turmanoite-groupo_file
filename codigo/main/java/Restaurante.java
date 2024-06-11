import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Serializable {
    private List<Mesa> mesas;
    private List<String> listadeespera;

    public Restaurante(List<Mesa> mesas) {
        this.mesas = mesas;
        this.listadeespera = new ArrayList<>();
    }

    public void requisitarMesa(List<RequisicaoPorMesa> requisicoes, String nomeCliente, int nPessoas) {
        // Filtrar mesas disponíveis com capacidade suficiente para a quantidade de pessoas
        Mesa disponivel = mesas.stream()
                .filter(mesa -> !mesa.isOcupada() && mesa.getCapacidade() >= nPessoas)
                .findFirst()
                .orElse(null);

        if (disponivel != null) {
            disponivel.ocupar(); // Ocupamos a mesa
            RequisicaoPorMesa novaRequisicao = new RequisicaoPorMesa(nomeCliente, nPessoas, disponivel);
            requisicoes.add(novaRequisicao);
        } else {
            listadeespera.add(nomeCliente);
        }
    }

    public void imprimirLista() {
        for (String nome : listadeespera) {
            System.out.println(nome);
        }
    }

    public void mesaLiberada(int nMesa) {
        mesas.stream()
            .filter(mesa -> mesa.getNumero() == nMesa)
            .findFirst()
            .ifPresent(Mesa::desocupar);
    }

    public void mesasDisponiveis() {
        mesas.stream()
            .filter(mesa -> !mesa.isOcupada())
            .forEach(mesa -> System.out.println("Número: " + mesa.getNumero() + ", Capacidade: " + mesa.getCapacidade()));
    }
    
    public List<Mesa> getMesas() {
        return mesas;
    }
}
