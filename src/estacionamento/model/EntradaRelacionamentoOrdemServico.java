
package estacionamento.model;
public class EntradaRelacionamentoOrdemServico {
int idCliente;
int idVeiculo;
int idServicos;
int idOrdemServico;

    public EntradaRelacionamentoOrdemServico() {
    }

    public EntradaRelacionamentoOrdemServico(int idCliente, int idVeiculo, int idServicos, int idOrdemServico) {
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.idServicos = idServicos;
        this.idOrdemServico = idOrdemServico;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }
   
}
