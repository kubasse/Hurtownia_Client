/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.BazaUsers;
import backend.Users;
import java.util.ArrayList;

/**
 *
 * @author kubap
 */
public class UsersFrame extends javax.swing.JFrame {

    /**
     * Creates new form UsersFrame
     */
    
    
    public UsersFrame(String nipPesel) {
        initComponents();
        zablokujTekst();
        bd = new BazaUsers();
        klient = bd.wyswietl(nipPesel);
        this.wyswietl(0);
    }
    
    private void zablokujTekst(){
        tNipPesel.setEnabled(false);
        tNazwa.setEnabled(false);
        tMiasto.setEnabled(false);
        tAdres.setEnabled(false);
        tKodPocztowy.setEnabled(false);
        bZapisz.setEnabled(false);
        bEdytuj.setEnabled(true);
    }
    
    private void odblokujTekst(){
        tNazwa.setEnabled(true);
        tMiasto.setEnabled(true);
        tAdres.setEnabled(true);
        tKodPocztowy.setEnabled(true);
        bZapisz.setEnabled(true);
        bEdytuj.setEnabled(false);
    }
    
    private void wyswietl(int i){
        Users u = klient.get(i);
        tNipPesel.setText(u.getNip_pesel());
        tNazwa.setText(u.getNazwa());
        tMiasto.setText(u.getMiasto());
        tAdres.setText(u.getAdres());
        tKodPocztowy.setText(u.getKod_pocztowy());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tKodPocztowy = new javax.swing.JTextField();
        tAdres = new javax.swing.JTextField();
        tMiasto = new javax.swing.JTextField();
        tNazwa = new javax.swing.JTextField();
        tNipPesel = new javax.swing.JTextField();
        bEdytuj = new javax.swing.JButton();
        tMZamowienia = new javax.swing.JButton();
        bNZamowienie = new javax.swing.JButton();
        bProdukty = new javax.swing.JButton();
        bZapisz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KOD POCZTOWY");

        jLabel2.setText("NIP/PESEL");

        jLabel3.setText("NAZWA");

        jLabel4.setText("MIASTO");

        jLabel5.setText("ADRES");

        bEdytuj.setText("EDYTUJ");
        bEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEdytujActionPerformed(evt);
            }
        });

        tMZamowienia.setText("MOJE ZAMÓWIENIA");
        tMZamowienia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tMZamowieniaActionPerformed(evt);
            }
        });

        bNZamowienie.setText("NOWE ZAMÓWIENIE");
        bNZamowienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNZamowienieActionPerformed(evt);
            }
        });

        bProdukty.setText("PRODUKTY");
        bProdukty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProduktyActionPerformed(evt);
            }
        });

        bZapisz.setText("ZAPISZ");
        bZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZapiszActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bProdukty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bNZamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tKodPocztowy)
                            .addComponent(tAdres)
                            .addComponent(tMiasto)
                            .addComponent(tNazwa)
                            .addComponent(tNipPesel, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tMZamowienia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(bEdytuj)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bZapisz))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNipPesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNazwa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tMiasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tKodPocztowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEdytuj)
                    .addComponent(bZapisz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tMZamowienia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNZamowienie)
                    .addComponent(bProdukty))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEdytujActionPerformed
        // TODO add your handling code here:
        this.odblokujTekst();
    }//GEN-LAST:event_bEdytujActionPerformed

    private void bZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZapiszActionPerformed
        // TODO add your handling code here:
        bd.edytuj(tNipPesel.getText(), tNazwa.getText(), tMiasto.getText(), tAdres.getText(), tKodPocztowy.getText());
        this.zablokujTekst();
    }//GEN-LAST:event_bZapiszActionPerformed

    private void bNZamowienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNZamowienieActionPerformed
        // TODO add your handling code here:
        nof = new NewOrderFrame(tNipPesel.getText());
        nof.setVisible(true);
    }//GEN-LAST:event_bNZamowienieActionPerformed

    private void tMZamowieniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tMZamowieniaActionPerformed
        // TODO add your handling code here:
        of = new OrdersFrame(tNipPesel.getText());
        of.setVisible(true);
    }//GEN-LAST:event_tMZamowieniaActionPerformed

    private void bProduktyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProduktyActionPerformed
        // TODO add your handling code here:
        pf = new ProductsFrame();
        pf.setVisible(true);
    }//GEN-LAST:event_bProduktyActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UsersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEdytuj;
    private javax.swing.JButton bNZamowienie;
    private javax.swing.JButton bProdukty;
    private javax.swing.JButton bZapisz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tAdres;
    private javax.swing.JTextField tKodPocztowy;
    private javax.swing.JButton tMZamowienia;
    private javax.swing.JTextField tMiasto;
    private javax.swing.JTextField tNazwa;
    private javax.swing.JTextField tNipPesel;
    // End of variables declaration//GEN-END:variables
private BazaUsers bd;
private ArrayList<Users> klient;
private LoginFrame lf;
private NewOrderFrame nof;
private OrdersFrame of;
private ProductsFrame pf;
}
