package estacionamento.controller;

import estacionamento.dao.EntradaRelacionamentoOrdemServicoDao;
import estacionamento.model.OrdemServico;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.view.AdicionarServico;
import estacionamento.view.FinalizarServicoAberto;
import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FramePrincipalController {

    List<OrdemServico> ordemServicos;
    DefaultTableModel modelo;
    JTable tblEstacionamento;
    Frame framePrincipal;
    JRadioButton jrdTodos;
    Double valorTotal;
    JLabel lblValor;

    public void lerDados() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        EntradaRelacionamentoOrdemServicoDao entradaRelacionamentoOrdemServicoDao = new EntradaRelacionamentoOrdemServicoDao();
        ordemServicos = entradaRelacionamentoOrdemServicoDao.buscarRelacionamentos();
        List<OrdemServico> ordemServicoTemp = new ArrayList<>();
        for (OrdemServico ordemServicoSelecionada : ordemServicos) {
            int continuar = 0;
            if (jrdTodos.isSelected()) {
                continuar = 1;
            } else {
                if (ordemServicoSelecionada.getAtivado() == 1) {
                    continuar = 1;
                }
            }
            if (continuar == 1) {
                DateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat horaFormat = new SimpleDateFormat("HH:mm");
                if (ordemServicoSelecionada.getCliente().isTipoCliente()) {
                    ordemServicoSelecionada.setValorServico(ordemServicoSelecionada.getServico().getValorServidor());
                } else {
                    ordemServicoSelecionada.setValorServico(ordemServicoSelecionada.getServico().getValorPublico());
                }
                String ativado;
                if (ordemServicoSelecionada.getAtivado() == 1) {
                    ativado = "Ativo";
                } else {
                    ativado = "Fechado";
                }
                Object[] linha = new Object[]{
                    ativado,
                    ordemServicoSelecionada.getCliente().getCondutor(),
                    ordemServicoSelecionada.getCliente().getVeiculo().get(0).getMarca(),
                    ordemServicoSelecionada.getCliente().getVeiculo().get(0).getModelo(),
                    ordemServicoSelecionada.getCliente().getVeiculo().get(0).getCor(),
                    ordemServicoSelecionada.getCliente().getVeiculo().get(0).getPlaca(),
                    dataFormat.format(ordemServicoSelecionada.getDataTimeEntrada()),
                    horaFormat.format(ordemServicoSelecionada.getDataTimeEntrada()),
                    ordemServicoSelecionada.getValorServico(),
                    ordemServicoSelecionada.getServico().getFracao()
                };
                if (ordemServicoSelecionada.getAtivado() == 0) {
                    valorTotal = valorTotal + ordemServicoSelecionada.getValorServico();
                }

                modelo.addRow(linha);
                ordemServicoTemp.add(ordemServicoSelecionada);

            }
        }
        ordemServicos = ordemServicoTemp;
        lblValor.setText("RS " + valorTotal);
        valorTotal = 0.0;
    }

    public FramePrincipalController(DefaultTableModel modelo, JTable tblEstacionamento, Frame framePrincipal, JRadioButton jrd, JLabel lblValor) {
        this.modelo = modelo;
        this.tblEstacionamento = tblEstacionamento;
        this.framePrincipal = framePrincipal;
        this.jrdTodos = jrd;
        this.lblValor = lblValor;
        valorTotal = 0.0;

    }

    public void adicionarServico() {
        AdicionarServico adicionarServico = new AdicionarServico(framePrincipal, true);
        adicionarServico.setVisible(true);
        lerDados();
    }

    public void finalizarServico() {
        if (tblEstacionamento.getSelectedRow() != -1) {
            OrdemServico ordemServico = ordemServicos.get(tblEstacionamento.getSelectedRow());
            FinalizarServicoAberto finalizarServico = new FinalizarServicoAberto(framePrincipal, true, ordemServico);
            finalizarServico.setVisible(true);
            lerDados();
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUMA_ENTRADA_NA_OFICINA_SELECIONADA);
        }
    }

}
