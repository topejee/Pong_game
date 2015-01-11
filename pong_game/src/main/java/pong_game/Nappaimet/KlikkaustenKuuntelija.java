/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import pong_game.Valikkot.Asetukset;
import pong_game.Valikkot.Paavalikko;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;

/**
 * Luokka tekee päävalikon näppäinten toiminnallisuuden
 *
 * @author Tommi
 */
public class KlikkaustenKuuntelija implements ActionListener {

    private Paavalikko valikko;
    private PelinTiedot pelinTiedot;

    /**
     *
     * @param valikko päävalikko
     * @param tiedot pelin tiedot
     */
    public KlikkaustenKuuntelija(Paavalikko valikko, PelinTiedot tiedot) {
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
        JButton j = (JButton) ae.getSource();
        String teksti = j.getText();

        if (teksti.equals("Pelaa")) {
            valikko.setVisible(false);
            Peli pelaa = new Peli(pelinTiedot);
            pelaa.aloita();
        }
        if (teksti.equals("Asetukset")) {
            valikko.setVisible(false);
            Asetukset asetus = new Asetukset(pelinTiedot);
        }

        if (teksti.equals("Lopeta")) {
            System.exit(0);

        }
    }
}
