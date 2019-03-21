package estacionamento.interfaces;

import estacionamento.dao.ClienteDao;
import estacionamento.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ObterClienteListagem extends javax.swing.JDialog {

    List<Cliente> clientes;
    DefaultTableModel modelo;
    Cliente cliente;

    public ObterClienteListagem(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        modelo = (DefaultTableModel) tblClientes.getModel();
        jpnlTipoDeCliente.setVisible(false);
        lerTodosClientes();
    }

    private void lerCLientePesquisado(String condutor) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ClienteDao clienteDao = new ClienteDao();
        clientes = clienteDao.pesquisar(condutor);
        List<Cliente> clientesTemp = new ArrayList<>();
        for (Cliente clienteAtual : clientes) {
            if (clienteAtual.getAtivado() == 1) {
                String temp;
                if (clienteAtual.isTipoCiente()) {
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
            btnAdicionar.setEnabled(true);
            jpnlTipoDeCliente.setVisible(true);
        } else {
            btnAdicionar.setEnabled(false);
            jpnlTipoDeCliente.setVisible(false);
        }
        clientes = clientesTemp;
    }

    private void lerTodosClientes() {

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ClienteDao clienteDao = new ClienteDao();
        clientes = clienteDao.Listar();
        List<Cliente> clientesTemp = new ArrayList<>();
        if (clientes.size() > 0) {
            for (int i = 0; clientes.size() > i; i++) {
                if (clientes.get(i).getAtivado() == 1) {
                    String temp = "";
                    if (clientes.get(i).isTipoCiente()) {
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
        } else {
           btnAdicionar.setEnabled(true);
           jpnlTipoDeCliente.setVisible(true);
        }
        clientes = clientesTemp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jtfNome = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jpnlTipoDeCliente = new javax.swing.JPanel();
        jrbPublico = new javax.swing.JRadioButton();
        jrbServidor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel5.setAutoscrolls(true);
        jPanel5.setLayout(null);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setMinWidth(25);
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

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel10.setAutoscrolls(true);
        jPanel10.setVerifyInputWhenFocusTarget(false);

        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel10);
        jPanel10.setBounds(30, 20, 280, 50);

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
        btnAdicionar.setBounds(330, 25, 83, 45);

        jpnlTipoDeCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102)), "Tipo de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jpnlTipoDeCliente.setAutoscrolls(true);

        buttonGroup1.add(jrbPublico);
        jrbPublico.setText("Público");

        buttonGroup1.add(jrbServidor);
        jrbServidor.setText("Servidor");

        javax.swing.GroupLayout jpnlTipoDeClienteLayout = new javax.swing.GroupLayout(jpnlTipoDeCliente);
        jpnlTipoDeCliente.setLayout(jpnlTipoDeClienteLayout);
        jpnlTipoDeClienteLayout.setHorizontalGroup(
            jpnlTipoDeClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTipoDeClienteLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jrbServidor)
                .addGap(18, 18, 18)
                .addComponent(jrbPublico)
                .addGap(21, 21, 21))
        );
        jpnlTipoDeClienteLayout.setVerticalGroup(
            jpnlTipoDeClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jrbServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(jrbPublico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.add(jpnlTipoDeCliente);
        jpnlTipoDeCliente.setBounds(430, 20, 190, 50);

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
        Cliente clienteSelecionado = new Cliente();
        clienteSelecionado = clientes.get(tblClientes.getSelectedRow());
        cliente.setIdCliente(clienteSelecionado.getIdCliente());
        cliente.setCondutor(clienteSelecionado.getCondutor());
        cliente.setTipoCliente(clienteSelecionado.isTipoCiente());
        cliente.setValorPagoCliente(clienteSelecionado.getValorPagoCliente());
        cliente.setAtivado(clienteSelecionado.getAtivado());
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyReleased
        lerCLientePesquisado(jtfNome.getText().trim());
    }//GEN-LAST:event_jtfNomeKeyReleased

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        ClienteDao clienteDao = new ClienteDao();
        Cliente clienteTemp = new Cliente();
        clienteTemp.setCondutor(jtfNome.getText());
        clienteTemp.setTipoCliente(jrbServidor.isSelected());
        clienteDao.cadastrar(clienteTemp);
        lerCLientePesquisado(jtfNome.getText());
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(ObterClienteListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObterClienteListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObterClienteListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObterClienteListagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ObterClienteListagem dialog = new ObterClienteListagem(new javax.swing.JFrame(), true, new Cliente());
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnlTipoDeCliente;
    private javax.swing.JRadioButton jrbPublico;
    private javax.swing.JRadioButton jrbServidor;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables

}
