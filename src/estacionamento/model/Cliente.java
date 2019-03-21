package estacionamento.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    int idCliente;
    String condutor;
    List<Veiculo> veiculos;
    boolean tipoCiente;
    double valorPagoCliente;
    int ativado;

//<editor-fold desc="Getters, Setters e Construtores">
    public Cliente(String condutor, boolean tipoCiente) {
        this.condutor = condutor;
        this.tipoCiente = tipoCiente;
    }

    public Cliente() {
        this.veiculos = new ArrayList<>();
    }

    public Cliente(int idCliente, String condutor, boolean tipoCiente, double valorPagoCliente, int ativado) {
        this.idCliente = idCliente;
        this.condutor = condutor;
        this.tipoCiente = tipoCiente;
        this.valorPagoCliente = valorPagoCliente;
        this.ativado = ativado;
    }

    public String getCondutor() {
        return condutor;
    }


    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void setCondutor(String condutor) {
        this.condutor = condutor;
    }

    public List<Veiculo> getVeiculo() {
        return veiculos;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculos = veiculo;
    }

    public boolean isTipoCiente() {
        return tipoCiente;
    }

    public void setTipoCliente(boolean tipoCiente) {
        this.tipoCiente = tipoCiente;
    }

    public double getValorPagoCliente() {
        return valorPagoCliente;
    }

    public void setValorPagoCliente(double valorPagoCliente) {
        this.valorPagoCliente = valorPagoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

// </editor-fold>
}
