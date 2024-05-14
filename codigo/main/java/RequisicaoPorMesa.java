public class RequisicaoPorMesa
{
    private Cliente cliente;
    private Mesa mesa = null;
    public RequisicaoPorMesa( Cliente c, Restaurante restaurante,FIlaDeEspera f) {
        setCliente(c);

        for (int i = 0; i <= restaurante.mesas.size(); i++) {
            if (!restaurante.mesas.get(i).isOcupada()) {
                if (this.cliente.getQuantidadePessoas() <= restaurante.mesas.get(i).getCapacidade()) {
                    System.out.println("Mesa disponivel");
                    restaurante.mesas.get(i).setOcupada(true);
                    this.setMesa(restaurante.mesas.get(i));
                    break;
                }
            }
        }
        if(this.getMesa() == null){
            f.adicionarAFila(c);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}