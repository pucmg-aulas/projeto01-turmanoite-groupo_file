import java.util.ArrayList;
public class FIlaDeEspera
{
    private ArrayList<Cliente> fila;

    public void adicionarAFila(Cliente c)
    {
        fila.add(c);
    }
    public void removerDaFila(Cliente c)
    {
        fila.remove(c);
    }

    public ArrayList<Cliente> getFila()
    {
        return this.fila;
    }
}
