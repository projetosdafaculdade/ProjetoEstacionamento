package estacionamento.model;

public class Servicos {

    int idServicos;
    double valorHora;
    int fracao;
    int ativado = 0;

    public Servicos(double valorHora, int fracao) {
        this.valorHora = valorHora;
        this.fracao = fracao;
    }

    public Servicos() {
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getFracao() {
        return fracao;
    }

    public void setFracao(int fracao) {
        this.fracao = fracao;
    }

    public int getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

}
