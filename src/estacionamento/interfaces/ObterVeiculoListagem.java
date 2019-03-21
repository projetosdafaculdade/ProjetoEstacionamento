package estacionamento.interfaces;

import estacionamento.dao.ClienteDao;
import estacionamento.dao.PesquisarClienteVeiculoDao;
import estacionamento.dao.VeiculoDao;
import estacionamento.model.Cliente;
import estacionamento.model.PesquisarClienteVeiculo;
import estacionamento.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ObterVeiculoListagem extends javax.swing.JDialog {

    public static Veiculo veiculo;
    List<PesquisarClienteVeiculo> pesquisarClienteVeiculos;
    List<Cliente> clientes;
    DefaultTableModel modelo;
    Cliente cliente;

    public ObterVeiculoListagem(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        modelo = (DefaultTableModel) tblVeiculos.getModel();
        lerTodosVeiculos();
    }

    private void lerTodosVeiculos() {

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientesSelecionados = clienteDao.ListarClientesComVeiculo();
        List<Cliente> clienteTemp = new ArrayList<>();
        for (int i = 0; clientesSelecionados.size() > i; i++) {
            if (clientesSelecionados.get(i).getAtivado() == 1) {
                for (Veiculo veiculo : clientesSelecionados.get(i).getVeiculo()) {
                    Object[] linha = new Object[]{
                        clientesSelecionados.get(i).getCondutor(),
                        veiculo.getPlaca(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getCor(),
                        veiculo.getAtivado()
                    };
                    modelo.addRow(linha);
                    clienteTemp.add(clientesSelecionados.get(i));
                }
            }
        }
        clientes = clienteTemp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jtfPlaca = new javax.swing.JFormattedTextField();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel5.setAutoscrolls(true);
        jPanel5.setLayout(null);

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dono", "Placa", "Marca", "Modelo", "Cor"
            }
        ));
        jScrollPane1.setViewportView(tblVeiculos);
        if (tblVeiculos.getColumnModel().getColumnCount() > 0) {
            tblVeiculos.getColumnModel().getColumn(0).setMinWidth(180);
        }

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(13, 86, 627, 330);

        jButton2.setText("Selecionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(253, 422, 143, 23);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Placa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel10.setAutoscrolls(true);

        try {
            jtfPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfPlaca.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jtfPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPlacaKeyPressed(evt);
            }
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
        jPanel10.setBounds(260, 25, 110, 40);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setToolTipText("");
        btnAdicionar.setAlignmentX(0.5F);
        btnAdicionar.setEnabled(false);
        btnAdicionar.setInheritsPopupMenu(true);
        jPanel5.add(btnAdicionar);
        btnAdicionar.setBounds(380, 30, 83, 36);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(689, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PesquisarClienteVeiculo veiculoSelecionado = pesquisarClienteVeiculos.get(tblVeiculos.getSelectedRow());
        veiculo = new Veiculo();
        veiculo.setAtivado(veiculoSelecionado.getAtivadoVeiculo());
        veiculo.setCor(veiculoSelecionado.getCor());
        veiculo.setIdVeiculo(veiculoSelecionado.getIdVeiculo());
        veiculo.setMarca(veiculoSelecionado.getMarca());
        veiculo.setModelo(veiculoSelecionado.getModelo());
        veiculo.setPlaca(veiculoSelecionado.getPlaca());
        VeiculoDao veiculoDao = new VeiculoDao();
        veiculoDao.cadastrar(veiculo);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPlacaKeyReleased
        lerVeiculoPesquisado();
    }//GEN-LAST:event_jtfPlacaKeyReleased

    private void jtfPlacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPlacaKeyPressed


    }//GEN-LAST:event_jtfPlacaKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jtfPlaca;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables

    private void lerVeiculoPesquisado() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ClienteDao clienteDao = new ClienteDao();
        if (jtfPlaca.getText().replaceAll(" ", "").length() <= 3) {
            pesquisarClienteVeiculos = clienteDao.listarTodosVeiculosComSemClientes((jtfPlaca.getText().replaceAll(" ", "")).replaceAll("-", "").trim());
        } else {
            pesquisarClienteVeiculos = pesquisarClienteVeiculoDao.listarPorPlaca((jtfPlaca.getText().replaceAll(" ", "")));
        }
        List<PesquisarClienteVeiculo> pesquisarClienteVeiculoTemp = new ArrayList<>();
        for (int i = 0; pesquisarClienteVeiculos.size() > i; i++) {
            if (pesquisarClienteVeiculos.get(i).getAtivadoVeiculo() == 1) {
                Object[] linha = new Object[]{
                    pesquisarClienteVeiculos.get(i).getCondutor(),
                    pesquisarClienteVeiculos.get(i).getPlaca(),
                    pesquisarClienteVeiculos.get(i).getMarca(),
                    pesquisarClienteVeiculos.get(i).getModelo(),
                    pesquisarClienteVeiculos.get(i).getCor(),
                    pesquisarClienteVeiculos.get(i).getAtivadoVeiculo()
                };
                modelo.addRow(linha);
                pesquisarClienteVeiculoTemp.add(pesquisarClienteVeiculos.get(i));
            }
        }
        if (pesquisarClienteVeiculoTemp.isEmpty()) {
            if (jtfPlaca.getText().replaceAll(" ", "").length() == 8) {
                btnAdicionar.setEnabled(true);
            } else {
                btnAdicionar.setEnabled(false);
            }
        } else {
            btnAdicionar.setEnabled(false);
        }
        pesquisarClienteVeiculos = pesquisarClienteVeiculoTemp;
    }

}
