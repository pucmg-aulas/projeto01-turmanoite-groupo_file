public class RequisicaoPorMesa {
    private String nomeCliente;
    private int nPessoas;
    private Mesa mesaUtilizada;

    public RequisicaoPorMesa(String nomeCliente, int nPessoas, Mesa mesaUtilizada) {
        this.nomeCliente = nomeCliente;
        this.nPessoas = nPessoas;
        this.mesaUtilizada = mesaUtilizada;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNPessoas() {
        return nPessoas;
    }

    public Mesa getMesaUtilizada() {
        return mesaUtilizada;
    }

    public void setMesaUtilizada(Mesa mesaUtilizada) {
        this.mesaUtilizada = mesaUtilizada;
    }
}
