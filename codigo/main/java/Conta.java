import java.util.ArrayList;

public class Conta {
    private ArrayList<Menu> itensPedidos;
    private int numeroMesa;

    public Conta(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.itensPedidos = new ArrayList<>();
    }

    public void adicionarPedido(Menu menu) {
        itensPedidos.add(menu);
    }

    public void fecharConta() {
        imprimirConta();
        itensPedidos.clear();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Menu menu : itensPedidos) {
            total += menu.getPreco();
        }
        return total * 1.1;
    }

    public void imprimirConta() {
        for (Menu menu : itensPedidos) {
            System.out.println("Item " + menu.getNComida() + ": R$ " + menu.getPreco());
        }
        System.out.println("Total: R$ " + String.format("%.2f", calcularTotal()));
    }

    public ArrayList<Menu> getItensPedidos() {
        return itensPedidos;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setItensPedidos(ArrayList<Menu> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
