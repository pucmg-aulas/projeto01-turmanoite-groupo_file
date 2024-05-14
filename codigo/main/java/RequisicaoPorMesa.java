import java.time.LocalTime;

public class RequisicaoPorMesa
{
    private String nomeCliente;
    private int nPessoas;
    
    private Mesa mesaUtilizada;  
    public RequisicaoPorMesa(String nomeCliente, int nPessoas,  Mesa mesa) {
        this.nomeCliente = nomeCliente;
        this.nPessoas = nPessoas;
        
        this.mesaUtilizada = mesa;
    }

    
    
    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public int getNPessoas() {
        return this.nPessoas;
    }

    public Mesa getMesaUtilizada() {
        return this.mesaUtilizada;
    }

    public void setMesaUtilizada(Mesa mesa) {
        this.mesaUtilizada = mesa;
    }

    

    

    
}
