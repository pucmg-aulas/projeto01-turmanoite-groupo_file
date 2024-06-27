package dao;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import model.*;

/**
 *
 * @author danil
 */
public class Mesas extends AbstractDAO implements Serializable {

    private List<Mesa> mesas;
    private static Mesas instance;

    private final String arq = "./src/main/java/data/Mesas.dat";

    private Mesas() {
        this.mesas = new ArrayList<>();
        carregaMesas();
    }

    public static Mesas getInstance() {
        if (instance == null)
            instance = new Mesas();
        return instance;
    }

    public void addMesa(Mesa mesa) {
        int numero = 1;
        if (mesas.size() > 0) {
            numero = mesas.getLast().getNumero() + 1;
        }
        mesa.setNumero(numero);
        this.mesas.add(mesa);
        grava();
    }

    private void carregaMesas() {
        this.mesas = super.leitura(arq);
    }

    private void grava() {
        super.grava(arq, mesas);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void excluirMesa(Mesa mesa) {
        mesas.remove(mesa);
        grava();
    }

    public Mesa buscarMesaPorQuantidadeCadeiras(int quantCadeiras) {
        for (Mesa mesa : mesas) {
            if (mesa.getQuantidade() == quantCadeiras)
                return mesa;
        }
        return null;
    }

    public Mesa buscarMesaPorNumero(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numero)
                return mesa;
        }
        return null;
    }

   
}