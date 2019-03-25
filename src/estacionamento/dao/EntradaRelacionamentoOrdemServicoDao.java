package estacionamento.dao;

import estacionamento.model.OrdemServico;
import estacionamento.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntradaRelacionamentoOrdemServicoDao extends Dao {

    public void criarRelacionamento(OrdemServico ordemServico) {

        PreparedStatement stmt;

        try {
            String sql = "insert into OrdemServicoComClienteServico(idCliente,idServicos,idVeiculo,idOrdemServico) values (?,?,?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, ordemServico.getCliente().getIdCliente());
            stmt.setInt(2, ordemServico.getServico().getIdServicos());
            stmt.setInt(3, ordemServico.getCliente().getVeiculo().get(0).getIdVeiculo());
            stmt.setInt(4, ordemServico.getIdOrdemServico());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar relacionamento da entrada da ordem de serviço: " + ex.getMessage());
        }

    }

    public List<OrdemServico> buscarRelacionamentosAtivos() {
        PreparedStatement stmt;
        List<OrdemServico> ordemServicos = new ArrayList<>();
        try {
            String sql = " select cliente.idcliente, cliente.condutor, cliente.tipoCliente, cliente.ValorPagoCliente, cliente.Ativado, "
                    + "	   veiculo.IdVeiculo, veiculo.ativado,veiculo.cor, veiculo.marca,veiculo.modelo,veiculo.placa, "
                    + "    servicos.idServicos, servicos.fracao, servicos.valorPublico, servicos.valorServidor, servicos.ativado, "
                    + "    ordemServico.idOrdemServico, ordemServico.dataTimeEntrada, ordemServico.dataTimeSaida, ordemServico.ativado,ordemServico.valorServico "
                    + "from OrdemServicoComClienteServico as geral "
                    + "inner join ordemServico on "
                    + "geral.idOrdemServico = ordemServico.idOrdemServico "
                    + "inner join cliente on  "
                    + "geral.idcliente = cliente.idcliente "
                    + "inner join veiculo on "
                    + "geral.idveiculo = veiculo.idveiculo "
                    + "inner join servicos on "
                    + "geral.idservicos = servicos.idservicos "
                    + "where ordemServico.ativado = 1";
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.getCliente().setIdCliente(rs.getInt(1));
                ordemServico.getCliente().setCondutor(rs.getString(2));
                ordemServico.getCliente().setTipoCliente(rs.getBoolean(3));
                ordemServico.getCliente().setValorPagoCliente(rs.getDouble(4));
                ordemServico.getCliente().setAtivado(rs.getInt(5));

                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt(6));
                veiculo.setAtivado(rs.getInt(7));
                veiculo.setCor(rs.getString(8));
                veiculo.setMarca(rs.getString(9));
                veiculo.setModelo(rs.getString(10));
                veiculo.setPlaca(rs.getString(11));
                ordemServico.getCliente().addVeiculo(veiculo);

                ordemServico.getServico().setIdServicos(rs.getInt(12));
                ordemServico.getServico().setFracao(rs.getInt(13));
                ordemServico.getServico().setValorPublico(rs.getDouble(14));
                ordemServico.getServico().setValorServidor(rs.getDouble(15));
                ordemServico.getServico().setAtivado(rs.getInt(16));

                ordemServico.setIdOrdemServico(rs.getInt(17));
                ordemServico.setDataTimeEntrada(rs.getLong(18));
                ordemServico.setDataTimeSaida(rs.getLong(19));
                ordemServico.setAtivado(rs.getInt(20));
                ordemServico.setValorServico(rs.getDouble(21));

                ordemServicos.add(ordemServico);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar entradas do relacionamento da ordemDeServiço do BD: " + ex.getMessage());
        }
        return ordemServicos;
    }

    public void excluirRelacionamento() {

    }
}
