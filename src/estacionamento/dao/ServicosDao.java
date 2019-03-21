package estacionamento.dao;

import estacionamento.interfaces.DaoI;
import estacionamento.model.Servicos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicosDao extends Dao implements DaoI<Servicos> {

    @Override
    public List<Servicos> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cadastrar(Servicos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                Servico.setValorHora(rs.getDouble(2));
                Servico.setFracao(rs.getInt(3));
                Servico.setAtivado(rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler um único serviço do BD"+ex.getSQLState());
        }
        return Servico;
    }

    @Override
    public List<Servicos> pesquisar(String termo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
