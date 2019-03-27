package estacionamento.controller;

import estacionamento.dao.OrdemServicoDao;
import estacionamento.model.OrdemServico;
import estacionamento.uteis.Calcular;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.view.FinalizarServicoAberto;
import java.awt.Frame;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static sun.util.calendar.CalendarUtils.mod;

public class FinalizarServicoAbertoController {

    Frame parent;
    FinalizarServicoAberto finalizarServicoAberto;
    OrdemServico ordemServico;
    double valorServicoTemp;
    JTextField jtfHora;
    JTextField jtfData;
    JTextField jtfValorPago;
    JLabel lblInformacao;
    JLabel lblValorServico;
    JPanel pnlTroco;
    JPanel pnlFinalizar;

    public void continuarFinalização() {
            SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatarhora = new SimpleDateFormat("HH:mm");
        try {
            Date horas = formatarhora.parse(jtfHora.getText());
            Date datas = formatarData.parse(jtfData.getText());
            this.ordemServico.setDataTimeSaida((horas.getTime() - 10800000) + datas.getTime());
            if (ordemServico.getDataTimeEntrada() - ordemServico.getDataTimeSaida() <= 0) {
                long longDoServico = ordemServico.getDataTimeSaida() - ordemServico.getDataTimeEntrada();
                int horasNoEstacionamento = (int) (longDoServico / Calcular.HorasEmMilisegundos(1));
                long minutosNoEstacionamentoLong = (mod(longDoServico, Calcular.HorasEmMilisegundos(1)));
                lblInformacao.setText(Mensagem.VALOR_SERVICO(horasNoEstacionamento));
                int minutosNoEstacionamento = Calcular.milisegundosEmMinutos(minutosNoEstacionamentoLong);
                if (minutosNoEstacionamento > ordemServico.getServico().getFracao()) {
                    horasNoEstacionamento = horasNoEstacionamento + 1;
                    lblInformacao.setText(Mensagem.VALOR_SERVICO_FRACAO(horasNoEstacionamento, ordemServico.getServico().getFracao()));
                }
                valorServicoTemp = (horasNoEstacionamento * ordemServico.getValorServico());
                lblValorServico.setText("R$ " + String.valueOf(valorServicoTemp));
                pnlTroco.setVisible(true);
                pnlFinalizar.setVisible(false);
            }
        } catch (ParseException ex) {
            System.out.println("Erro ao formatar horário de finalização de serviço:" + ex.getMessage());
        }
    }

    public void definirValoresPadrao() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat horaFormat = new SimpleDateFormat("HH:mm");
        java.util.Date date = new java.util.Date();
        jtfData.setText(dateFormat.format(date));
        jtfHora.setText(horaFormat.format(date));
        pnlTroco.setVisible(false);
        pnlFinalizar.setVisible(true);
    }

    public void finalzarServico() {
        double valorPago = Double.parseDouble((jtfValorPago.getText().replaceAll("\\.", "")).replaceAll(",", "."));
        if (valorServicoTemp <= valorPago) {

            OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
            ordemServico.setValorServico(valorServicoTemp);
            ordemServico.setAtivado(0);
            if (ordemServicoDao.alterar(ordemServico)) {
                JOptionMessagem.dialog("Retirada", Mensagem.RETIRADA_VEICULO(ordemServico.getCliente().getCondutor(), ordemServico.getCliente().getVeiculo().get(0).getModelo(), (valorPago - ordemServico.getValorServico())));
                finalizarServicoAberto.dispose();
            }
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.VALOR_MENOR(valorServicoTemp, valorPago));
        }
    }

    public FinalizarServicoAbertoController(Frame parent,JTextField jtfValorPago, JTextField jtfHora, JTextField jtfData, JLabel lblInformacao, JPanel pnlTroco, JPanel pnlFinalizar, OrdemServico ordemServico, JLabel lblValorServico,FinalizarServicoAberto finalizarServicoAberto) {
        this.parent = parent;
        this.jtfHora = jtfHora;
        this.jtfData = jtfData;
        this.lblInformacao = lblInformacao;
        this.pnlTroco = pnlTroco;
        this.pnlFinalizar = pnlFinalizar;
        this.ordemServico = ordemServico;
        this.lblValorServico = lblValorServico;
        this.finalizarServicoAberto = finalizarServicoAberto;
        this.jtfValorPago = jtfValorPago;
    }

}
