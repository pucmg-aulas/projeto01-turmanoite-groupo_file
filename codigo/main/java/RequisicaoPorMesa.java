
import java.io.Serializable;
public class RequisicaoPorMesa implements Serializable {
    
    
    
    private Cliente cliente;
    private Mesa mesa;
    


    public RequisicaoPorMesa(Mesa mesa, Cliente cliente) {
        
        this.mesa = mesa;
        this.cliente = cliente;
        
    }

    
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public Mesa getMesa() {
        return mesa;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
}
