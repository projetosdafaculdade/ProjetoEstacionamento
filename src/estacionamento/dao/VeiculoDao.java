package estacionamento.dao;

import estacionamento.interfaces.DaoI;
import estacionamento.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDao extends Dao implements DaoI<Veiculo> {

    @Override
    public List<Veiculo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cadastrar(Veiculo obj) {
        PreparedStatement stmt;
        try {
            String sql = "insert into veiculo(cor, placa, modelo, marca) values(?,?,?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getCor());
            stmt.setString(2, obj.getPlaca());
            stmt.setString(3, obj.getModelo());
            stmt.setString(4, obj.getMarca());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean alterar(Veiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo lerPorId(int termo) {
        PreparedStatement stmt;
        Veiculo veiculo = new Veiculo();
        try {
            String sql = ("select * from veiculo where idVeiculo = ?");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs;
            stmt.setInt(1, termo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                veiculo.setIdVeiculo(rs.getInt(1));
                veiculo.setPlaca(rs.getString(2));
                veiculo.setCor(rs.getString(3));
                veiculo.setModelo(rs.getString(4));
                veiculo.setMarca(rs.getString(5));
                veiculo.setAtivado(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }

    public List<Veiculo> listarPorId(int termo) {
        PreparedStatement stmt;
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            String sql = ("select veiculo.idVeiculo, veiculo.placa, veiculo.cor,veiculo.modelo, veiculo.marca, veiculo.ativado from  clienteComVeiculos inner join cliente on clienteComVeiculos.idCliente = cliente.idCliente inner join veiculo on clienteComVeiculos.idVeiculo = veiculo.idVeiculo where cliente.idCliente = ?");
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, termo);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt(1));
                veiculo.setPlaca(rs.getString(2));
                veiculo.setCor(rs.getString(3));
                veiculo.setModelo(rs.getString(4));
                veiculo.setMarca(rs.getString(5));
                veiculo.setAtivado(rs.getInt(6));
                veiculos.add(veiculo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar todos os veículos pelo do cliente pelo id:"+ex.getMessage());
        }
        return veiculos;
    }

    @Override
    public List<Veiculo> pesquisar(String termo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Veiculo> ListarTodosVeiculosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
