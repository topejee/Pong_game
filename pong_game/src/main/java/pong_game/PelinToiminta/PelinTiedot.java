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
    private boolean tuhoajaPallo;
    private boolean ammusPallo;

    public PelinTiedot() {
        peliLaudanKorkeus = 600;
        peliLaudanLeveys = 800;
        pistemaara = 5;
        this.pelaajaYksi = new Pelaaja();
        this.pelaajaKaksi = new Pelaaja();
        this.pallo = new Pallo(this);
        toinenPelaaja = false;
        tuhoajaPallo = true;
        ammusPallo = true;
    }

    public void setAIFalse() {
        toinenPelaaja = false;
    }

    public void setAITrue() {
        toinenPelaaja = true;
    }

    public void setTuhoajaPalloFalse() {
        tuhoajaPallo = false;
    }

    public void setTuhoajaPalloTrue() {
        tuhoajaPallo = true;
    }

    public void setAmmusPalloFalse() {
        ammusPallo = false;
    }

    public void setAmmusPalloTrue() {
        ammusPallo = true;
    }

    public boolean getOnkoAmmusPallo() {
        return ammusPallo;
    }

    public boolean getOnkoToinenPelaaja() {
        return toinenPelaaja;
    }

    public boolean getOnkoTuhoajaPallo() {
        return tuhoajaPallo;
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

    public void nollaaPisteet() {
        pelaajaKaksi.nollaaPisteet();
        pelaajaYksi.nollaaPisteet();
    }

}
