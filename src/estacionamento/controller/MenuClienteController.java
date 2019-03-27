package estacionamento.controller;

import estacionamento.dao.ClienteRelacionamentoVeiculoDao;
import estacionamento.dao.VeiculoDao;
import estacionamento.model.Cliente;
import estacionamento.model.Veiculo;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.view.MenuCliente;
import estacionamento.view.ObterClienteListagem;
import estacionamento.view.ObterVeiculoListagem;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuClienteController {

    Frame parent;
    Cliente cliente;
    Veiculo veiculo;
    List<Veiculo> veiculos;
    DefaultTableModel modelo;
    JTable tblVeiculos;
    MenuCliente menuCliente;
    private JTextField jtfTipoCliente;
    private JTextField jtfCondutor;
    private Boolean rootPaneCheckingEnabled;
    private JButton btnAdicionarVeiculo;
    private JButton btnRemoverVeiculo;

    public void selecionarVeiculoCliente() {
        if (tblVeiculos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor escolha um veículo!");
        } else {
            veiculo = veiculos.get(tblVeiculos.getSelectedRow());
            cliente.getVeiculo().clear();
            cliente.addVeiculo(veiculo);
            menuCliente.dispose();
        }
    }

    public void removerVeiculo() {
        if (tblVeiculos.getSelectedRow() != -1) {
            ClienteRelacionamentoVeiculoDao clienteRelacionamentoVeiculoDao = new ClienteRelacionamentoVeiculoDao();
            clienteRelacionamentoVeiculoDao.removerRelacionamento(veiculos.get(tblVeiculos.getSelectedRow()).getIdVeiculo());
            lerDadosCliente();
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_VEICULO_SELECIONADO);
        }
    }

    private void lerDadosInicias() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ClienteRelacionamentoVeiculoDao clienteRelacionamentoVeiculoDao = new ClienteRelacionamentoVeiculoDao();
        if (cliente.getCondutor() != null) {
            jtfCondutor.setText(cliente.getCondutor());
            if (cliente.isTipoCliente()) {
                jtfTipoCliente.setText("Servidor");
            } else {
                jtfTipoCliente.setText("Público");
            }
            veiculos = new ArrayList<>();
            for (Cliente cliente : clienteRelacionamentoVeiculoDao.veiculosPorIdCliente(cliente.getIdCliente())) {
                for (Veiculo veiculo : cliente.getVeiculo()) {
                    Object[] linha = new Object[]{
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getCor(),
                        veiculo.getPlaca()
                    };
                    modelo.addRow(linha);
                    veiculos.add(veiculo);
                }
            }

        }
        if (cliente.getIdCliente() == 0) {
            btnAdicionarVeiculo.setEnabled(false);
            btnRemoverVeiculo.setEnabled(false);
        }
    }

    public void lerDadosCliente() {
        if (cliente.getCondutor() != null) {
            if (cliente.getIdCliente() != 0) {
                jtfCondutor.setText(cliente.getCondutor());
                if (cliente.isTipoCliente()) {
                    jtfTipoCliente.setText("Servidor");
                } else {
                    jtfTipoCliente.setText("Público");
                }
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }
                VeiculoDao veiculoDao = new VeiculoDao();
                veiculos = new ArrayList<>();
                for (Veiculo veiculo : veiculoDao.listarPorId(cliente.getIdCliente())) {
                    Object[] linha = new Object[]{
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getCor(),
                        veiculo.getPlaca()
                    };
                    veiculos.add(veiculo);
                    modelo.addRow(linha);
                }

            }
        }
    }

    public void trocarCliente() {
        ObterClienteListagem obterClienteListagem = new ObterClienteListagem(parent, rootPaneCheckingEnabled, cliente);
        obterClienteListagem.setVisible(true);
        lerDadosCliente();
        if (cliente.getIdCliente() != 0) {
            btnAdicionarVeiculo.setEnabled(true);
        }
        if (cliente.getVeiculo() != null) {
            if (cliente.getVeiculo().size() != 0) {
                btnRemoverVeiculo.setEnabled(true);
            }
        }
    }

    public void listarVeiculos() {
        ObterVeiculoListagem obterVeiculoListagem = new ObterVeiculoListagem(parent, rootPaneCheckingEnabled, cliente);
        obterVeiculoListagem.setVisible(true);
        lerDadosCliente();
    }

    public MenuClienteController(Frame parent, Cliente cliente, DefaultTableModel modelo, JTable tblVeiculos, MenuCliente menuCliente, JTextField jtfTipoCliente, JTextField jtfCondutor, Boolean rootPaneCheckingEnabled, JButton btnAdicionarVeiculo, JButton btnRemoverVeiculo) {
        this.parent = parent;
        this.cliente = cliente;
        this.modelo = modelo;
        this.tblVeiculos = tblVeiculos;
        this.menuCliente = menuCliente;
        this.jtfTipoCliente = jtfTipoCliente;
        this.jtfCondutor = jtfCondutor;
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
        this.btnAdicionarVeiculo = btnAdicionarVeiculo;
        this.btnRemoverVeiculo = btnRemoverVeiculo;
        lerDadosInicias();
        
    }
}
