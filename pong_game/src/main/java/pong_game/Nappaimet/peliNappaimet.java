/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Oliot.Olio;
import pong_game.Oliot.Pelaaja;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class peliNappaimet implements KeyListener {

    private Pelaaja yksi;
    private Pelaaja kaksi;
    private Pallo pallo;
    private PelinTiedot pelinTiedot;

    /**
     *
     * @param yksi vasemman puoleinen maila
     * @param kaksi oikean puoleinen maila
     * @param pallo pelissä oleva pallo
     * @param peli pelattava peli
     */
    public peliNappaimet(PelinTiedot pelinTiedot, Peli peli) {
        this.pelinTiedot = pelinTiedot;
        this.yksi = pelinTiedot.getPelaajaYksi();
        this.kaksi = pelinTiedot.getPelaajaKaksi();
        this.pallo = pelinTiedot.getPallo();
        peli.addKeyListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Liikuttaa ihmis pelajaan mailaa ylös/alas riippuen siitä onko painettu
     * ylös(w) vai alas(a)
     *
     * @param e klikattu näppäin
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int nappain = e.getKeyCode();
        if (nappain == KeyEvent.VK_W) {

            if (yksi.getY() > 0) {
                yksi.setY(yksi.getY() - yksi.getNopeus());
            }
        }
        if (nappain == KeyEvent.VK_S) {
            if (pelinTiedot.getPelilaudanKorkeus() > (yksi.getY() + yksi.getkorkeus() / 1.2)) {
                yksi.setY(yksi.getY() + yksi.getNopeus());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
