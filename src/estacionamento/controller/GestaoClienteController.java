package estacionamento.controller;

import estacionamento.dao.ClienteRelacionamentoVeiculoDao;
import estacionamento.dao.VeiculoDao;
import estacionamento.model.Cliente;
import estacionamento.model.Veiculo;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.view.MenuCliente;
import estacionamento.view.ObterVeiculoListagem;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GestaoClienteController {

    private JTable tblVeiculos;
    private MenuCliente menuCliente;
    private Frame parent;
    private Cliente cliente;
    private Veiculo veiculo;
    private Boolean rootPaneCheckingEnabled;
    private List<Veiculo> veiculos;
    private JTextField jtfTipoCliente;
    private JTextField jtfCondutor;
    private DefaultTableModel modelo;
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

    public void listarVeiculos() {
        ObterVeiculoListagem obterVeiculoListagem = new ObterVeiculoListagem(parent, rootPaneCheckingEnabled, cliente);
        obterVeiculoListagem.setVisible(true);
        lerDadosCliente();
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
            veiculos.clear();
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

    public GestaoClienteController(Frame parent, Boolean rootPaneCheckingEnabled, DefaultTableModel modelo) {
        this.parent = parent;
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
        this.modelo = modelo;
    }



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public JTable getTblVeiculos() {
        return tblVeiculos;
    }

    public void setTblVeiculos(JTable tblVeiculos) {
        this.tblVeiculos = tblVeiculos;
    }

}
