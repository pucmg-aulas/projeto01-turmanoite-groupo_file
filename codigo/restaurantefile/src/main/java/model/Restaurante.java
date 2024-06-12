package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Date;

public class Restaurante {
    private List<Mesa> mesas;
    private Set<Cliente> historicoClientes; 
    private Cardapio cardapio;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.cardapio = new Cardapio();
        this.historicoClientes = new HashSet<>();
        inicializarCardapio();
        inicializarMesas();
    }

    private void inicializarMesas() {
        for (int i = 0; i < 4; i++) this.mesas.add(new Mesa(i + 1, 4));
        for (int i = 4; i < 8; i++) this.mesas.add(new Mesa(i + 1, 6));
        for (int i = 8; i < 10; i++) this.mesas.add(new Mesa(i + 1, 8));
    }

    private void inicializarCardapio() {
        // Pratos
        cardapio.adicionarItem(new ItemMenu("Moqueca de Tilápia", 30.00));
        cardapio.adicionarItem(new ItemMenu("Falafel Assado", 25.00));
        cardapio.adicionarItem(new ItemMenu("Salada Primavera com Macarrão Konjac", 20.00));
        cardapio.adicionarItem(new ItemMenu("Escondidinho de Frango", 28.00));
        cardapio.adicionarItem(new ItemMenu("Strogonoff", 27.00));
        cardapio.adicionarItem(new ItemMenu("Caçarola de carne com legumes", 32.00));

        // Bebidas
        cardapio.adicionarItem(new ItemMenu("Água", 3.00));
        cardapio.adicionarItem(new ItemMenu("Suco", 6.00));
        cardapio.adicionarItem(new ItemMenu("Refrigerante", 4.50));
        cardapio.adicionarItem(new ItemMenu("Cerveja", 8.00));
        cardapio.adicionarItem(new ItemMenu("Taça de vinho", 10.00));
    }




    

    public Mesa getMesa(int idMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getId() == idMesa) {
                return mesa;
            }
        }
        return null;
    }

    public Cardapio getCardapio() {
        return this.cardapio;
    }

    
}
