/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.PelinToiminta;

import pong_game.Oliot.Pallo;
import pong_game.Oliot.Pelaaja;

/**
 *
 * @author Tommi
 */
public class PelinTiedot {

    private int peliLaudanKorkeus;
    private int peliLaudanLeveys;
    private int pistemaara;
    private Pelaaja pelaajaYksi;
    private Pelaaja pelaajaKaksi;
    private Pallo pallo;
    private boolean toinenPelaaja;

    public PelinTiedot() {
        peliLaudanKorkeus = 300 * 2;
        peliLaudanLeveys = 400 * 2;
        pistemaara = 5;
        this.pelaajaYksi = new Pelaaja();
        this.pelaajaKaksi = new Pelaaja();
        this.pallo = new Pallo(this);
        toinenPelaaja = false;
    }

    public void setFalse() {
        toinenPelaaja = false;
    }

    public void setTrue() {
        toinenPelaaja = true;
    }
    public boolean getOnkoToinenPelaaja(){
        return toinenPelaaja;
    }

    public int getPelilaudanKorkeus() {
        return peliLaudanKorkeus;
    }

    public int getPelilaudanLeveys() {
        return peliLaudanLeveys;
    }

    public Pelaaja getPelaajaYksi() {
        return pelaajaYksi;
    }

    public Pelaaja getPelaajaKaksi() {
        return pelaajaKaksi;
    }

    public Pallo getPallo() {
        return pallo;
    }

    public int getPelinPisteet() {
        return pistemaara;
    }

    public void setPistemaara(int maara) {
        pistemaara = maara;
    }

    public void setPeliLaudanLeveys(int i) {
        peliLaudanLeveys = i;
    }

    public void setPeliLaudanKorkeus(int i) {
        peliLaudanKorkeus = i;
    }

}
