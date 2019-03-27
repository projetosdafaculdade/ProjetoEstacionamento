package estacionamento.controller;

import estacionamento.dao.ClienteRelacionamentoVeiculoDao;
import estacionamento.dao.EntradaRelacionamentoOrdemServicoDao;
import estacionamento.dao.OrdemServicoDao;
import estacionamento.model.Cliente;
import estacionamento.model.OrdemServico;
import estacionamento.model.Servicos;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.view.AdicionarServico;
import estacionamento.view.MenuCliente;
import estacionamento.view.ObterServicosListagem;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarServicoController {

    protected Boolean rootPaneCheckingEnabled;
    AdicionarServico frameAdicionarServico;
    Frame parent;
    Cliente cliente;
    Servicos servicos;
    JTextField jtfCorServico;
    JTextField jtfMarcaServico;
    JTextField jtfModeloServico;
    JTextField jtfPlacaServico;
    JTextField jtfCondutorServico;
    JTextField jtfFracao;
    JTextField jtfPlaca;
    JTextField jtfValor;
    JPanel pnlServico;
    JPanel pnlPlaca;

    public void adicionarServicoController() {
        if (cliente.getIdCliente() != 0) {
            if (servicos.getIdServicos() != 0) {
                if (cliente.getVeiculo().get(0) != null) {
                    EntradaRelacionamentoOrdemServicoDao entradaRelacionamentoOrdemServico = new EntradaRelacionamentoOrdemServicoDao();
                    OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
                    OrdemServico ordemServico = new OrdemServico();
                    ordemServico.setCliente(cliente);
                    ordemServico.setServico(servicos);
                    ordemServico.getCliente().addVeiculo(cliente.getVeiculo().get(0));
                    ordemServico.setDataTimeEntrada(System.currentTimeMillis());
                    ordemServico.setIdOrdemServico(ordemServicoDao.cadastrar(ordemServico));
                    entradaRelacionamentoOrdemServico.criarRelacionamento(ordemServico);
                    frameAdicionarServico.dispose();
                } else {
                    JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_VEICULO_SELECIONADO);
                }
            } else {
                JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_SERVICO_SELECIONADO);
            }
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_CLIENTE_SELECIONADO);
        }
    }

    public void alterarServicoController() {
        ObterServicosListagem obterServicosListagem = new ObterServicosListagem(parent, rootPaneCheckingEnabled, servicos);
        obterServicosListagem.setVisible(true);
        lerDados();
    }

    public void alterarClienteController() {
        MenuCliente menuCliente = new MenuCliente(parent, rootPaneCheckingEnabled, cliente);
        menuCliente.setVisible(true);
        lerDados();
    }

    public void buscarClientePorPlacaController() {
        String placa = jtfPlaca.getText();
        if (placa.trim().length() == 8) {
            pnlPlaca.setVisible(false);
            pnlServico.setVisible(true);
            ClienteRelacionamentoVeiculoDao clienteRelacionamentoVeiculoDao = new ClienteRelacionamentoVeiculoDao();
            cliente = clienteRelacionamentoVeiculoDao.buscarPorPlaca(placa);
            if (clienteRelacionamentoVeiculoDao.buscarPorPlaca(placa) != null) {
                lerDados();
            }
        }
    }

    public void lerDados() {
        if (!cliente.getVeiculo().isEmpty()) {
            jtfCorServico.setText(cliente.getVeiculo().get(0).getCor());
            jtfMarcaServico.setText(cliente.getVeiculo().get(0).getMarca());
            jtfModeloServico.setText(cliente.getVeiculo().get(0).getModelo());
            jtfPlacaServico.setText(cliente.getVeiculo().get(0).getPlaca());
            jtfCondutorServico.setText(cliente.getCondutor());
        }
        if (servicos != null) {
            if (servicos.getIdServicos() > 0) {
                if (cliente != null) {
                    if (cliente.isTipoCliente()) {
                        jtfValor.setText(String.valueOf(servicos.getValorServidor()));
                    } else {
                        jtfValor.setText(String.valueOf(servicos.getValorPublico()));
                    }
                    jtfFracao.setText(String.valueOf(servicos.getFracao()));
                } else {
                    JOptionMessagem.dialog("Aviso!", "Por favor selecione um cliente primeiro!");
                }

            }
        }
    }

    //<editor-fold desc="Getters e Setters">
    public Frame getParent() {
        return parent;
    }

    public void setParent(Frame parent) {
        this.parent = parent;
    }

    public Boolean getRootPaneCheckingEnabled() {
        return rootPaneCheckingEnabled;
    }

    public void setRootPaneCheckingEnabled(Boolean rootPaneCheckingEnabled) {
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public JTextField getJtfCorServico() {
        return jtfCorServico;
    }

    public void setJtfCorServico(JTextField jtfCorServico) {
        this.jtfCorServico = jtfCorServico;
    }

    public JTextField getJtfMarcaServico() {
        return jtfMarcaServico;
    }

    public void setJtfMarcaServico(JTextField jtfMarcaServico) {
        this.jtfMarcaServico = jtfMarcaServico;
    }

    public JTextField getJtfModeloServico() {
        return jtfModeloServico;
    }

    public void setJtfModeloServico(JTextField jtfModeloServico) {
        this.jtfModeloServico = jtfModeloServico;
    }

    public JTextField getJtfPlacaServico() {
        return jtfPlacaServico;
    }

    public void setJtfPlacaServico(JTextField jtfPlacaServico) {
        this.jtfPlacaServico = jtfPlacaServico;
    }

    public JTextField getJtfCondutorServico() {
        return jtfCondutorServico;
    }

    public void setJtfCondutorServico(JTextField jtfCondutorServico) {
        this.jtfCondutorServico = jtfCondutorServico;
    }

    public JTextField getJtfValor() {
        return jtfValor;
    }

    public void setJtfValor(JTextField jtfValor) {
        this.jtfValor = jtfValor;
    }

    public JTextField getJtfFracao() {
        return jtfFracao;
    }

    public void setJtfFracao(JTextField jtfFracao) {
        this.jtfFracao = jtfFracao;
    }

    public JTextField getJtfPlaca() {
        return jtfPlaca;
    }

    public void setJtfPlaca(JTextField jtfPlaca) {
        this.jtfPlaca = jtfPlaca;
    }

    public JPanel getPnlServico() {
        return pnlServico;
    }

    public void setPnlServico(JPanel pnlServico) {
        this.pnlServico = pnlServico;
    }

    public JPanel getPnlPlaca() {
        return pnlPlaca;
    }

    public void setPnlPlaca(JPanel pnlPlaca) {
        this.pnlPlaca = pnlPlaca;
    }

    public AdicionarServico getFrameAdicionarServico() {
        return frameAdicionarServico;
    }

    public void setFrameAdicionarServico(AdicionarServico frameAdicionarServico) {
        this.frameAdicionarServico = frameAdicionarServico;
    }

    // </editor-fold>
    public AdicionarServicoController(Boolean rootPaneCheckingEnabled, AdicionarServico frameAdicionarServico, Frame parent, JTextField jtfCorServico, JTextField jtfMarcaServico, JTextField jtfModeloServico, JTextField jtfPlacaServico, JTextField jtfCondutorServico, JTextField jtfFracao, JTextField jtfPlaca, JTextField jtfValor, JPanel pnlServico, JPanel pnlPlaca, Boolean modal) {
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
        this.frameAdicionarServico = frameAdicionarServico;
        this.parent = parent;
        this.jtfCorServico = jtfCorServico;
        this.jtfMarcaServico = jtfMarcaServico;
        this.jtfModeloServico = jtfModeloServico;
        this.jtfPlacaServico = jtfPlacaServico;
        this.jtfCondutorServico = jtfCondutorServico;
        this.jtfFracao = jtfFracao;
        this.jtfPlaca = jtfPlaca;
        this.jtfValor = jtfValor;
        this.pnlServico = pnlServico;
        this.pnlPlaca = pnlPlaca;
        this.servicos = new Servicos();
        if (modal == true) {
            pnlPlaca.setVisible(true);
            pnlServico.setVisible(false);
        } else {
            pnlPlaca.setVisible(true);
            pnlServico.setVisible(false);
        }
    }

}
