package estacionamento.dao;

import estacionamento.interfaces.DaoI;
import estacionamento.model.Cliente;
import estacionamento.model.OrdemServico;
import estacionamento.model.Servicos;
import estacionamento.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdemServicoDao extends Dao implements DaoI<OrdemServico> {

    @Override
    public List<OrdemServico> listar() {
        PreparedStatement stmt;
        List<OrdemServico> ordemServicos = new ArrayList<>();

        try {
            String sql = ("select ordemServico.idOrdemServico, ordemServico.dataTimeEntrada,ordemServico.dataTimeSaida, ordemServico.valorServico,ordemServico.ativado, cliente.idCliente, servicos.idServicos, veiculo.idVeiculo from OrdemServicoComClienteServico inner join cliente on cliente.idCliente = OrdemServicoComClienteServico.idCliente inner join servicos on servicos.idServicos = OrdemServicoComClienteServico.idServicos inner join ordemServico on ordemServico.idOrdemServico = OrdemServicoComClienteServico.idOrdemServico inner join veiculo on veiculo.idVeiculo = OrdemServicoComClienteServico.idVeiculo");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setIdOrdemServico(rs.getInt(1));
                ordemServico.setDataTimeEntrada(rs.getLong(2));
                ordemServico.setDataTimeSaida(rs.getLong(3));
                ordemServico.setValorServico(rs.getDouble(4));
                ordemServico.setAtivado(rs.getInt(rs.getInt(5)));

                ClienteDao clientedao = new ClienteDao();
                Cliente cliente = clientedao.lerPorId(rs.getInt(6));
                ordemServico.setCliente(cliente);

                ServicosDao servicosDao = new ServicosDao();
                Servicos servicos = servicosDao.lerPorId(rs.getInt(7));
                ordemServico.setServico(servicos);

                VeiculoDao veiculoDao = new VeiculoDao();
                Veiculo veiculo = veiculoDao.lerPorId(rs.getInt(8));
                ordemServico.getCliente().addVeiculo(veiculo);

                ordemServicos.add(ordemServico);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordemServicos;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public int cadastrar(OrdemServico obj) {
        PreparedStatement stmt;

        try {
            String sql = "insert into ordemServico(valorServico,dataTimeEntrada) values(?,?) ";
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, obj.getValorServico());
            stmt.setLong(2, obj.getDataTimeEntrada());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar Ordem de serviço: " + ex.getMessage());
        }
        return 0;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean alterar(OrdemServico obj) {
        PreparedStatement stmt;

        try {
            String sql = "UPDATE ordemServico SET valorServico = ?,dataTimeEntrada = ?,dataTimeSaida= ?, ativado =?  WHERE idOrdemServico = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, obj.getValorServico());
            stmt.setLong(2, obj.getDataTimeEntrada());
            stmt.setLong(3, obj.getDataTimeSaida());
            stmt.setInt(4, obj.getAtivado());
            stmt.setInt(5, obj.getIdOrdemServico());
            int status = stmt.executeUpdate();
            if (status > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deletar(int id) {
        PreparedStatement stmt;

        try {
            String sql = "UPDATE ordemServico SET ativado = 0 WHERE idOrdemServico = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public OrdemServico lerPorId(int termo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdemServico> pesquisar(String termo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
