/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_M;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_R;
import java.awt.event.KeyListener;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Oliot.Pelaaja;
import pong_game.Oliot.Pallo;
import pong_game.Valikkot.Paavalikko;

/**
 * Luokassa tapahtuu pelin näppäinten toiminnallisuus
 *
 * @author Tommi
 */
public class PeliNappaimet implements KeyListener {

    private Pelaaja kaksi;
    private Pelaaja yksi;
    private Pallo pallo;
    private PelinTiedot pelinTiedot;
    private Peli peli;

    /**
     *
     * @param pelinTiedot pelattavan pelin tiedot
     * @param peli pelattava peli
     */
    public PeliNappaimet(PelinTiedot pelinTiedot, Peli peli) {
        this.pelinTiedot = pelinTiedot;
        this.yksi = pelinTiedot.getPelaajaYksi();
        this.kaksi = pelinTiedot.getPelaajaKaksi();
        this.pallo = pelinTiedot.getPallo();
        peli.addKeyListener(this);
        this.peli = peli;

    }

    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metodi liikuttaa ihmispelajien mailaa ylös/alas riippuen siitä onko
     * painettu ylös vai alas nappulaa. Sekä tauttaa pelin, palauttaa
     * päävalikkoon ja aloittaa uuden pelin, jos kyseisiä nappuloita on
     * painettu.
     *
     * @param e klikattu näppäin
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int nappain = e.getKeyCode();
        toinenPelaaja(nappain);
        ensimmainenPelaaja(nappain);
        if (nappain == VK_P) {
            peli.tauko();
        }
        if (nappain == VK_M) {
            valikko();
        }
        if (nappain == VK_R) {
            uusiPeli();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Metodi aloittaa uuden pelin.
     */
    private void uusiPeli() {
        peli.getPeliAlusta().setVisible(false);
        peli.tauko();
        peli = null;
        pelinTiedot.nollaaPisteet();
        Peli peli = new Peli(pelinTiedot);
        peli.aloita();
    }
/**
 * Metodi vie käyttäjän takaisin päävalikkoon.
 */
    private void valikko() {
        peli.getPeliAlusta().setVisible(false);
        peli.tauko();
        peli = null;
        pelinTiedot.nollaaPisteet();
        new Paavalikko(pelinTiedot).setVisible(true);
    }
/**
 * Metodissa tapahtuu toisen pelaajan liikkuminen.
 * @param nappain painettu näppäin
 */
    private void toinenPelaaja(int nappain) {
        if (pelinTiedot.getOnkoToinenPelaaja()) {
            if (nappain == kaksi.getYlaNappain()) {
                if (kaksi.getY() > 0) {
                    kaksi.setY(kaksi.getY() - kaksi.getNopeus());
                }
                if (nappain == kaksi.getAlaNappain()) {
                    if (pelinTiedot.getPelilaudanKorkeus() > (kaksi.getY() + kaksi.getkorkeus() / 1.2)) {
                        kaksi.setY(kaksi.getY() + kaksi.getNopeus());
                    }
                }
            }
        }
    }
/**
 * Metodissa tapahtuu ensimmäisen pelaaja liikkuminen.
 * @param nappain painettu näppäin.
 */
    private void ensimmainenPelaaja(int nappain) {
        if (nappain == yksi.getYlaNappain()) {
            if (yksi.getY() > 0) {
                yksi.setY(yksi.getY() - yksi.getNopeus());
            }
        }
        if (nappain == yksi.getAlaNappain()) {
            if (pelinTiedot.getPelilaudanKorkeus() > (yksi.getY() + yksi.getkorkeus() / 1.2)) {
                yksi.setY(yksi.getY() + yksi.getNopeus());
            }
        }
    }
}
