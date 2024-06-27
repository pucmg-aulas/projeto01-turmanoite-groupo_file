package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Atendimento implements Serializable {

    private Cliente cliente;
    private int quantPessoas;
    private Mesa mesa;
    private Conta comanda;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private MetodoPagamento metodoPagamento;

    public Atendimento(Cliente cliente, int quantPessoas) {
        this.cliente = cliente;
        this.quantPessoas = quantPessoas;
        this.data = LocalDate.now();
        this.horaEntrada = LocalTime.now();
        this.comanda = new Conta();
        this.mesa = null;
    }

    public Atendimento(Cliente cliente, int quantPessoas, Mesa mesa, Conta comanda, LocalDate data,
    LocalTime horaEntrada, LocalTime horaSaida, MetodoPagamento metodoPagamento) {
        this.cliente = cliente;
        this.quantPessoas = quantPessoas;
        this.mesa = mesa;
        this.comanda = comanda;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.metodoPagamento = metodoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getQuantPessoas() {
        return quantPessoas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setQuantPessoas(int quantPessoas) {
        this.quantPessoas = quantPessoas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Conta getComanda() {
        return comanda;
    }

    public void setComanda(Conta comanda) {
        this.comanda = comanda;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public String toString() {
        return cliente + "%" + quantPessoas + "%" + mesa + "%" + comanda + "%" + data + "%" + horaEntrada + "%" + horaSaida + "%" + metodoPagamento;
    }
}
