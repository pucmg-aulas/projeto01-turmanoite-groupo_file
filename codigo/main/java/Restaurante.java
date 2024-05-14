import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    public ArrayList<Mesa> mesas;

    public Restaurante()
    {
        this.mesas = new ArrayList<Mesa>();
        this.mesas.add(new Mesa(1, 4, null));
        this.mesas.add(new Mesa(2, 4, null));
        this.mesas.add(new Mesa(3, 4, null));
        this.mesas.add(new Mesa(4, 4, null));
        this.mesas.add(new Mesa(5, 6, null));
        this.mesas.add(new Mesa(6, 6, null));
        this.mesas.add(new Mesa(7, 6, null));
        this.mesas.add(new Mesa(8, 6, null));
        this.mesas.add(new Mesa(9, 8, null));
        this.mesas.add(new Mesa(10, 8, null));
    }
}