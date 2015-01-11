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
public class AI {

    private Pelaaja pelaaja;
    private Peli peli;
    private Random liikemaaraRandom;
    private int liikemaaraArvo;

    /**
     *
     * @param maila AI:lle annettava maila, joka on tällähetkellä aina oikea
     * maila
     * @param peli Peli jota pelataan.
     */
    public AI(Pelaaja maila, Peli peli) {
        this.pelaaja = maila;
        this.peli = peli;
        this.liikemaaraRandom = new Random();
        liikemaaraArvo = 0;
    }

    /**
     * Metodi, jolla VaikeaAI tekee siirtonsa, eli liikuttaa mailaansa. Vaikea
     * AI tekee siirtonsa pallon koordinaattien perusteella. Kun AI on saanut
     * selville pallon koordinaatit liikkuu se palloa kohti y akselilla.
     */
    public void teeSiirto() {
        liikemaaraArvo = liikemaaraRandom.nextInt(10);
        int x = mailanNopeus();
        if (ylosVaiAlas()) {
            if (onkoPeliLaudanReunalla() == 1) {
                liiku(x);
            }
        } else {
            if ((peli.getKaksi().getY() > 0)) {
                liiku(-x);
            }
        }
    }

    public int mailanNopeus() {
        int nopeus = peli.getPallo().getNopeusX() * 2 / 3;
        if (nopeus < 0) {
            nopeus = -nopeus;
        }
        return nopeus;
    }

    public int onkoPeliLaudanReunalla() {
        if ((peli.getPelinTiedot().getPelilaudanKorkeus()) > ((peli.getKaksi().getY() + peli.getKaksi().getkorkeus() / 1.2))) {
            return 1;
        } else if (peli.getKaksi().getY() > 0) {
            return 2;
        } else {
            return 0;
        }
    }

    public boolean ylosVaiAlas() {
        if (peli.getPallo().getY() > pelaaja.getY() + pelaaja.getLeveys() / 2) {
            return true;
        } else {
            return false;
        }
    }

    public void liiku(int maara) {
        int x = maara;
        if (liikemaaraArvo > 4) {
            pelaaja.setY(pelaaja.getY() + x * 2);
        } else {
            pelaaja.setY(pelaaja.getY() + x);
        }
    }

}
