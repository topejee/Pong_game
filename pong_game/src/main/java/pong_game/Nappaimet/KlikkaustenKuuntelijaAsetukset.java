/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import pong_game.Valikkot.Paavalikko;
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Oliot.Pelaaja;
import pong_game.Oliot.Pallo;
import pong_game.Valikkot.NappaintenVaihtoValikko;

/**
 *
 * @author Tommi
 */
public class KlikkaustenKuuntelijaAsetukset implements ActionListener {

    private JFrame valikko;
    private Pelaaja yksi;
    private Pelaaja kaksi;
    private Pallo pallo;
    private PelinTiedot pelinTiedot;
    private JTextField pallonNopeusTeksti;
    private JTextField mailanNopeusTeksti;
    private JTextField pistemaaraTeksti;

    /**
     *
     * @param pallonNopeusTeksti teksti alue mihin voi laittaa haluaman pallon
     * nopeuden
     * @param mailanNopeusTeksti teksti alue mihin voi laittaa haluaman pallon
     * nopeuden
     * @param pistemaaraTeksti teksti alue mihin voi laittaa haluamansa tekstin
     * @param valikko nappula josta pääsee asetuksiin
     */
    public KlikkaustenKuuntelijaAsetukset(JTextField pallonNopeusTeksti, JTextField mailanNopeusTeksti, JTextField pistemaaraTeksti, JFrame valikko, PelinTiedot pelinTiedot) {
        this.pallonNopeusTeksti = pallonNopeusTeksti;
        this.mailanNopeusTeksti = mailanNopeusTeksti;
        this.pistemaaraTeksti = pistemaaraTeksti;
        this.valikko = valikko;
        this.pelinTiedot = pelinTiedot;
        this.yksi = pelinTiedot.getPelaajaKaksi();
        this.kaksi = pelinTiedot.getPelaajaYksi();
        this.pallo = pelinTiedot.getPallo();

    }

    /**
     * Metodi saa aikaan Asetukset luokassa olevien nappuloiden ja teksti
     * alueiden toiminnallisuuden
     *
     * @param ae nappula, teksti alue mitä on käytetty
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String teksti = "";
        JButton jj = null;
        JTextField j = null;
        if (ae.getSource() instanceof JButton) {
            jj = (JButton) ae.getSource();
            teksti = jj.getText();
        }
        if (ae.getSource() instanceof JTextField) {
            j = (JTextField) ae.getSource();
            teksti = j.getText();
        }
        if (teksti.equals("Palaa päävalikkoon")) {
            valikko.setVisible(false);
            new Paavalikko(pelinTiedot).setVisible(true);
        }
        if (teksti.equals("Pallon nopeus")) {
            String x = pallonNopeusTeksti.getText();
            int maara = Integer.parseInt(x);
            pallo.setNopeus(maara);
            int maara2 = pallo.getNopeusX();
        }
        if (teksti.equals("Mailan nopeus")) {
            String x = mailanNopeusTeksti.getText();
            int maara = Integer.parseInt(x);
            yksi.setNopeus(maara);
            kaksi.setNopeus(maara);
            int maara2 = pallo.getNopeusX();
        }
        if (teksti.equals("Pistemaara")) {
            String x = pistemaaraTeksti.getText();
            int maara = Integer.parseInt(x);
            pelinTiedot.setPistemaara(maara);
            int maara2 = pelinTiedot.getPelinPisteet();
        }

        if (teksti.equals("Lopeta")) {
            System.exit(0);

        }
        if (teksti.equals("Nappaimet")) {
            valikko.setVisible(false);
            NappaintenVaihtoValikko x = new NappaintenVaihtoValikko(pelinTiedot);
            x.setVisible(true);
        }
    }
}
