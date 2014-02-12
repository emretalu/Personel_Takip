package personel_takip;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emre TALU
 */
public class Anasayfa extends javax.swing.JFrame {
    private Object[][] data;
    
    /**
     * Creates new form Anasayfa
     */
    public Anasayfa() {
        initComponents();
    }
    
    public Anasayfa(int PersonelId) {
        initComponents();
    }
    
    public void setTableModel(Object[][] data) {
        this.data = data;
        tblPersonel.setModel(new DefaultTableModel(data, new String[] {
            "Ad", "Soyad", "Yaş", "Cinsiyet", "E-Posta", "Telefon", "Departman"
        }));
    }
    
    public void AnaEnableButton(){
        btnDuzenle.setEnabled(true);
        btnEkle.setEnabled(true);
        btnSil.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonel = new javax.swing.JTable();
        btnEkle = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anasayfa");
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setIconImages(null);

        tblPersonel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblPersonel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ad", "Soyad", "Yaş", "Cinsiyet", "E-Posta", "Telefon", "Departman"
            }
        ));
        jScrollPane1.setViewportView(tblPersonel);

        btnEkle.setText("Ekle");
        btnEkle.setToolTipText("Yeni Personel Eklemek İçin Buraya Tıklayın...");
        btnEkle.setEnabled(false);
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        btnDuzenle.setText("Düzenle");
        btnDuzenle.setToolTipText("Personel Bilgisi Düzenlemek İçin Buraya Tıklayın...");
        btnDuzenle.setEnabled(false);
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });

        btnSil.setText("Sil");
        btnSil.setToolTipText("Personel Silmek İçin Buraya Tıklayın...");
        btnSil.setEnabled(false);
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        new Ekle(this).setVisible(true);
    }//GEN-LAST:event_btnEkleActionPerformed
    
    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed
        int select = tblPersonel.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen tablodan bir kişi seçiniz.");
        }
        else {
            Baglan bgln = new Baglan();
            int _id = bgln.SorguPersonelDuzenle((String) data[select][4]);
            try {
                new Ekle(this, _id).setVisible(true);
            }
            catch (SQLException ex) {
                Logger.getLogger(Anasayfa.class.getName()).log(Level.SEVERE, null, ex);
            }
            bgln.Kapat();
        }
    }//GEN-LAST:event_btnDuzenleActionPerformed
    
    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        int select = tblPersonel.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen tablodan bir kişi seçiniz.");
        }
        else {
            Baglan bgln = new Baglan();
            boolean sonuc = bgln.SorguPersonelSil((String) data[select][4]);
            bgln.Kapat();
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "İşlem Başarıyla Gerçekleştirildi.");
                try {
                    Personel_Takip.Calistir();
                }
                catch (SQLException ex) {
                    Logger.getLogger(Ekle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Hata Oluştu.");
            }
            
        }
    }//GEN-LAST:event_btnSilActionPerformed

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
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Anasayfa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonel;
    // End of variables declaration//GEN-END:variables
}
