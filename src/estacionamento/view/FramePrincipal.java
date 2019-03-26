package estacionamento.view;

import estacionamento.dao.EntradaRelacionamentoOrdemServicoDao;
import estacionamento.dao.OrdemServicoDao;
import estacionamento.model.OrdemServico;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends javax.swing.JFrame {

    List<OrdemServico> ordemServicos;
    DefaultTableModel modelo;

    public FramePrincipal() {
        initComponents();
        modelo = (DefaultTableModel) tblEstacionamento.getModel();
        lerDados();
    }

    private void lerDados() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        EntradaRelacionamentoOrdemServicoDao entradaRelacionamentoOrdemServicoDao = new EntradaRelacionamentoOrdemServicoDao();
        ordemServicos = entradaRelacionamentoOrdemServicoDao.buscarRelacionamentosAtivos();
        List<OrdemServico> ordemServicoTemp = new ArrayList<>();
        for (OrdemServico ordemServicoSelecionada : ordemServicos) {
            DateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat horaFormat = new SimpleDateFormat("HH:mm");
            double valorHora;
            if (ordemServicoSelecionada.getCliente().isTipoCliente()) {
                valorHora = ordemServicoSelecionada.getServico().getValorServidor();
            } else {
                valorHora = ordemServicoSelecionada.getServico().getValorPublico();
            }
            Object[] linha = new Object[]{
                ordemServicoSelecionada.getCliente().getCondutor(),
                ordemServicoSelecionada.getCliente().getVeiculo().get(0).getMarca(),
                ordemServicoSelecionada.getCliente().getVeiculo().get(0).getModelo(),
                ordemServicoSelecionada.getCliente().getVeiculo().get(0).getCor(),
                ordemServicoSelecionada.getCliente().getVeiculo().get(0).getPlaca(),
                dataFormat.format(ordemServicoSelecionada.getDataTimeEntrada()),
                horaFormat.format(ordemServicoSelecionada.getDataTimeEntrada()),
                valorHora
            };

            modelo.addRow(linha);
            ordemServicoTemp.add(ordemServicoSelecionada);
        }
        ordemServicos = ordemServicoTemp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstacionamento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
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

        btnAdicionar.setText("Adicionar entrada");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnAdicionar)
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
        if (tblEstacionamento.getSelectedRow() != -1) {
            OrdemServico ordemServico = ordemServicos.get(tblEstacionamento.getSelectedRow());
            FinalizarServicoAberto finalizarServico = new FinalizarServicoAberto(this, rootPaneCheckingEnabled, ordemServico);
            finalizarServico.setVisible(true);
            OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
            if (ordemServico.getDataTimeSaida() >= ordemServico.getDataTimeEntrada()) {
                ordemServico.setAtivado(0);
                if (ordemServicoDao.alterar(ordemServico)) {
                    JOptionMessagem.dialog("Retirada", Mensagem.RETIRADA_VEICULO(ordemServico.getCliente().getCondutor(), ordemServico.getCliente().getVeiculo().get(0).getModelo()));
                    lerDados();
                }
            }
        } else {
            JOptionMessagem.dialog("Aviso", Mensagem.NENHUM_SERVICO_SELECIONADO);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        AdicionarServico adicionarServico = new AdicionarServico(this, rootPaneCheckingEnabled);
        adicionarServico.setVisible(true);
        lerDados();
    }//GEN-LAST:event_btnAdicionarActionPerformed

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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstacionamento;
    // End of variables declaration//GEN-END:variables
}
