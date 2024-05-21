import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int nComida;
    private double preco;

    public Menu(int nComida, double preco) {
        this.nComida = nComida;
        this.preco = preco;
        
    }

    public int getNComida() {
        return nComida;
    }

    public double getPreco() {
        return preco;
    }
}