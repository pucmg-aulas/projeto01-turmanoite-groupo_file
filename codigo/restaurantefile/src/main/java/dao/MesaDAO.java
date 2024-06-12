package dao;

import java.io.*;
import java.util.*;
import model.Mesa;

public class MesaDAO {
    private List<Mesa> mesas;
    private static final String FILE_PATH = "mesas.dat";

    public List<Mesa> getMesas() {
        List<Mesa> mesas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            mesas = (List<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Em caso de erro ou arquivo ainda não existir, retorna uma lista vazia
            // Para o exemplo, não tratamos criação inicial do arquivo, pode ser tratado em produção
            e.printStackTrace();
        }
        return mesas;
    }

    public void salvarMesas(List<Mesa> mesas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(mesas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}