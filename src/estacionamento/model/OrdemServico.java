package estacionamento.model;


public class OrdemServico {

    int idOrdemServico;
    long dataTimeEntrada;
    long dataTimeSaida;
    Cliente cliente;
    Veiculo veiculo;
    Servicos servico;
    double valorServico;
    int ativado;

    public OrdemServico(int idOrdemServico, long dataTimeEntrada, long dataTimeSaida, Cliente cliente, Veiculo veiculo, Servicos servico, double valorServico) {
        this.idOrdemServico = idOrdemServico;
        this.dataTimeEntrada = dataTimeEntrada;
        this.dataTimeSaida = dataTimeSaida;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servico = servico;
        this.valorServico = valorServico;
    }

    public long getDataTimeEntrada() {
        return dataTimeEntrada;
    }

    public long getDataTimeSaida() {
        return dataTimeSaida;
    }

    public OrdemServico() {
        this.valorServico = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setDataTimeEntrada(long dataTimeEntrada) {
        this.dataTimeEntrada = dataTimeEntrada;
    }

    public void setDataTimeSaida(long dataTimeSaida) {
        this.dataTimeSaida = dataTimeSaida;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}
