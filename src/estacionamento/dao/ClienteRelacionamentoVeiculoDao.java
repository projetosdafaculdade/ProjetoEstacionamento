package estacionamento.dao;

import estacionamento.model.Cliente;
import estacionamento.model.PesquisarClienteVeiculo;
import estacionamento.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteRelacionamentoVeiculoDao extends Dao {

    public List<Cliente> listar() {
        PreparedStatement stmt;
        ResultSet rs;
        List<Cliente> clientes = new ArrayList<>();
        String sql = ("select cliente.idcliente,cliente.condutor,veiculo.idVeiculo,cliente.tipocliente, cliente.valorPagoCliente,cliente.ativado "
                + "from veiculo "
                + "inner join clienteComVeiculos on "
                + "clienteComVeiculos.idVeiculo = veiculo.idVeiculo "
                + "inner join cliente on "
                + "clienteComVeiculos.idCliente = cliente.idCliente");
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setCondutor(rs.getString(2));
                VeiculoDao veiculoDao = new VeiculoDao();
                cliente.setVeiculo(veiculoDao.listarPorId(rs.getInt(3)));
                cliente.setTipoCliente(rs.getBoolean(4));
                cliente.setValorPagoCliente(rs.getDouble(5));
                cliente.setAtivado(rs.getInt(6));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public List<Cliente> listarTodosVeiculosComESemClientes(String placa) {
        PreparedStatement stmt;
        List<Cliente> clienteTemp = new ArrayList<>();
        try {
            String sql = ("SELECT veiculo.idveiculo, veiculo.placa, veiculo.cor, veiculo.modelo, veiculo.marca, veiculo.ativado, cliente.idcliente, cliente.tipocliente,cliente.condutor, cliente.ativado "
                    + " from veiculo "
                    + " left join clienteComVeiculos on "
                    + " veiculo.idVeiculo = clienteComVeiculos.idVeiculo "
                    + " left join cliente on "
                    + " cliente.idcliente = clienteComVeiculos.idcliente "
                    + "  where veiculo.placa like '" + placa + "%'");

            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt(1));
                veiculo.setPlaca(rs.getString(2));
                veiculo.setCor(rs.getString(3));
                veiculo.setModelo(rs.getString(4));
                veiculo.setMarca(rs.getString(5));
                veiculo.setAtivado(rs.getInt(6));
                cliente.addVeiculo(veiculo);
                cliente.setIdCliente(rs.getInt(7));
                cliente.setTipoCliente(rs.getBoolean(8));
                cliente.setCondutor(rs.getString(9));
                cliente.setAtivado(rs.getInt(10));
                clienteTemp.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar todos os veiculos que tenham cliente ou não:" + ex.getMessage());
        }
        return clienteTemp;

    }

    public List<Cliente> veiculosPorIdCliente(int id) {
        PreparedStatement stmt;
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = ("select veiculo.idVeiculo, veiculo.placa, veiculo.cor, veiculo.modelo, veiculo.marca, veiculo.ativado, cliente.idcliente,cliente.tipocliente,cliente.condutor, cliente.ativado from veiculo inner join clienteComVeiculos on clienteComVeiculos.idVeiculo = veiculo.idVeiculo inner join cliente on clienteComVeiculos.idCliente = cliente.idCliente where cliente.idcliente = ?");
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente clienteTemp = new Cliente();

                Veiculo veiculo = new Veiculo();
                List<Veiculo> veiculos = new ArrayList<>();
                veiculo.setIdVeiculo(rs.getInt(1));
                veiculo.setPlaca(rs.getString(2));
                veiculo.setCor(rs.getString(3));
                veiculo.setModelo(rs.getString(4));
                veiculo.setMarca(rs.getString(5));
                veiculo.setAtivado(rs.getInt(6));
                veiculos.add(veiculo);
                clienteTemp.setVeiculo(veiculos);
                clienteTemp.setTipoCliente(rs.getBoolean(8));
                clienteTemp.setIdCliente(rs.getInt(7));
                clienteTemp.setCondutor(rs.getString(9));
                clienteTemp.setAtivado(rs.getInt(10));
                clientes.add(clienteTemp);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar Veículos dos clientes:" + ex.getSQLState());
        }
        return clientes;
    }

///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
    public Cliente buscarPorPlaca(String placa) {
        PreparedStatement stmt;
        Cliente cliente = new Cliente();
        try {
            String sql = ("select veiculo.idVeiculo, veiculo.placa, veiculo.cor, veiculo.modelo, veiculo.marca, veiculo.ativado, cliente.idCliente, cliente.tipoCliente, cliente.condutor, cliente.ativado from veiculo inner join clienteComVeiculos on clienteComVeiculos.idVeiculo = veiculo.idVeiculo inner join cliente on clienteComVeiculos.idCliente = cliente.idcliente where veiculo.placa = ?");
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt(1));
                veiculo.setPlaca(rs.getString(2));
                veiculo.setCor(rs.getString(3));
                veiculo.setModelo(rs.getString(4));
                veiculo.setMarca(rs.getString(5));
                veiculo.setAtivado(rs.getInt(6));
                cliente.addVeiculo(veiculo);
                cliente.setIdCliente(rs.getInt(7));
                cliente.setTipoCliente(rs.getBoolean(8));
                cliente.setCondutor(rs.getString(9));
                cliente.setAtivado(rs.getInt(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
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

    public void criarRelacionamento(int idCliente, int idVeiculo) {
        PreparedStatement stmt;
        try {
            String sql = "insert into clienteComVeiculos(idCliente, idVeiculo) values (?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idVeiculo);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao criar relacionamento entre veiculo e cliente: " + ex.getMessage());
        }
    }

    public void alterarRelacionamento(int idCliente, int idVeiculo) {
        PreparedStatement stmt;
        try {
            String sql = "update clienteComVeiculos set idCliente = ?, idVeiculo = ? where idVeiculo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idVeiculo);
            stmt.setInt(3, idVeiculo);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar relacionamento entre veiculo e cliente: " + ex.getMessage());
        }
    }

    public void removerRelacionamento(int idVeiculo) {
        PreparedStatement stmt;
        try {
            String sql = "delete from clienteComVeiculos where idVeiculo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover um relacionamento" + ex.getMessage());
        }
    }

    public boolean verificarExistência(int idVeiculo) {
        PreparedStatement stmt;
        try {
            String sql = "select * from clienteComVeiculos where idVeiculo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao verificar existência de relacionamento do veiculo " + ex.getMessage());
        }
        return false;
    }

}
