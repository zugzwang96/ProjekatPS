/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.view.form;

import javax.swing.JDialog;
import root.domain.Zaposleni;

/**
 *
 * @author Bane
 */
public class FrmMain extends javax.swing.JFrame {

   

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        super("ProjekatPS");
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuKorisnik = new javax.swing.JMenu();
        jmiDodaj = new javax.swing.JMenuItem();
        jmiPretrazi = new javax.swing.JMenuItem();
        jMenuTrotinet = new javax.swing.JMenu();
        jMenuIznajmljivanje = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuKorisnik.setText("Korisnik");

        jmiDodaj.setText("Dodaj");
        jmiDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajActionPerformed(evt);
            }
        });
        jMenuKorisnik.add(jmiDodaj);

        jmiPretrazi.setText("Pretrazi");
        jmiPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretraziActionPerformed(evt);
            }
        });
        jMenuKorisnik.add(jmiPretrazi);

        jMenuBarMain.add(jMenuKorisnik);

        jMenuTrotinet.setText("Trotinet");
        jMenuBarMain.add(jMenuTrotinet);

        jMenuIznajmljivanje.setText("Iznajmljivanje");
        jMenuBarMain.add(jMenuIznajmljivanje);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDodajActionPerformed
      JDialog frmKorisnik = new FrmKorisnik(this, true);
      frmKorisnik.pack();
      frmKorisnik.setLocationRelativeTo(this);
      frmKorisnik.setVisible(true);
      
    }//GEN-LAST:event_jmiDodajActionPerformed

    private void jmiPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretraziActionPerformed
        JDialog frmKorisnikPretraga = new FrmKorisnikPretraga(this, true);
        frmKorisnikPretraga.pack();
        frmKorisnikPretraga.setLocationRelativeTo(this);
        frmKorisnikPretraga.setVisible(true);
    }//GEN-LAST:event_jmiPretraziActionPerformed
 
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuIznajmljivanje;
    private javax.swing.JMenu jMenuKorisnik;
    private javax.swing.JMenu jMenuTrotinet;
    private javax.swing.JMenuItem jmiDodaj;
    private javax.swing.JMenuItem jmiPretrazi;
    // End of variables declaration//GEN-END:variables


   
   
}
