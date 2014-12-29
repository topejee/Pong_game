/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Grafiikka.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import pong_game.Grafiikka.Paavalikko2;
import pong_game.Oliot.Maila;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class KlikkaustenKuuntelijaAsetukset implements ActionListener {

    private JButton pallonNopeus;
    private JTextField pallonNopeusTeksti;
    private JButton mailanNopeus;
    private JTextField mailanNopeusTeksti;
    private JButton pistemaara;
    private JTextField pistemaaraTeksti;
    private JButton lopeta;
    private JFrame valikko;
    private JButton paavalikko;
    private Maila yksi;
    private Maila kaksi;
    private Pallo pallo;

    /**
     *
     * @param pallonNopeus Nappula joka tallentaa valitun pallon nopeuden
     * @param pallonNopeusTeksti teksti alue mihin voi laittaa haluaman pallon
     * nopeuden
     * @param mailanNopeus nappula joka tallentaa valitun mailan nopeuden
     * @param mailanNopeusTeksti teksti alue mihin voi laittaa haluaman pallon
     * nopeuden
     * @param pistemaara nappula joka tallentaa valitun pistemaaran
     * @param pistemaaraTeksti teksti alue mihin voi laittaa haluamansa tekstin
     * @param paavalikko nappula josta pääsee päävalikkoon
     * @param lopeta nappula joka lopettaa pelin
     * @param valikko nappula josta pääsee asetuksiin
     * @param yksi vasemman puoleinen maila
     * @param kaksi oikean puoleinen maila
     * @param pallo pelissä käytettävä pallo
     */
    public KlikkaustenKuuntelijaAsetukset(JButton pallonNopeus, JTextField pallonNopeusTeksti, JButton mailanNopeus, JTextField mailanNopeusTeksti, JButton pistemaara, JTextField pistemaaraTeksti, JButton paavalikko, JButton lopeta, JFrame valikko, Maila yksi, Maila kaksi, Pallo pallo) {
        this.paavalikko = paavalikko;
        this.pallonNopeus = pallonNopeus;
        this.pallonNopeusTeksti = pallonNopeusTeksti;
        this.mailanNopeus = pallonNopeus;
        this.mailanNopeusTeksti = pallonNopeusTeksti;
        this.pistemaara = pistemaara;
        this.pistemaaraTeksti = pistemaaraTeksti;
        this.lopeta = lopeta;
        this.valikko = valikko;
        this.yksi = yksi;
        this.kaksi = kaksi;
        this.pallo = pallo;
        this.paavalikko = paavalikko;
    }

    /**
     * Metodi saa aikaan Asetukset luokassa olevien nappuloiden ja teksti
     * alueiden toiminnallisuuden
     *
     * @param ae nappula, teksti alue mitä on käytetty
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
      //  JButton j = (JButton) ae.getSource();
        //   j.getText()

        if (ae.getSource() == paavalikko) {
            valikko.setVisible(false);
            new Paavalikko2(yksi, kaksi, pallo).setVisible(true);
        }
        if (ae.getSource() == pallonNopeus) {
            String x = pallonNopeusTeksti.getText();
            int maara = Integer.parseInt(x);
            pallo.setNopeus(maara);
            int maara2 = pallo.reNopeusX();
            pallonNopeusTeksti.setText(maara2 + "");
        }
        if (ae.getSource() == mailanNopeus) {
            String x = pallonNopeusTeksti.getText();
            int maara = Integer.parseInt(x);
            yksi.setNopeus(maara);
            kaksi.setNopeus(maara);
            int maara2 = pallo.reNopeusX();
            pallonNopeusTeksti.setText(maara2 + "");
        }
        if (ae.getSource() == pistemaara) {
            String x = pistemaaraTeksti.getText();
            int maara = Integer.parseInt(x);
            pallo.setPistemaara(maara);
            int maara2 = pallo.rePistemaara();
            pistemaaraTeksti.setText(maara2 + "");
        }

        if (ae.getSource() == lopeta) {
            System.exit(0);

        }
    }
}
