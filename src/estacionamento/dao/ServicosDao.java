package estacionamento.dao;

import estacionamento.interfaces.DaoI;
import estacionamento.model.Servicos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicosDao extends Dao implements DaoI<Servicos> {

    @Override
    public List<Servicos> listar() {
        PreparedStatement stmt;
        List<Servicos> servicos = new ArrayList<>();
        try {
            String sql = ("select * from servicos");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Servicos servico = new Servicos();
                servico.setIdServicos(rs.getInt(1));
                servico.setValorServidor(rs.getDouble(2));
                servico.setValorPublico(rs.getDouble(3));
                servico.setFracao(rs.getInt(4));
                servico.setAtivado(rs.getInt(5));
                servicos.add(servico);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler todos os serviços do BD" + ex.getMessage());
        }
        return servicos;
    }

    @Override
    public int cadastrar(Servicos obj) {
        PreparedStatement stmt;
        try {
            String sql = ("insert into servicos(valorServidor, valorPublico, fracao) values (?,?,?)");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs;
            stmt.setDouble(1, obj.getValorPublico());
            stmt.setDouble(2, obj.getValorServidor());
            stmt.setInt(3, obj.getFracao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar servico" + ex.getMessage());
        }
        return 0;
    }

    @Override
    public boolean alterar(Servicos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servicos lerPorId(int termo) {
        PreparedStatement stmt;
        Servicos Servico = new Servicos();
        try {
            String sql = ("select * from servicos where iDservicos = ?");
            stmt = conexao.prepareStatement(sql);
            ResultSet rs;
            stmt.setInt(1, termo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Servico.setIdServicos(rs.getInt(1));
                Servico.setValorServidor(rs.getDouble(2));
                Servico.setValorPublico(rs.getDouble(3));
                Servico.setFracao(rs.getInt(4));
                Servico.setAtivado(rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler um único serviço do BD" + ex.getSQLState());
        }
        return Servico;
    }

    @Override
    public List<Servicos> pesquisar(String termo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
