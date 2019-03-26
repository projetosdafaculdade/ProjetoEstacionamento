package estacionamento.view;

import estacionamento.dao.ClienteDao;
import estacionamento.dao.ClienteRelacionamentoVeiculoDao;
import estacionamento.dao.VeiculoDao;
import estacionamento.model.Cliente;
import estacionamento.model.PesquisarClienteVeiculo;
import estacionamento.model.Veiculo;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import estacionamento.uteis.Validacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ObterVeiculoListagem extends javax.swing.JDialog {

    public Veiculo veiculo;
    List<PesquisarClienteVeiculo> pesquisarClienteVeiculos;
    List<Cliente> clientes;
    DefaultTableModel modelo;
    Cliente cliente;
    ClienteDao clienteDao;
    ClienteRelacionamentoVeiculoDao clienteRelacionamentoVeiculoDao;

    public ObterVeiculoListagem(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.veiculo = new Veiculo();
        this.cliente = cliente;
        this.clienteDao = new ClienteDao();
        this.clienteRelacionamentoVeiculoDao = new ClienteRelacionamentoVeiculoDao();
        this.modelo = (DefaultTableModel) tblVeiculos.getModel();
        jpnlCor.setVisible(false);
        jpnlMarca.setVisible(false);
        jpnlModelo.setVisible(false);
        lerTodosVeiculos();

    }

    private void lerTodosVeiculos() {

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jpnlMarca = new javax.swing.JPanel();
        jtfMarcaServico = new javax.swing.JTextField();
        jpnlModelo = new javax.swing.JPanel();
        jtfModeloServico = new javax.swing.JTextField();
        jpnlCor = new javax.swing.JPanel();
        jtfCorServico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jtfPlaca = new javax.swing.JFormattedTextField();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel5.setAutoscrolls(true);
        jPanel5.setLayout(null);

        jpnlMarca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Marca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jpnlMarca.setAutoscrolls(true);

        javax.swing.GroupLayout jpnlMarcaLayout = new javax.swing.GroupLayout(jpnlMarca);
        jpnlMarca.setLayout(jpnlMarcaLayout);
        jpnlMarcaLayout.setHorizontalGroup(
            jpnlMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfMarcaServico)
        );
        jpnlMarcaLayout.setVerticalGroup(
            jpnlMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlMarcaLayout.createSequentialGroup()
                .addComponent(jtfMarcaServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel5.add(jpnlMarca);
        jpnlMarca.setBounds(240, 30, 110, 41);

        jpnlModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Modelo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jpnlModelo.setAutoscrolls(true);

        javax.swing.GroupLayout jpnlModeloLayout = new javax.swing.GroupLayout(jpnlModelo);
        jpnlModelo.setLayout(jpnlModeloLayout);
        jpnlModeloLayout.setHorizontalGroup(
            jpnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfModeloServico, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        jpnlModeloLayout.setVerticalGroup(
            jpnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlModeloLayout.createSequentialGroup()
                .addComponent(jtfModeloServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel5.add(jpnlModelo);
        jpnlModelo.setBounds(360, 30, 118, 41);

        jpnlCor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Cor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jpnlCor.setAutoscrolls(true);

        javax.swing.GroupLayout jpnlCorLayout = new javax.swing.GroupLayout(jpnlCor);
        jpnlCor.setLayout(jpnlCorLayout);
        jpnlCorLayout.setHorizontalGroup(
            jpnlCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfCorServico, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        jpnlCorLayout.setVerticalGroup(
            jpnlCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlCorLayout.createSequentialGroup()
                .addComponent(jtfCorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel5.add(jpnlCor);
        jpnlCor.setBounds(490, 30, 118, 41);

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dono", "Placa", "Marca", "Modelo", "Cor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVeiculos);
        if (tblVeiculos.getColumnModel().getColumnCount() > 0) {
            tblVeiculos.getColumnModel().getColumn(0).setMinWidth(180);
        }

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(13, 86, 610, 330);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        jPanel5.add(btnSelecionar);
        btnSelecionar.setBounds(253, 422, 143, 23);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Placa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel10.setAutoscrolls(true);

        try {
            jtfPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfPlaca.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jtfPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPlacaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfPlaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.add(jPanel10);
        jPanel10.setBounds(20, 30, 110, 40);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setToolTipText("");
        btnAdicionar.setAlignmentX(0.5F);
        btnAdicionar.setEnabled(false);
        btnAdicionar.setInheritsPopupMenu(true);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdicionar);
        btnAdicionar.setBounds(140, 36, 83, 36);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(673, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (tblVeiculos.getSelectedRow() != -1) {
            Cliente clienteSelecionado = clientes.get(tblVeiculos.getSelectedRow());
            if (clienteRelacionamentoVeiculoDao.verificarExistência(clienteSelecionado.getVeiculo().get(0).getIdVeiculo())) {
                clienteRelacionamentoVeiculoDao.alterarRelacionamento(cliente.getIdCliente(), clienteSelecionado.getVeiculo().get(0).getIdVeiculo());
            } else {
                clienteRelacionamentoVeiculoDao.criarRelacionamento(cliente.getIdCliente(), clienteSelecionado.getVeiculo().get(0).getIdVeiculo());
            }
            dispose();
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_VEICULO_SELECIONADO);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void jtfPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPlacaKeyReleased
        lerVeiculoPesquisado();
    }//GEN-LAST:event_jtfPlacaKeyReleased

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (Validacao.campoVazio(jtfCorServico.getText()) == false && Validacao.campoVazio(jtfMarcaServico.getText()) == false && Validacao.campoVazio(jtfModeloServico.getText()) == false && Validacao.campoVazio(jtfPlaca.getText()) == false) {

            VeiculoDao veiculoDao = new VeiculoDao();
            veiculo.setCor(jtfCorServico.getText());
            veiculo.setMarca(jtfMarcaServico.getText());
            veiculo.setModelo(jtfModeloServico.getText());
            veiculo.setPlaca(jtfPlaca.getText());
            veiculoDao.cadastrar(veiculo);
            lerVeiculoPesquisado();
            
        }else{
             JOptionMessagem.dialog("Aviso", Mensagem.CAMPO_VAZIO);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ObterVeiculoListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObterVeiculoListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObterVeiculoListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObterVeiculoListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ObterVeiculoListagem dialog = new ObterVeiculoListagem(new javax.swing.JFrame(), true, new Cliente());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnlCor;
    private javax.swing.JPanel jpnlMarca;
    private javax.swing.JPanel jpnlModelo;
    private javax.swing.JTextField jtfCorServico;
    private javax.swing.JTextField jtfMarcaServico;
    private javax.swing.JTextField jtfModeloServico;
    private javax.swing.JFormattedTextField jtfPlaca;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables

    private void lerVeiculoPesquisado() {
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

}
