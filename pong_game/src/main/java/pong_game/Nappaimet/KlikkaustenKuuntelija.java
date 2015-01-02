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
import javax.swing.JLabel;
import pong_game.Valikkot.Asetukset;
import pong_game.Valikkot.Paavalikko2;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Oliot.Pelaaja;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class KlikkaustenKuuntelija implements ActionListener {

    private JButton pelaa;
    private JButton asetukset;
    private JButton lopeta;
    private Paavalikko2 valikko;
    private PelinTiedot pelinTiedot;

    /**
     *
     * @param plus pelaa nappula, jolla aloitetaan peli
     * @param miinus Asetukset nappula, jolla mennään asetuksiin
     * @param zed Lopettaa pelin
     * @param valikko päävalikko
     * @param tiedot sisältää pelin tiedot
     * @param yksi vasemman puolinen maila
     * @param kaksi oikean puolinen maila
     * @param pallo pelissä oleva pallo
     */
    public KlikkaustenKuuntelija(JButton plus, JButton miinus, JButton zed, Paavalikko2 valikko, PelinTiedot tiedot) {
        this.pelaa = plus;
        this.asetukset = miinus;
        this.lopeta = zed;
        this.valikko = valikko;
        this.pelinTiedot = tiedot;
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
            Peli pelaa = new Peli(pelinTiedot);
            pelaa.aloita();
        }
        if (ae.getSource() == asetukset) {
            valikko.setVisible(false);
            Asetukset asetus = new Asetukset(pelinTiedot);
        }

        if (ae.getSource() == lopeta) {
            System.exit(0);

        }
    }
}
