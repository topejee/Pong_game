/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.AI;

import pong_game.Kaynnistys.Peli;
import pong_game.Oliot.Maila;

/**
 *
 * @author Tommi
 */
public class HelppoAI extends AI {

    private Maila pelaaja;
    private int x;
    private Peli peli;

    /**
     *
     * @param maila AI:lle annettava maila, joka on tällähetkellä aina oikea
     * maila
     * @param peli Peli jota pelataan.
     */

    public HelppoAI(Maila maila, Peli peli) {
        pelaaja = maila;
        this.peli = peli;
        x = 0;
    }

    /**
     * Metodi, jolla HelppoAI tekee siirtonsa, eli liikuttaa mailaansa. Siirron
     * teko riippuu mailan koordinaateista, jotka AI saa selville metodilla reY.
     * ja siirto tehdään metodilla setY
     */
    public void teeSiirto() {
        if (x == 0) {
            pelaaja.setY(pelaaja.reY() + pelaaja.reNopeus());
            if (peli.rePallo().rePeKor() < pelaaja.reY()) {
                x = 1;
            }
        }
        if (x == 1) {
            pelaaja.setY(pelaaja.reY() - pelaaja.reNopeus());
            if (0 > pelaaja.reY()) {
                x = 0;
            }
        }
    }
}