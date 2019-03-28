package estacionamento.controller;

import estacionamento.dao.ClienteDao;
import estacionamento.dao.ClienteRelacionamentoVeiculoDao;
import estacionamento.dao.VeiculoDao;
import estacionamento.model.Cliente;
import estacionamento.model.PesquisarClienteVeiculo;
import estacionamento.model.Veiculo;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.uteis.Validacao;
import estacionamento.view.ObterVeiculoListagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ObterVeiculoListagemController {

    public Veiculo veiculo;
    List<PesquisarClienteVeiculo> pesquisarClienteVeiculos;
    List<Cliente> clientes;
    DefaultTableModel modelo;
    Cliente cliente;
    ClienteDao clienteDao;
    ClienteRelacionamentoVeiculoDao clienteRelacionamentoVeiculoDao;
    ObterVeiculoListagem obterVeiculoListagem;
    JTextField jtfPlaca;
    JTextField jtfCorServico;
    JTextField jtfModeloServico;
    JTextField jtfMarcaServico;
    JTable tblVeiculos;
    JPanel jpnlCor;
    JPanel jpnlMarca;
    JPanel jpnlModelo;
    JButton btnAdicionar;

    public void lerTodosVeiculos() {

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        List<Cliente> clientesSelecionados = clienteRelacionamentoVeiculoDao.listarTodosVeiculosComESemClientes("");
        List<Cliente> clientesTemp = new ArrayList<>();
        for (Cliente clienteTemp : clientesSelecionados) {

            for (Veiculo veiculo : clienteTemp.getVeiculo()) {
                if (veiculo.getAtivado() == 1) {
                    String cliente;
                    if (clienteTemp.getCondutor() == null) {
                        cliente = "Veículo Sem Dono";
                    } else {
                        cliente = clienteTemp.getCondutor();
                    }
                    Object[] linha = new Object[]{
                        cliente,
                        veiculo.getPlaca(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getCor(),};
                    modelo.addRow(linha);
                    clientesTemp.add(clienteTemp);
                }

            }
        }
        clientes = clientesTemp;
    }

    public void lerVeiculoPesquisado() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (jtfPlaca.getText().replaceAll(" ", "").length() <= 3) {
            clientes = clienteRelacionamentoVeiculoDao.listarTodosVeiculosComESemClientes((jtfPlaca.getText().replaceAll(" ", "")).replaceAll("-", "").trim());
        } else {
            clientes = clienteRelacionamentoVeiculoDao.listarTodosVeiculosComESemClientes((jtfPlaca.getText().replaceAll(" ", "")));
        }
        List<Cliente> clientesTemp = new ArrayList<>();
        for (Cliente clienteTemp : clientes) {
            for (Veiculo veiculoTemp : clienteTemp.getVeiculo()) {
                if (veiculoTemp.getAtivado() == 1) {
                    String clienteString;
                    if (clienteTemp.getCondutor() == null) {
                        clienteString = "Veículo Sem Dono";
                    } else {
                        clienteString = clienteTemp.getCondutor();
                    }
                    Object[] linha = new Object[]{
                        clienteString,
                        veiculoTemp.getPlaca(),
                        veiculoTemp.getMarca(),
                        veiculoTemp.getModelo(),
                        veiculoTemp.getCor(),
                        veiculoTemp.getAtivado()
                    };
                    modelo.addRow(linha);
                    clientesTemp.add(clienteTemp);
                }
            }

        }
        if (clientesTemp.isEmpty()) {
            if (jtfPlaca.getText().replaceAll(" ", "").length() == 8) {
                btnAdicionar.setEnabled(true);
                jpnlCor.setVisible(true);
                jpnlMarca.setVisible(true);
                jpnlModelo.setVisible(true);
            } else {
                btnAdicionar.setEnabled(false);
                jpnlCor.setVisible(false);
                jpnlMarca.setVisible(false);
                jpnlModelo.setVisible(false);
            }
        } else {
            btnAdicionar.setEnabled(false);
            jpnlCor.setVisible(false);
            jpnlMarca.setVisible(false);
            jpnlModelo.setVisible(false);
        }
        clientes = clientesTemp;
    }

    public void selecionar() {
        if (tblVeiculos.getSelectedRow() != -1) {
            Cliente clienteSelecionado = clientes.get(tblVeiculos.getSelectedRow());
            if (clienteRelacionamentoVeiculoDao.verificarExistencia(clienteSelecionado.getVeiculo().get(0).getIdVeiculo())) {
                clienteRelacionamentoVeiculoDao.alterarRelacionamento(cliente.getIdCliente(), clienteSelecionado.getVeiculo().get(0).getIdVeiculo());
            } else {
                clienteRelacionamentoVeiculoDao.criarRelacionamento(cliente.getIdCliente(), clienteSelecionado.getVeiculo().get(0).getIdVeiculo());
            }
            obterVeiculoListagem.dispose();
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_VEICULO_SELECIONADO);
        }
    }

    public void Adicionar() {
        if (Validacao.campoVazio(jtfCorServico.getText()) == false && Validacao.campoVazio(jtfMarcaServico.getText()) == false && Validacao.campoVazio(jtfModeloServico.getText()) == false && Validacao.campoVazio(jtfPlaca.getText()) == false) {

            VeiculoDao veiculoDao = new VeiculoDao();
            veiculo = new Veiculo();
            veiculo.setCor(jtfCorServico.getText());
            veiculo.setMarca(jtfMarcaServico.getText());
            veiculo.setModelo(jtfModeloServico.getText());
            veiculo.setPlaca(jtfPlaca.getText());
            veiculoDao.cadastrar(veiculo);
            lerVeiculoPesquisado();
            jtfCorServico.setText("");
            jtfMarcaServico.setText("");
            jtfModeloServico.setText("");
            jtfPlaca.setText("");

        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.CAMPO_VAZIO);
        }
    }

    public ObterVeiculoListagemController(Cliente cliente, DefaultTableModel modelo, ObterVeiculoListagem obterVeiculoListagem, JTextField jtfPlaca, JTextField jtfCorServico, JTextField jtfModeloServico, JTextField jtfMarcaServico, JTable tblVeiculos, JPanel jpnlCor, JPanel jpnlMarca, JPanel jpnlModelo, JButton btnAdicionar) {
        this.cliente = cliente;
        this.modelo = modelo;
        this.obterVeiculoListagem = obterVeiculoListagem;
        this.jtfPlaca = jtfPlaca;
        this.jtfCorServico = jtfCorServico;
        this.jtfModeloServico = jtfModeloServico;
        this.jtfMarcaServico = jtfMarcaServico;
        this.tblVeiculos = tblVeiculos;
        this.jpnlCor = jpnlCor;
        this.jpnlMarca = jpnlMarca;
        this.jpnlModelo = jpnlModelo;
        this.btnAdicionar = btnAdicionar;
        this.clienteDao = new ClienteDao();
        this.clienteRelacionamentoVeiculoDao = new ClienteRelacionamentoVeiculoDao();
        lerTodosVeiculos();
    }

}
