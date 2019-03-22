package estacionamento.model;

public class Servicos {

    int idServicos;
    double valorPublico;
    double valorServidor;
    int fracao;
    int ativado = 0;

    public Servicos() {
    }

    public Servicos(int idServicos, double valorPublico, double valorServidor, int fracao) {
        this.idServicos = idServicos;
        this.valorPublico = valorPublico;
        this.valorServidor = valorServidor;
        this.fracao = fracao;
    }

    public int getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    public double getValorPublico() {
        return valorPublico;
    }

    public void setValorPublico(double valorPublico) {
        this.valorPublico = valorPublico;
    }

    public double getValorServidor() {
        return valorServidor;
    }

    public void setValorServidor(double valorServidor) {
        this.valorServidor = valorServidor;
    }

    public int getFracao() {
        return fracao;
    }

    public void setFracao(int fracao) {
        this.fracao = fracao;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

}
