package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Conta implements Serializable {
    
    private ArrayList<Pedido> pedidos;

    public Conta() {
        this.pedidos = new ArrayList<>();
    }

    public Conta(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

   

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedidos(Pedido pedido) {
        this.pedidos.add(pedido);

    }

    public double calculaValor() {
        double valor = 0;
        for (Pedido pedido : pedidos) {
            valor += pedido.getValorTotal();
        }
        valor += valor *  0.1;
        return Math.round(valor * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "" + pedidos;
    }

}
