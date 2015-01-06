/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Valikkot;

import pong_game.Nappaimet.KlikkaustenKuuntelija;
import pong_game.Nappaimet.NappaintenVaihto;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class NappaintenVaihtoValikko extends javax.swing.JFrame {

    private PelinTiedot pelinTiedot;

    /**
     * Creates new form NewJFrame
     *
     * @param pelinTiedot sisältää pelin tiedot.
     */
    public NappaintenVaihtoValikko(PelinTiedot pelinTiedot) {
        this.pelinTiedot = pelinTiedot;
        initComponents();
        nappaimet();
        oikeaPelaajaAlas.setText((char) pelinTiedot.getPelaajaKaksi().getAlaNappain() + "");
        oikeaPelaajaYlos.setText((char) pelinTiedot.getPelaajaKaksi().getYlaNappain() + "");
        vasenPelaajaAlas.setText((char) pelinTiedot.getPelaajaYksi().getAlaNappain() + "");
        vasenPelaajaYlos.setText((char) pelinTiedot.getPelaajaYksi().getYlaNappain() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oikeaPelaajaAlas = new javax.swing.JButton();
        oikeaPelaajaYlos = new javax.swing.JButton();
        vasenPelaajaYlos = new javax.swing.JButton();
        asetukset = new javax.swing.JButton();
        vasenPelaajaAlas = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        teksti = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        oikeaPelaajaAlas.setText("PelaajaYksiYlös");

        oikeaPelaajaYlos.setText("PelaajaKaksiYlös");

        vasenPelaajaYlos.setText("PelaajaYksiAlas");

        asetukset.setText("Takaisin");
        asetukset.setToolTipText("");
        asetukset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asetuksetActionPerformed(evt);
            }
        });

        vasenPelaajaAlas.setText("PelaajaKaksiAlas");
        vasenPelaajaAlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vasenPelaajaAlasActionPerformed(evt);
            }
        });

        label1.setText("Pelaaja 2");

        label2.setText("Pelaaja 1");

        label3.setText("Ylä näppäin");

        label4.setText("Ylä näppäin");

        label5.setText("Ala"
            + " näppäin");

        label6.setText("Ala"
            + " näppäin");

        teksti.setText("jTextField1");
        teksti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tekstiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vasenPelaajaYlos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(oikeaPelaajaYlos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vasenPelaajaAlas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oikeaPelaajaAlas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(teksti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(asetukset, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(oikeaPelaajaYlos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vasenPelaajaYlos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(teksti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(vasenPelaajaAlas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(oikeaPelaajaAlas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(asetukset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tekstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tekstiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tekstiActionPerformed

    private void vasenPelaajaAlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vasenPelaajaAlasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vasenPelaajaAlasActionPerformed

    private void asetuksetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asetuksetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asetuksetActionPerformed

    /**
     * @param args the command line arguments
     */
    public void nappaimet() {
        oikeaPelaajaAlas.setName("oikeaPelaajaAlas");
        oikeaPelaajaYlos.setName("oikeaPelaajaYlos");
        vasenPelaajaYlos.setName("vasenPelaajaYlos");
        vasenPelaajaAlas.setName("vasenPelaajaAlas");
        asetukset.setName("asetukset");
        NappaintenVaihto kopioija = new NappaintenVaihto(teksti, this, pelinTiedot);
        asetukset.addActionListener(kopioija);
        oikeaPelaajaAlas.addActionListener(kopioija);
        oikeaPelaajaYlos.addActionListener(kopioija);
        vasenPelaajaYlos.addActionListener(kopioija);
        vasenPelaajaAlas.addActionListener(kopioija);
        teksti.addActionListener(kopioija);
        //     NappaintenKuuntelija kuuntelija = new NappaintenKuuntelija(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asetukset;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JButton oikeaPelaajaAlas;
    private javax.swing.JButton oikeaPelaajaYlos;
    private javax.swing.JTextField teksti;
    private javax.swing.JButton vasenPelaajaAlas;
    private javax.swing.JButton vasenPelaajaYlos;
    // End of variables declaration//GEN-END:variables
}