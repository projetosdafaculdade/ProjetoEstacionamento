package estacionamento.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntradaRelacionamentoOrdemServico extends Dao {

    public void criarRelacionamento(int idCliente, int idServicos, int idVeiculo,int idOrdemServico) {

        PreparedStatement stmt;

        try {
            String sql = "insert into OrdemServicoComClienteServico(idCliente,idServicos,idVeiculo,idOrdemServico) values (?,?,?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idServicos);
            stmt.setInt(3, idVeiculo);
            stmt.setInt(4, idOrdemServico);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntradaRelacionamentoOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluirRelacionamento() {

    }
}
