package estacionamento.controller;

import estacionamento.dao.ServicosDao;
import estacionamento.model.Servicos;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.uteis.Validacao;
import estacionamento.view.ObterServicosListagem;
import java.awt.Frame;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ObterServicosListagemController {

    DefaultTableModel modelo;
    List<Servicos> servicosList;
    Frame parent;
    Servicos servicos;
    JTextField jtfFracao;
    JTextField jtfValorPublico;
    JTextField jtfValorServidor;
    Boolean rootPaneCheckingEnabled;
    ObterServicosListagem ObterServicosListagem;
    JTable tblServicos;

    public void lerTodosServicos() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ServicosDao servicosDao = new ServicosDao();
        servicosList = servicosDao.listar();
        List<Servicos> servicosTemp = new ArrayList<>();
        if (servicosList.size() > 0) {
            for (Servicos servicoTemp : servicosList) {
                if (servicoTemp.getAtivado() == 1) {
                    Object[] linha = new Object[]{
                        servicoTemp.getValorServidor(),
                        servicoTemp.getValorPublico(),
                        servicoTemp.getFracao()
                    };
                    modelo.addRow(linha);
                    servicosTemp.add(servicoTemp);
                }
            }
        }
        servicosList = servicosTemp;
    }

    public void selecionar() {
        if(servicos == null){
            servicos = new Servicos();
        }
        Servicos servicosTemp = servicosList.get(tblServicos.getSelectedRow());
        servicos.setAtivado(servicosTemp.getAtivado());
        servicos.setFracao(servicosTemp.getFracao());
        servicos.setIdServicos(servicosTemp.getIdServicos());
        servicos.setValorPublico(servicosTemp.getValorPublico());
        servicos.setValorServidor(servicosTemp.getValorServidor());
        ObterServicosListagem.dispose();
        
    }

    public void adicionar() {
        if (!Validacao.campoNumericoVazio(jtfFracao.getText())) {
            ServicosDao servicoDao = new ServicosDao();
            Servicos servicosTemp = new Servicos();
            servicosTemp.setValorPublico(Double.parseDouble((jtfValorPublico.getText().replaceAll("\\.", "")).replaceAll(",", ".")));
            servicosTemp.setValorServidor(Double.parseDouble((jtfValorServidor.getText().replaceAll("\\.", "")).replaceAll(",", ".")));
            servicosTemp.setFracao(Integer.parseInt(jtfFracao.getText()));
            servicoDao.cadastrar(servicosTemp);
            lerTodosServicos();
        } else {
            JOptionMessagem.dialog("Aviso!", Mensagem.VALOR_INVALIDO);
        }
    }

    public ObterServicosListagemController(DefaultTableModel modelo, Frame parent, Servicos servicos, JTextField jtfFracao, JTextField jtfValorPublico, JTextField jtfValorServidor, Boolean rootPaneCheckingEnabled, ObterServicosListagem obterServicosListagem, JTable tblServicos) {
        this.modelo = modelo;
        this.parent = parent;
        this.servicos = servicos;
        this.jtfFracao = jtfFracao;
        this.jtfValorPublico = jtfValorPublico;
        this.jtfValorServidor = jtfValorServidor;
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
        this.ObterServicosListagem = obterServicosListagem;
        this.tblServicos = tblServicos;
        lerTodosServicos();
    }

}
