package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.model.Mesa;

public class Mesas extends AbstractDao implements Serializable {

    private List<Mesa> mesas;
    private static Mesas instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Mesas.dat";

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
        this.mesas = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, mesas);
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
            if (mesa.getQuantCadeiras() == quantCadeiras)
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

    public boolean altera(Mesa mesaExistente, int numero) {
        try {
            ArrayList<Mesa> listaTemp = new ArrayList<Mesa>();

            for (Iterator<Mesa> it = mesas.iterator(); it.hasNext();) {
                Mesa mesa = it.next();
                if (mesa.getNumero() != numero)
                    listaTemp.add(mesa);
                else
                    listaTemp.add(mesaExistente);
            }

            mesas.removeAll(mesas);
            mesas.addAll(listaTemp);
            grava();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}