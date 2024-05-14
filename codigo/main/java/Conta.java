import java.util.ArrayList; 
public class Conta {

    private List<Cardapio> itens;
    private Mesa mesa;

    public Conta(List<Cardapio> itens, Mesa mesa) {
        this.itens = itens;
        this.mesa = mesa;
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (i = 0; i < itens.size(); i++) {
            total += itens.get(i).getPreco();
        }
        return total;
    }

    public List<Cardapio> getItens() {
        return itens;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setItens(List<Cardapio> itens) {
        this.itens = itens;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}