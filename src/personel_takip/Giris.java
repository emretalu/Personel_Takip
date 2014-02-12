package personel_takip;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emre TALU
 */
public class Giris extends javax.swing.JFrame {

    public Giris() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        girisPanel = new javax.swing.JPanel();
        txtEposta = new javax.swing.JTextField();
        lblEposta = new javax.swing.JLabel();
        lblParola = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGiris = new javax.swing.JButton();
        txtParola = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personel Takip Sistemi - Marmelat.Net");
        setBackground(new java.awt.Color(224, 227, 232));
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        girisPanel.setBackground(new java.awt.Color(224, 227, 232));
        girisPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        girisPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        girisPanel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        girisPanel.setPreferredSize(new java.awt.Dimension(460, 340));

        txtEposta.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtEposta.setToolTipText("E-Posta Adresinizi Giriniz...");
        txtEposta.setNextFocusableComponent(txtParola);

        lblEposta.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lblEposta.setText("E-Posta:");

        lblParola.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lblParola.setText("Parola:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner.png"))); // NOI18N
        jLabel1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/banner.png"))); // NOI18N

        btnGiris.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnGiris.setForeground(new java.awt.Color(255, 153, 0));
        btnGiris.setText("Giriş");
        btnGiris.setToolTipText("");
        btnGiris.setNextFocusableComponent(txtEposta);
        btnGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGirisActionPerformed(evt);
            }
        });

        txtParola.setToolTipText("Parolanızı Giriniz...");
        txtParola.setMinimumSize(new java.awt.Dimension(6, 32));
        txtParola.setNextFocusableComponent(btnGiris);
        txtParola.setPreferredSize(new java.awt.Dimension(6, 32));

        javax.swing.GroupLayout girisPanelLayout = new javax.swing.GroupLayout(girisPanel);
        girisPanel.setLayout(girisPanelLayout);
        girisPanelLayout.setHorizontalGroup(
            girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(girisPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(girisPanelLayout.createSequentialGroup()
                        .addGroup(girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblParola, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEposta, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtParola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(girisPanelLayout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addComponent(btnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(girisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        girisPanelLayout.setVerticalGroup(
            girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(girisPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEposta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEposta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(girisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblParola, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txtParola, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(girisPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGirisActionPerformed
        String EPosta = txtEposta.getText();
        String Parola = new String(txtParola.getPassword());
        try {
            Personel_Takip.GirisYap(EPosta, Parola);
        }
        catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGirisActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Giris().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiris;
    private javax.swing.JPanel girisPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEposta;
    private javax.swing.JLabel lblParola;
    private javax.swing.JTextField txtEposta;
    private javax.swing.JPasswordField txtParola;
    // End of variables declaration//GEN-END:variables
}
