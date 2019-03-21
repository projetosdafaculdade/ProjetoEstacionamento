package estacionamento.model;

import java.util.List;

public class Cliente {

    int idCliente;
    String condutor;
    List<Veiculo> veiculo;
    boolean tipoCiente;
    double valorPagoCliente;
    int ativado;

    public Cliente(String condutor, boolean tipoCiente) {
        this.condutor = condutor;
        this.tipoCiente = tipoCiente;
    }

    public Cliente() {
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

    public void setCondutor(String condutor) {
        this.condutor = condutor;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
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
    

}
