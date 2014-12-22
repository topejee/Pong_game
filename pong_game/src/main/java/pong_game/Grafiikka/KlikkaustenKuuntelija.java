/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Tommi
 */
public class KlikkaustenKuuntelija implements ActionListener {

    private JButton pelaa;
    private JButton asetukset;
    private JButton lopeta;

    public KlikkaustenKuuntelija(JButton plus, JButton miinus, JButton zed) {
        this.pelaa = plus;
        this.asetukset = miinus;
        this.lopeta = zed;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pelaa) {

        }
        if (ae.getSource() == asetukset) {

        }

        if (ae.getSource() == lopeta) {
            System.exit(0);

        }
    }
}
