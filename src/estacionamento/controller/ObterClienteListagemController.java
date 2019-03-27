package estacionamento.controller;

import estacionamento.dao.ClienteDao;
import estacionamento.model.Cliente;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.view.ObterClienteListagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ObterClienteListagemController {

    ObterClienteListagem obterClienteListagem;
    List<Cliente> clientes;
    DefaultTableModel modelo;
    Cliente cliente;
    JTextField jtfNome;
    JButton btnAdicionar;
    JPanel jpnlTipoDeCliente;
    JTable tblClientes;
    JRadioButton jrbServidor;

    public void lerClientePesquisado(String condutor) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ClienteDao clienteDao = new ClienteDao();
        clientes = clienteDao.pesquisar(condutor);
        List<Cliente> clientesTemp = new ArrayList<>();
        for (Cliente clienteAtual : clientes) {
            if (clienteAtual.getAtivado() == 1) {
                String temp;
                if (clienteAtual.isTipoCliente()) {
                    temp = "Servidor";
                } else {
                    temp = "Público";
                }
                Object[] linha = new Object[]{
                    clienteAtual.getIdCliente(),
                    clienteAtual.getCondutor(),
                    temp
                };
                modelo.addRow(linha);
                clientesTemp.add(clienteAtual);
            }
        }
        if (clientesTemp.isEmpty()) {
            if (jtfNome.getText().length() != 0) {
                btnAdicionar.setEnabled(true);
                jpnlTipoDeCliente.setVisible(true);
            }
        } else {
            btnAdicionar.setEnabled(false);
            jpnlTipoDeCliente.setVisible(false);
        }
        clientes = clientesTemp;
    }

    public void lerTodosClientes() {

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ClienteDao clienteDao = new ClienteDao();
        clientes = clienteDao.listar();
        List<Cliente> clientesTemp = new ArrayList<>();
        if (clientes.size() > 0) {
            for (int i = 0; clientes.size() > i; i++) {
                if (clientes.get(i).getAtivado() == 1) {
                    String temp = "";
                    if (clientes.get(i).isTipoCliente()) {
                        temp = "Servidor";
                    } else {
                        temp = "Público";
                    }
                    Object[] linha = new Object[]{
                        clientes.get(i).getIdCliente(),
                        clientes.get(i).getCondutor(),
                        temp
                    };
                    modelo.addRow(linha);
                    clientesTemp.add(clientes.get(i));
                }
            }
        }
        clientes = clientesTemp;
    }

    public void selecionar() {
        if (tblClientes.getSelectedRow() != -1) {
            Cliente clienteSelecionado;
            clienteSelecionado = clientes.get(tblClientes.getSelectedRow());
            cliente.setIdCliente(clienteSelecionado.getIdCliente());
            cliente.setCondutor(clienteSelecionado.getCondutor());
            cliente.setTipoCliente(clienteSelecionado.isTipoCliente());
            cliente.setValorPagoCliente(clienteSelecionado.getValorPagoCliente());
            cliente.setAtivado(clienteSelecionado.getAtivado());
            obterClienteListagem.dispose();
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_CLIENTE_SELECIONADO);
        }
    }

    public void adicionar() {
        ClienteDao clienteDao = new ClienteDao();
        Cliente clienteTemp = new Cliente();
        clienteTemp.setCondutor(jtfNome.getText());
        clienteTemp.setTipoCliente(jrbServidor.isSelected());
        clienteDao.cadastrar(clienteTemp);
        lerClientePesquisado(jtfNome.getText());
    }

    public ObterClienteListagemController(ObterClienteListagem obterClienteListagem, Cliente cliente, DefaultTableModel modelo, JTextField jtfNome, JButton btnAdicionar, JPanel jpnlTipoDeCliente, JTable tblClientes, JRadioButton jrbServidor) {
        this.obterClienteListagem = obterClienteListagem;
        this.cliente = cliente;
        this.modelo = modelo;
        this.jtfNome = jtfNome;
        this.btnAdicionar = btnAdicionar;
        this.jpnlTipoDeCliente = jpnlTipoDeCliente;
        this.tblClientes = tblClientes;
        this.jrbServidor = jrbServidor;
        jpnlTipoDeCliente.setVisible(false);
        lerTodosClientes();
    }

}
