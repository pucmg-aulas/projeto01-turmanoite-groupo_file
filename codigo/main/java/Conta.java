import java.time.LocalTime;
import java.util.ArrayList;
public class Conta {

    private ArrayList<Menu> itensPedidos;
    private int numeroMesa;

    public Conta(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.itensPedidos = new ArrayList<Menu>();
    }
    public void adicionarPedido(Menu menu) {
        itensPedidos.add(menu);
    }

    public void fecharConta() {
        System.out.println("Fechando conta da mesa " + numeroMesa + "...");
        imprimirConta();
        itensPedidos.clear();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Menu menu : itensPedidos) {
            total += menu.getPreco();
        }
        return total;
    }

    public void imprimirConta() {
        System.out.println("Conta da Mesa " + numeroMesa + ":");
        for (Menu menu : itensPedidos) {
            System.out.println("Item " + menu.getNComida() + ": R$ " + menu.getPreco());
        }
        System.out.println("Total: R$ " + String.format("%.2f", calcularTotal()));
    }

    public ArrayList<Menu> getitensPedidos() {
        return itensPedidos;
    }

    public int getMesa() {
        return numeroMesa;
    }

    public void setitensPedidos(ArrayList<Menu> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public void setMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}