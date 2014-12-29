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
public class VaikeaAI extends AI {

    private Maila pelaaja;
    private Peli peli;

    /**
     *
     * @param maila AI:lle annettava maila, joka on tällähetkellä aina oikea
     * maila
     * @param peli Peli jota pelataan.
     */
    public VaikeaAI(Maila maila, Peli peli) {
        pelaaja = maila;
        this.peli = peli;
    }

    /**
     * Metodi, jolla VaikeaAI tekee siirtonsa, eli liikuttaa mailaansa. Vaikea
     * AI tekee siirtonsa pallon koordinaattien perusteella. Kun AI on saanut
     * selville pallon koordinaatit liikkuu se palloa kohti y akselilla.
     */
    public void teeSiirto() {
        int x = peli.rePallo().reNopeusX() * 2 / 3;
        if (x < 0) {
            x = -x;
        }
        if (peli.rePallo().reY() > pelaaja.reY()) {
            pelaaja.setY(pelaaja.reY() + x);
        }
        if (peli.rePallo().reY() < pelaaja.reY()) {
            pelaaja.setY(pelaaja.reY() - x);
        }
    }
}
