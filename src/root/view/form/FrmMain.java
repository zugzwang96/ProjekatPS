/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.view.form;

import java.util.Date;
import javax.swing.JDialog;
import root.domain.Zaposleni;

/**
 *
 * @author Bane
 */
public class FrmMain extends javax.swing.JFrame {

    private Zaposleni ulogovani;
    
    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }
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

        lblUlogovani = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuKorisnik = new javax.swing.JMenu();
        jmiRadSaKorisnicima = new javax.swing.JMenuItem();
        jMenuTrotinet = new javax.swing.JMenu();
        jmiTrotinet = new javax.swing.JMenuItem();
        jMenuIznajmljivanje = new javax.swing.JMenu();
        jmiIznajmi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setForeground(new java.awt.Color(0, 153, 0));

        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Ulogovan:");

        jMenuKorisnik.setText("Korisnik");

        jmiRadSaKorisnicima.setText("Rad sa korisnicima");
        jmiRadSaKorisnicima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRadSaKorisnicimaActionPerformed(evt);
            }
        });
        jMenuKorisnik.add(jmiRadSaKorisnicima);

        jMenuBarMain.add(jMenuKorisnik);

        jMenuTrotinet.setText("Trotinet");

        jmiTrotinet.setText("Rad sa trotinetima");
        jmiTrotinet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTrotinetActionPerformed(evt);
            }
        });
        jMenuTrotinet.add(jmiTrotinet);

        jMenuBarMain.add(jMenuTrotinet);

        jMenuIznajmljivanje.setText("Iznajmljivanje");

        jmiIznajmi.setText("Rad sa iznajmljivanjima");
        jmiIznajmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIznajmiActionPerformed(evt);
            }
        });
        jMenuIznajmljivanje.add(jmiIznajmi);

        jMenuBarMain.add(jMenuIznajmljivanje);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(241, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiRadSaKorisnicimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRadSaKorisnicimaActionPerformed
        FrmKorisnikPretraga frmKorisnikPretraga = new FrmKorisnikPretraga();
        frmKorisnikPretraga.pack();
        frmKorisnikPretraga.setLocationRelativeTo(this);
        frmKorisnikPretraga.setZaposleni(ulogovani);
        frmKorisnikPretraga.setVisible(true);
    }//GEN-LAST:event_jmiRadSaKorisnicimaActionPerformed

    private void jmiIznajmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIznajmiActionPerformed
      FrmIznajmljivanja frmIznajmljivanja = new FrmIznajmljivanja();
      frmIznajmljivanja.pack();
      frmIznajmljivanja.setLocationRelativeTo(this);
      frmIznajmljivanja.setVisible(true);
    }//GEN-LAST:event_jmiIznajmiActionPerformed

    private void jmiTrotinetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTrotinetActionPerformed
        FrmTrotinetiPretraga frmt = new FrmTrotinetiPretraga();
        frmt.pack();
        frmt.setLocationRelativeTo(this);
        frmt.setUlogovaniZ(ulogovani);
        frmt.setVisible(true);
    }//GEN-LAST:event_jmiTrotinetActionPerformed


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuIznajmljivanje;
    private javax.swing.JMenu jMenuKorisnik;
    private javax.swing.JMenu jMenuTrotinet;
    private javax.swing.JMenuItem jmiIznajmi;
    private javax.swing.JMenuItem jmiRadSaKorisnicima;
    private javax.swing.JMenuItem jmiTrotinet;
    private javax.swing.JLabel lblUlogovani;
    // End of variables declaration//GEN-END:variables

    public void srediLabelu() {
        lblUlogovani.setText(ulogovani.getIme()+" "+ulogovani.getPrezime());
    }

   
}
