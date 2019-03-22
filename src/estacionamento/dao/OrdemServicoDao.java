package estacionamento.dao;

import estacionamento.interfaces.DaoI;
import estacionamento.model.Cliente;
import estacionamento.model.OrdemServico;
import estacionamento.model.Servicos;
import estacionamento.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String sql = ("select ordemServico.idOrdemServico, ordemServico.dataEntrada,ordemServico.horaEntrada,ordemServico.dataSaida,ordemServico.horaSaida, ordemServico.valorServico,ordemServico.ativado, cliente.idCliente, servicos.idServicos, veiculo.idVeiculo from OrdemServicoComClienteServico inner join cliente on cliente.idCliente = OrdemServicoComClienteServico.idCliente inner join servicos on servicos.idServicos = OrdemServicoComClienteServico.idServicos inner join ordemServico on ordemServico.idOrdemServico = OrdemServicoComClienteServico.idOrdemServico inner join veiculo on veiculo.idVeiculo = OrdemServicoComClienteServico.idVeiculo");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setIdOrdemServico(rs.getInt(1));
                ordemServico.setDataEntrada(rs.getDate(2));
                ordemServico.setHoraEntrada(rs.getTime(3));
                ordemServico.setDataSaida(rs.getDate(4));
                ordemServico.setHoraSaida(rs.getTime(5));
                ordemServico.setValorServico(rs.getDouble(6));
                ordemServico.setAtivado(rs.getInt(rs.getInt(7)));

                ClienteDao clientedao = new ClienteDao();
                Cliente cliente = clientedao.lerPorId(rs.getInt(8));
                ordemServico.setCliente(cliente);

                ServicosDao servicosDao = new ServicosDao();
                Servicos servicos = servicosDao.lerPorId(rs.getInt(9));
                ordemServico.setServico(servicos);

                VeiculoDao veiculoDao = new VeiculoDao();
                Veiculo veiculo = veiculoDao.lerPorId(rs.getInt(10));
                ordemServico.setVeiculo(veiculo);

                ordemServicos.add(ordemServico);
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordemServicos;
    }

    @Override
    public int cadastrar(OrdemServico obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(OrdemServico obj) {
        PreparedStatement stmt;

        try {
            String sql = "UPDATE ordemServico SET valorServico = ?,dataEntrada = ?,horaEntrada = ?,dataSaida= ?, horaSaida= ?,cliente = ?,  servico = ?, ativado =?  WHERE idOrdemServico = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(9, obj.getIdOrdemServico());
            stmt.setDouble(1, obj.getValorServico());
            stmt.setDate(2, obj.getDataEntrada());
            stmt.setTime(3, obj.getHoraEntrada());
            stmt.setDate(4, obj.getDataSaida());
            stmt.setTime(5, obj.getHoraSaida());
            stmt.setInt(6, obj.getCliente().getIdCliente());
            stmt.setInt(7, obj.getServico().getIdServicos());
            stmt.setInt(8, obj.getAtivado());
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
