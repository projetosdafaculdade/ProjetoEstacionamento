package estacionamento.view;

import estacionamento.dao.OrdemServicoDao;
import estacionamento.model.OrdemServico;
import estacionamento.uteis.Calcular;
import estacionamento.uteis.JOptionMessagem;
import estacionamento.uteis.Mensagem;
import java.awt.Frame;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static sun.util.calendar.CalendarUtils.mod;

public class FinalizarServicoAberto extends javax.swing.JDialog {

    long data;
    Frame parent;
    OrdemServico ordemServico;
    double valorServicoTemp;

    public FinalizarServicoAberto(java.awt.Frame parent, boolean modal, OrdemServico ordemServico) {
        super(parent, modal);
        this.parent = parent;
        this.ordemServico = ordemServico;
        initComponents();
        definirValoresPadrao();
        pnlTroco.setVisible(false);
        pnlFinalizar.setVisible(true);
    }

    private void definirValoresPadrao() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat horaFormat = new SimpleDateFormat("HH:mm");
        java.util.Date date = new java.util.Date();
        jtfData.setText(dateFormat.format(date));
        jtfHora.setText(horaFormat.format(date));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFinalizar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtfHora = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jtfData = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        pnlTroco = new javax.swing.JPanel();
        valorDoServico = new javax.swing.JLabel();
        lblValorServico = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jtfValorPago = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlFinalizar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Finalizar Serviço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51)))); // NOI18N
        pnlFinalizar.setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Hora Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N

        try {
            jtfHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfHora.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfHora, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Data Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N

        try {
            jtfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfData.setText("14/06/2000");
        jtfData.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfData, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor total:");

        javax.swing.GroupLayout pnlFinalizarLayout = new javax.swing.GroupLayout(pnlFinalizar);
        pnlFinalizar.setLayout(pnlFinalizarLayout);
        pnlFinalizarLayout.setHorizontalGroup(
            pnlFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinalizarLayout.createSequentialGroup()
                .addGroup(pnlFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFinalizarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFinalizarLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFinalizarLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jButton1))))
                    .addGroup(pnlFinalizarLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlFinalizarLayout.setVerticalGroup(
            pnlFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinalizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(pnlFinalizar);
        pnlFinalizar.setBounds(10, 10, 230, 150);

        valorDoServico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valorDoServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorDoServico.setText("O valor do serviço é:");

        lblValorServico.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblValorServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorServico.setText("R$ 50,00");

        btnFinalizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Valor Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N

        jtfValorPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jtfValorPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfValorPago.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfValorPago.setSelectionStart(0 - jtfValorPago.getText().length());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfValorPago, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtfValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlTrocoLayout = new javax.swing.GroupLayout(pnlTroco);
        pnlTroco.setLayout(pnlTrocoLayout);
        pnlTrocoLayout.setHorizontalGroup(
            pnlTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valorDoServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblValorServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addGroup(pnlTrocoLayout.createSequentialGroup()
                .addGroup(pnlTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrocoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTrocoLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTrocoLayout.setVerticalGroup(
            pnlTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrocoLayout.createSequentialGroup()
                .addComponent(valorDoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar))
        );

        getContentPane().add(pnlTroco);
        pnlTroco.setBounds(10, 10, 230, 150);

        setSize(new java.awt.Dimension(268, 211));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatarhora = new SimpleDateFormat("HH:mm");
        try {
            Date horas = formatarhora.parse(jtfHora.getText());
            Date datas = formatarData.parse(jtfData.getText());
            this.ordemServico.setDataTimeSaida((horas.getTime() - 10800000) + datas.getTime());
            if (ordemServico.getDataTimeSaida() >= ordemServico.getDataTimeEntrada()) {
                double valorPago = Double.parseDouble((jtfValorPago.getText().replaceAll("\\.", "")).replaceAll(",", "."));
                long longDoServico = ordemServico.getDataTimeSaida() - ordemServico.getDataTimeEntrada();
                int horasNoEstacionamento = (int) (longDoServico / Calcular.HorasEmMilisegundos(1));
                long minutosNoEstacionamentoLong = (mod(longDoServico, Calcular.HorasEmMilisegundos(1)));
                valorDoServico.setText(Mensagem.VALOR_SERVICO(horasNoEstacionamento));
                int minutosNoEstacionamento = Calcular.milisegundosEmMinutos(minutosNoEstacionamentoLong);
                if (minutosNoEstacionamento > ordemServico.getServico().getFracao()) {
                    horasNoEstacionamento = horasNoEstacionamento + 1;
                    valorDoServico.setText(Mensagem.VALOR_SERVICO_FRACAO(horasNoEstacionamento, ordemServico.getServico().getFracao()));
                }
                valorServicoTemp = (horasNoEstacionamento * ordemServico.getValorServico());   
                lblValor.setText(valorServicoTemp);
            }
        } catch (ParseException ex) {
            System.out.println("Erro ao formatar horário de finalização de serviço:" + ex.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
        ordemServico.setValorServico(valorServicoTemp);
        ordemServico.setAtivado(0);
        if (ordemServicoDao.alterar(ordemServico)) {
            JOptionMessagem.dialog("Retirada", Mensagem.RETIRADA_VEICULO(ordemServico.getCliente().getCondutor(), ordemServico.getCliente().getVeiculo().get(0).getModelo()));
            dispose();
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(FinalizarServicoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizarServicoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizarServicoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizarServicoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FinalizarServicoAberto dialog = new FinalizarServicoAberto(new javax.swing.JFrame(), true, new OrdemServico());
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
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JFormattedTextField jtfData;
    private javax.swing.JFormattedTextField jtfHora;
    private javax.swing.JFormattedTextField jtfValorPago;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorServico;
    private javax.swing.JPanel pnlFinalizar;
    private javax.swing.JPanel pnlTroco;
    private javax.swing.JLabel valorDoServico;
    // End of variables declaration//GEN-END:variables
}
