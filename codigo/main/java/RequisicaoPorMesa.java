public class RequisicaoPorMesa
{
    private Mesa mesa;
    private Cliente cliente;

    public RequisicaoPorMesa( Mesa m, Cliente c)
    {
        this.setMesa(m);
        this.setCliente(c);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}