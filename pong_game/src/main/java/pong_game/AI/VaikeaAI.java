/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.AI;

import java.util.Random;
import pong_game.PelinToiminta.Peli;
import pong_game.Oliot.Pelaaja;

/**
 *
 * @author Tommi
 */
public class VaikeaAI extends AI {

    private Pelaaja pelaaja;
    private Peli peli;

    /**
     *
     * @param maila AI:lle annettava maila, joka on tällähetkellä aina oikea
     * maila
     * @param peli Peli jota pelataan.
     */
    public VaikeaAI(Pelaaja maila, Peli peli) {
        pelaaja = maila;
        this.peli = peli;
    }

    /**
     * Metodi, jolla VaikeaAI tekee siirtonsa, eli liikuttaa mailaansa. Vaikea
     * AI tekee siirtonsa pallon koordinaattien perusteella. Kun AI on saanut
     * selville pallon koordinaatit liikkuu se palloa kohti y akselilla.
     */
    public void teeSiirto() {
        Random liikemaaraRandom = new Random();
        int liikemaaraInt = 0;
        int x = peli.getPallo().getNopeusX() * 2 / 3;
        if (x < 0) {
            x = -x;
        }
        if (peli.getPallo().getY() > pelaaja.getY() + pelaaja.getLeveys() / 2) {
            if ((peli.getPelinTiedot().getPelilaudanKorkeus()) > (peli.getKaksi().getY() + peli.getKaksi().getkorkeus() / 1.2)) {
                liikemaaraInt = liikemaaraRandom.nextInt(10);
                if (liikemaaraInt > 4) {
                    pelaaja.setY(pelaaja.getY() + x * 2);
                } else {
                    pelaaja.setY(pelaaja.getY() + x);
                }
            }
        }
        if (peli.getPallo().getY() < pelaaja.getY() + pelaaja.getLeveys() / 2) {
            if ((peli.getKaksi().getY() > 0)) {
                liikemaaraInt = liikemaaraRandom.nextInt(10);
                if (liikemaaraInt > 4) {
                    pelaaja.setY(pelaaja.getY() - x * 2);
                } else {
                    pelaaja.setY(pelaaja.getY() - x);
                }
            }
        }
    }
}
