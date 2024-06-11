import java.util.List;

public class RestauranteController {
    private Restaurante restaurante;
    private List<RequisicaoPorMesa> requisicoes;

    public RestauranteController(Restaurante restaurante, List<RequisicaoPorMesa> requisicoes) {
        this.restaurante = restaurante;
        this.requisicoes = requisicoes;
    }

    public void requisitarMesa(String nomeCliente, int nPessoas) {
        restaurante.requisitarMesa(requisicoes, nomeCliente, nPessoas);
    }

    public void liberarMesa(int nMesa) {
        restaurante.mesaLiberada(nMesa);
    }

    public void mostrarMesasDisponiveis() {
        restaurante.mesasDisponiveis();
    }

    public void imprimirListaEspera() {
        restaurante.imprimirLista();
    }

    public void adicionarPedido(int numeroMesa, Menu menu) {
        Mesa mesa = restaurante.getMesas().stream()
            .filter(m -> m.getNumero() == numeroMesa)
            .findFirst()
            .orElse(null);
        if (mesa != null && mesa.temContaAberta()) {
            mesa.getContaMesa().adicionarPedido(menu);
        }
    }

    public void fecharConta(int numeroMesa) {
        Mesa mesa = restaurante.getMesas().stream()
            .filter(m -> m.getNumero() == numeroMesa)
            .findFirst()
            .orElse(null);
        if (mesa != null && mesa.temContaAberta()) {
            mesa.desocupar();
        }
    }
}
