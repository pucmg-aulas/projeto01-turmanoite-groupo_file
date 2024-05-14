import java.util.ArrayList;
public class Conta {

    private ArrayList<Cardapio> itens;
    private Mesa mesa;

    public Conta(Mesa mesa) {
        this.mesa = mesa;
        this.itens = new ArrayList<Cardapio>();
    }
    public void addPedido (Cardapio c) {
        itens.add(c);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < itens.size(); i++) {
            total += itens.get(i).getPreco(); // Adiciona o valor do item à variável total
        }
        return total;
    }

    public ArrayList<Cardapio> getItens() {
        return itens;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setItens(ArrayList<Cardapio> itens) {
        this.itens = itens;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}