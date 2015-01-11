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
     * Metodi, jolla VaikeaAI tekee siirtonsa, eli liikuttaa mailaansa. AI
     * käyttää siirtojen tekemiseen luokassa olevia muita metodeja.
     */
    public void teeSiirto() {
        liikemaaraArvo = liikemaaraRandom.nextInt(10);
        if (ylosVaiAlas()) {
            if (onkoPeliLaudanReunalla() == 1) {
                liiku(mailanNopeus());
            }
        } else {
            if (onkoPeliLaudanReunalla() == 1) {
                liiku(-mailanNopeus());
            }
        }
    }

    /**
     * Metodi selvittää pallon nopeuden ja antaa sen perusteella positiivisen
     * nopeus arvon mailalle
     *
     * @return palauttaa AI:n nopeuden
     */
    public int mailanNopeus() {
        int nopeus = peli.getPallo().getNopeusX() * 2 / 3;
        if (nopeus < 0) {
            nopeus = -nopeus;
        }
        return nopeus;
    }

    /**
     * Metodi selvittää onko maila pelilaudan ylä tai ala reunalla
     * koordinaattien perusteella
     *
     * @return palauttaa totuus arvon
     */
    public int onkoPeliLaudanReunalla() {
        if ((peli.getPelinTiedot().getPelilaudanKorkeus()) > (peli.getKaksi().getY() + peli.getKaksi().getkorkeus() / 1.2) && (peli.getKaksi().getY() > 0)) {
            return 1;

        } else {
            return 2;
        }

    }

    /**
     * Metodi selivittää pallon koordinaattien perusteella pitääkö AI:n liikkua
     * alas vai ylös
     *
     * @return palauttaa totuus arvon
     */
    public boolean ylosVaiAlas() {
        if (peli.getPallo().getY() > pelaaja.getY() + pelaaja.getLeveys() / 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi arpoo AI:n liikkumis määrän nopeuden perusteella
     *
     * @param nopeus nopeuden lukuarvo
     */
    public void liiku(int nopeus) {
        int x = nopeus;
        if (liikemaaraArvo > 4) {
            pelaaja.setY(pelaaja.getY() + x * 2);
        } else {
            pelaaja.setY(pelaaja.getY() + x);
        }
    }

    public int getliikemaaraArvo() {
        return liikemaaraArvo;
    }
}
