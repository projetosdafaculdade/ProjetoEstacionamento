package estacionamento.interfaces;

import estacionamento.dao.OrdemServicoDao;
import estacionamento.model.OrdemServico;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends javax.swing.JFrame {

    OrdemServicoDao ordemServicoDao;
    List<OrdemServico> ordemServicos;
    DefaultTableModel modelo;

    public FramePrincipal() {
        initComponents();
        modelo = (DefaultTableModel) tblEstacionamento.getModel();
        ordemServicoDao = new OrdemServicoDao();
        lerDados();
    }

    private void lerDados() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        ordemServicos = ordemServicoDao.listar();

        List<OrdemServico> ordemServicosTemp = new ArrayList<>();
        for (OrdemServico ordemservico : ordemServicos) {
            if (ordemservico.getAtivado() == 1) {
                Object[] linha = new Object[]{
                    ordemservico.getCliente().getCondutor(),
                    ordemservico.getVeiculo().getMarca(),
                    ordemservico.getVeiculo().getModelo(),
                    ordemservico.getVeiculo().getCor(),
                    ordemservico.getVeiculo().getPlaca(),
                    ordemservico.getDataEntrada(),
                    ordemservico.getHoraEntrada(),
                    ordemservico.getServico().getValorPublico()
                };
                modelo.addRow(linha);
                ordemServicosTemp.add(ordemservico);
            }
        }
        ordemServicos = ordemServicosTemp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstacionamento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tblEstacionamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Marca", "Modelo", "Cor", "Placa", "Data entrada", "Hora entrada", "Valor Hora"
            }
        ));
        jScrollPane1.setViewportView(tblEstacionamento);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 820, 400);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar entrada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizar)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(830, 10, 250, 390);

        jMenu1.setText("Excluir");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1071, 463));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        FinalizarServico finalizarServico = new FinalizarServico(this, rootPaneCheckingEnabled);
        finalizarServico.setVisible(true);
        OrdemServico ordemServico = ordemServicos.get(tblEstacionamento.getSelectedRow());

        if (finalizarServico.data > ordemServico.getDataEntrada().getTime()) {
            System.out.println("Entrou");
            Time horas = new Time(finalizarServico.hora);
            Date datas = new Date(finalizarServico.data);
            OrdemServico editar = ordemServico;
            editar.setHoraSaida(horas);
            editar.setDataSaida(datas);
            editar.setAtivado(0);
            Boolean valor = ordemServicoDao.alterar(editar);
            System.out.println("ALTEROU?> " + valor);
            lerDados();
        } else if (finalizarServico.data == ordemServico.getDataEntrada().getTime()) {
            if (finalizarServico.hora > ordemServico.getHoraEntrada().getTime()) {
                System.out.println("Entrou");
                Time horas = new Time(finalizarServico.hora);
                Date datas = new Date(finalizarServico.data);
                OrdemServico editar = ordemServico;
                editar.setHoraSaida(horas);
                editar.setDataSaida(datas);
                editar.setAtivado(0);
                Boolean valor = ordemServicoDao.alterar(editar);
                System.out.println("ALTEROU?> " + valor);
                lerDados();
            } else {
                JOptionPane.showMessageDialog(null, "Hora menor que a atual!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data de saída é menor que a data de entrada do veículo!");
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AdicionarServico adicionarServico = new AdicionarServico(this, rootPaneCheckingEnabled);
        adicionarServico.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstacionamento;
    // End of variables declaration//GEN-END:variables
}
