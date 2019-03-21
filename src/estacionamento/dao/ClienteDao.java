package estacionamento.dao;

import estacionamento.interfaces.DaoI;
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

public class ClienteDao extends Dao implements DaoI<Cliente> {

    @Override
    public List<Cliente> Listar() {
        PreparedStatement stmt;
        ResultSet rs;
        List<Cliente> clientes = new ArrayList<>();
        String sql = ("select * from cliente");
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setCondutor(rs.getString(2));
                cliente.setTipoCliente(rs.getBoolean(3));
                cliente.setValorPagoCliente(rs.getDouble(4));
                cliente.setAtivado(rs.getInt(5));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public List<Cliente> ListarClientesComVeiculo() {
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

    /**
     * Método para cadastrar um cliente no BD
     * <br>Retorna id do cliente cadastrado
     * <br><b>Retorna 0 (zero) se houver erro</b>
     *
     * @param obj
     * @return int
     */
    @Override
    public int cadastrar(Cliente obj) {
        PreparedStatement stmt;
        try {
            String sql = "insert into cliente(";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getCondutor());;
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean alterar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente lerPorId(int termo) {
        PreparedStatement stmt;
        Cliente cliente = new Cliente();
        try {
            String sql = ("select * from cliente where idCliente = ?");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs;
            stmt.setInt(1, termo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(1);
                cliente.setCondutor(rs.getString(2));
                cliente.setTipoCliente(rs.getBoolean(3));
                cliente.setValorPagoCliente(rs.getDouble(4));
                cliente.setAtivado(rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar dados do Cliente:" + ex.getSQLState());
        }
        return cliente;

    }

    @Override
    public List<Cliente> pesquisar(String termo) {
        PreparedStatement stmt;
        List<Cliente> clientesTemp = new ArrayList<>();
        try {
            String sql = "select idcliente, condutor, tipoCliente, valorPagoCliente, ativado from cliente where condutor like '" + termo + "%'";
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setCondutor(rs.getString(2));
                cliente.setTipoCliente(rs.getBoolean(3));
                cliente.setValorPagoCliente(rs.getDouble(4));
                cliente.setAtivado(rs.getInt(5));
                clientesTemp.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getSQLState());
        }

        return clientesTemp;
    }

    public List<Cliente> listarTodosVeiculosComSemClientes(String placa) {
        PreparedStatement stmt;
        List<Cliente> clienteTemp = new ArrayList<>();
        try {
            String sql = ("       SELECT veiculo.idveiculo, veiculo.placa, veiculo.cor, veiculo.modelo, veiculo.marca, veiculo.ativado, cliente.idcliente, cliente.tipocliente,cliente.condutor, cliente.ativado "
                    + " from veiculo "
                    + " left join clienteComVeiculos on "
                    + " veiculo.idVeiculo = clienteComVeiculos.idVeiculo "
                    + " left join cliente on "
                    + " cliente.idcliente = clienteComVeiculos.idcliente "
                    + "  where veiculo.placa like '" + placa + "%'");

            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente  cliente = new Cliente();
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt(1));
                veiculo.setPlaca(rs.getString(2));
                veiculo.setCor(rs.getString(3));
                veiculo.setModelo(rs.getString(4));
                veiculo.setMarca(rs.getString(5));
                veiculo.setAtivado(rs.getInt(6));
                cliente.setVeiculo((List<Veiculo>) veiculo);
                cliente.setIdCliente(rs.getInt(7));
                cliente.setTipoCliente(rs.getBoolean(8));
                cliente.setCondutor(rs.getString(9));
                cliente.setAtivado(rs.getInt(10));
                clienteTemp.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienteTemp;

    }

}
