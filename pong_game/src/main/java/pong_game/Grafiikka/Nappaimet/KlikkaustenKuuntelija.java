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
import pong_game.Grafiikka.Asetukset;
import pong_game.Grafiikka.Paavalikko2;
import pong_game.Kaynnistys.Peli;
import pong_game.Oliot.Maila;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class KlikkaustenKuuntelija implements ActionListener {

    private JButton pelaa;
    private JButton asetukset;
    private JButton lopeta;
    private Pallo pallo;
    private Maila yksi;
    private Maila kaksi;
    private Paavalikko2 valikko;

    /**
     *
     * @param plus pelaa nappula, jolla aloitetaan peli
     * @param miinus Asetukset nappula, jolla mennään asetuksiin
     * @param zed Lopettaa pelin
     * @param valikko päävalikko
     * @param yksi vasemman puolinen maila
     * @param kaksi oikean puolinen maila
     * @param pallo pelissä oleva pallo
     */
    public KlikkaustenKuuntelija(JButton plus, JButton miinus, JButton zed, Paavalikko2 valikko, Maila yksi, Maila kaksi, Pallo pallo) {
        this.pelaa = plus;
        this.asetukset = miinus;
        this.lopeta = zed;
        this.valikko = valikko;
        this.pallo = pallo;
        this.yksi = yksi;
        this.kaksi = kaksi;
    }

    /**
     * Metodi saa aikaan pelaa, asetuksekset ja lopeta nappuloiden
     * toiminnallisuuden. pelaa nappula aloittaa uuden pelin asetukset nappula
     * menee asetuksiin lopeta nappula lopettaa pelin
     *
     * @param ae kyseessä oleva tapahtuma, eli mitä nappulaa on painettu
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pelaa) {
            valikko.setVisible(false);
            Peli pelaa = new Peli(yksi, kaksi, pallo);
            pelaa.aloita();
        }
        if (ae.getSource() == asetukset) {
            valikko.setVisible(false);
            Asetukset asetus = new Asetukset(yksi, kaksi, pallo);
        }

        if (ae.getSource() == lopeta) {
            System.exit(0);

        }
    }
}
