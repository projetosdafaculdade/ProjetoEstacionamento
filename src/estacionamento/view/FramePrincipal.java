package estacionamento.view;


import estacionamento.controller.FramePrincipalController;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends javax.swing.JFrame {

    FramePrincipalController framePrincipalController;


    public FramePrincipal() {
        initComponents();
        framePrincipalController = new FramePrincipalController((DefaultTableModel) tblEstacionamento.getModel(), tblEstacionamento, this, jrdTodos, lblValor);
        framePrincipalController.lerDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstacionamento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jrdEstacionamento = new javax.swing.JRadioButton();
        jrdTodos = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tblEstacionamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ativo", "Cliente", "Marca", "Modelo", "Cor", "Placa", "Data entrada", "Hora entrada", "Valor Hora", "Fração"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEstacionamento);
        if (tblEstacionamento.getColumnModel().getColumnCount() > 0) {
            tblEstacionamento.getColumnModel().getColumn(0).setResizable(false);
            tblEstacionamento.getColumnModel().getColumn(1).setMinWidth(200);
            tblEstacionamento.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 820, 400);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(820, 0, 250, 390);

        btnAdicionar.setText("Adicionar entrada");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar);
        btnAdicionar.setBounds(40, 430, 177, 30);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar);
        btnFinalizar.setBounds(330, 430, 177, 30);

        jLabel1.setText("Valor Total por hora:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(640, 450, 120, 20);

        buttonGroup1.add(jrdEstacionamento);
        jrdEstacionamento.setSelected(true);
        jrdEstacionamento.setText("No Estacionamento");
        jrdEstacionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdEstacionamentoActionPerformed(evt);
            }
        });
        getContentPane().add(jrdEstacionamento);
        jrdEstacionamento.setBounds(710, 420, 120, 23);

        buttonGroup1.add(jrdTodos);
        jrdTodos.setText("Todos");
        jrdTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdTodosActionPerformed(evt);
            }
        });
        getContentPane().add(jrdTodos);
        jrdTodos.setBounds(650, 420, 55, 23);

        jLabel2.setText("Filtro:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(610, 420, 40, 20);

        lblValor.setText("R$ 0,00");
        getContentPane().add(lblValor);
        lblValor.setBounds(750, 450, 50, 20);

        setSize(new java.awt.Dimension(857, 515));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        framePrincipalController.finalizarServico();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        framePrincipalController.adicionarServico();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jrdTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdTodosActionPerformed
        framePrincipalController.lerDados();
    }//GEN-LAST:event_jrdTodosActionPerformed

    private void jrdEstacionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdEstacionamentoActionPerformed
        framePrincipalController.lerDados();
    }//GEN-LAST:event_jrdEstacionamentoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrdEstacionamento;
    private javax.swing.JRadioButton jrdTodos;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblEstacionamento;
    // End of variables declaration//GEN-END:variables
}
