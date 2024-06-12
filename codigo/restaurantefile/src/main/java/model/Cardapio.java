package model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<ItemMenu> itens;

    public Cardapio() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public ItemMenu getItemPorNome(String nome) {
        for (ItemMenu item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null; // Retorna null se o item não for encontrado
    }

    public List<ItemMenu> getItens() {
        return itens;
    }
}
