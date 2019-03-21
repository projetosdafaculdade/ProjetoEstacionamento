package estacionamento.dao;

import estacionamento.model.PesquisarClienteVeiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PesquisarClienteVeiculoDao extends Dao {

    public List<PesquisarClienteVeiculo> listar() {
        PreparedStatement stmt;
        List<PesquisarClienteVeiculo> pesquisarClienteVeiculos = new ArrayList<>();
        try {
            String sql = ("select idVeiculo, placa, cor, modelo, marca, veiculo.ativado, idcliente,tipocliente,condutor, cliente.ativado from veiculo inner join cliente on veiculo.idveiculo  = cliente.veiculo");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PesquisarClienteVeiculo pesquisarClienteVeiculo = new PesquisarClienteVeiculo();
                pesquisarClienteVeiculo.setIdVeiculo(rs.getInt(1));
                pesquisarClienteVeiculo.setPlaca(rs.getString(2));
                pesquisarClienteVeiculo.setCor(rs.getString(3));
                pesquisarClienteVeiculo.setModelo(rs.getString(4));
                pesquisarClienteVeiculo.setMarca(rs.getString(5));
                pesquisarClienteVeiculo.setAtivadoVeiculo(rs.getInt(6));
                pesquisarClienteVeiculo.setIdCliente(rs.getInt(7));
                pesquisarClienteVeiculo.setTipoCiente(rs.getBoolean(8));
                pesquisarClienteVeiculo.setCondutor(rs.getString(9));
                pesquisarClienteVeiculo.setAtivadoCliente(rs.getInt(10));
                pesquisarClienteVeiculos.add(pesquisarClienteVeiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pesquisarClienteVeiculos;
    }

    public List<PesquisarClienteVeiculo> veiculosPorIdCliente(int id) {
        PreparedStatement stmt;
        List<PesquisarClienteVeiculo> pesquisarClienteVeiculos = new ArrayList<>();
        try {
            String sql = ("select veiculo.idVeiculo, veiculo.placa, veiculo.cor, veiculo.modelo, veiculo.marca, veiculo.ativado, cliente.idcliente,cliente.tipocliente,cliente.condutor, cliente.ativado from veiculo inner join clienteComVeiculos on clienteComVeiculos.idVeiculo = veiculo.idVeiculo inner join cliente on clienteComVeiculos.idCliente = cliente.idCliente where cliente.idcliente = ?");
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PesquisarClienteVeiculo pesquisarClienteVeiculo = new PesquisarClienteVeiculo();
                pesquisarClienteVeiculo.setIdVeiculo(rs.getInt(1));
                pesquisarClienteVeiculo.setPlaca(rs.getString(2));
                pesquisarClienteVeiculo.setCor(rs.getString(3));
                pesquisarClienteVeiculo.setModelo(rs.getString(4));
                pesquisarClienteVeiculo.setMarca(rs.getString(5));
                pesquisarClienteVeiculo.setAtivadoVeiculo(rs.getInt(6));
                pesquisarClienteVeiculo.setIdCliente(rs.getInt(7));
                pesquisarClienteVeiculo.setTipoCiente(rs.getBoolean(8));
                pesquisarClienteVeiculo.setCondutor(rs.getString(9));
                pesquisarClienteVeiculo.setAtivadoCliente(rs.getInt(10));
                pesquisarClienteVeiculos.add(pesquisarClienteVeiculo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar Veículos dos clientes:"+ex.getSQLState());
        }
        return pesquisarClienteVeiculos;
    }

    public PesquisarClienteVeiculo buscarPorPlaca(String placa) {
        PreparedStatement stmt;
        PesquisarClienteVeiculo pesquisarClienteVeiculo = new PesquisarClienteVeiculo();
        try {
            String sql = ("select veiculo.idVeiculo, veiculo.placa, veiculo.cor, veiculo.modelo, veiculo.marca, veiculo.ativado, cliente.idCliente, cliente.tipoCliente, cliente.condutor, cliente.ativado from veiculo inner join clienteComVeiculos on clienteComVeiculos.idVeiculo = veiculo.idVeiculo inner join cliente on clienteComVeiculos.idCliente = cliente.idcliente where veiculo.placa = ?");
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pesquisarClienteVeiculo.setIdVeiculo(rs.getInt(1));
                pesquisarClienteVeiculo.setPlaca(rs.getString(2));
                pesquisarClienteVeiculo.setCor(rs.getString(3));
                pesquisarClienteVeiculo.setModelo(rs.getString(4));
                pesquisarClienteVeiculo.setMarca(rs.getString(5));
                pesquisarClienteVeiculo.setAtivadoVeiculo(rs.getInt(6));
                pesquisarClienteVeiculo.setIdCliente(rs.getInt(7));
                pesquisarClienteVeiculo.setTipoCiente(rs.getBoolean(8));
                pesquisarClienteVeiculo.setCondutor(rs.getString(9));
                pesquisarClienteVeiculo.setAtivadoCliente(rs.getInt(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pesquisarClienteVeiculo;
    }

    public List<PesquisarClienteVeiculo> listarPorPlaca(String placa) {
        PreparedStatement stmt;
        List<PesquisarClienteVeiculo> pesquisarClienteVeiculos = new ArrayList<>();
        try {
            String sql = ("select idVeiculo, placa, cor, modelo, marca, veiculo.ativado, idcliente,tipocliente,condutor, cliente.ativado from veiculo inner join cliente on veiculo.idveiculo  = cliente.veiculo where placa like '" + placa + "%'");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PesquisarClienteVeiculo pesquisarClienteVeiculo = new PesquisarClienteVeiculo();
                pesquisarClienteVeiculo.setIdVeiculo(rs.getInt(1));
                pesquisarClienteVeiculo.setPlaca(rs.getString(2));
                pesquisarClienteVeiculo.setCor(rs.getString(3));
                pesquisarClienteVeiculo.setModelo(rs.getString(4));
                pesquisarClienteVeiculo.setMarca(rs.getString(5));
                pesquisarClienteVeiculo.setAtivadoVeiculo(rs.getInt(6));
                pesquisarClienteVeiculo.setIdCliente(rs.getInt(7));
                pesquisarClienteVeiculo.setTipoCiente(rs.getBoolean(8));
                pesquisarClienteVeiculo.setCondutor(rs.getString(9));
                pesquisarClienteVeiculo.setAtivadoCliente(rs.getInt(10));
                pesquisarClienteVeiculos.add(pesquisarClienteVeiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pesquisarClienteVeiculos;
    }

}
