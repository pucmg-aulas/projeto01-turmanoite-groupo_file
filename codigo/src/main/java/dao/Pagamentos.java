package dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 *
 * @author danil
 */
public class Pagamentos extends AbstractDAO implements Serializable {

    private List<Pagamento> pagamentos;
    private static Pagamentos instance;

    private final String arq = "./src/main/java/data/Pagamentos.dat";

    private Pagamentos() {
        this.pagamentos = new ArrayList<>();
        carregaMesas();
    }

    public static Pagamentos getInstance() {
        if (instance == null)
            instance = new Pagamentos();
        return instance;
    }

    public void addPagamento(Pagamento pagamento) {
        Pagamento pagamentoPorData = buscarPagamentoPorData(pagamento.getData());
        if (pagamentoPorData != null) {
            double valorAtual = pagamentoPorData.getValor() + pagamento.getValor();
            pagamentoPorData.setValor(valorAtual);
        } else {
            pagamentos.add(pagamento);
        }
        grava();
    }

    private void carregaMesas() {
        this.pagamentos = super.leitura(arq);
    }

    private void grava() {
        super.grava(arq, pagamentos);
    }

    public List<Pagamento> getMesas() {
        return pagamentos;
    }

    public void excluirMesa(Pagamento pagamento) {
        pagamentos.remove(pagamento);
        grava();
    }

    public Pagamento buscarPagamentoPorData(LocalDate data) {
        return pagamentos.stream()
                .filter(pagamento -> pagamento.getData().equals(data))
                .findFirst()
                .orElse(null);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

}