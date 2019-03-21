package estacionamento.model;

public class Veiculo {

    int idVeiculo;
    String placa;
    String cor;
    String modelo;
    String marca;
    int ativado = 0;
    public Veiculo() {
    }
    
    public Veiculo(int idVeiculo, String placa, String cor, String modelo, String marca) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
    }
    public Veiculo(String placa, String cor, String modelo, String marca) {
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

}
