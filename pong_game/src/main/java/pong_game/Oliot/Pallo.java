/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import pong_game.Kaynnistys.Peli;
import java.awt.Rectangle;
import java.awt.Graphics;
import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Tommi
 */
public class Pallo {

    private int koko;
    private int nopeusX;
    private int nopeusY;
    private int peliKorkeus;
    private int peliLeveys;
    private int x;
    private int y;
    private Rectangle palloImg;
    private int pistemaara;
    private Peli peli;

    /**
     * Asettaa pallon muuttujien arvot
     */
    public Pallo() {
        koko = 10 * 2;
        nopeusX = 2;
        nopeusY = 2;
        peliKorkeus = 300 * 2;
        peliLeveys = 400 * 2;
        x = rePeLev() / 2;
        Random satunnainen = new Random();
        int satunnaineLuku = satunnainen.nextInt(rePeKor() + 1);
        y = satunnaineLuku;
        palloImg = new Rectangle(x, y, koko, koko);
        palloImg.setBounds(x, y, koko, koko);
        pistemaara = 5;
    }

    public void setNopeus(int maara) {
        nopeusX = maara;
        nopeusY = maara;
        if (nopeusX < 0) {
            nopeusX = 0;
        }
        if (nopeusY < 0) {
            nopeusY = 0;
        }
    }

    public int reKoko() {
        return koko;
    }

    public int reNopeusX() {
        return nopeusX;
    }

    public int reNopeusY() {
        return nopeusY;
    }

    public void kasvataNopeutta(int maara) {
        nopeusX += maara;
        nopeusY += maara;
        if (nopeusX < 0) {
            nopeusX = 0;
        }
        if (nopeusY < 0) {
            nopeusY = 0;
        }
    }

    public void kasvataKokoa(int maara) {
        koko += maara;
        if (koko < 0) {
            koko = 0;
        }
    }

    public int rePeKor() {
        return peliKorkeus;
    }

    public int rePeLev() {
        return peliLeveys;
    }

    /**
     * Metodissa asetetaan pallon paikka, sekä muutetaan sen x ja y arvoja eli
     * liikutetaan palloa
     *
     * @param peli pelattava peli
     */
    public void liiku(Peli peli) {
        this.peli = peli;
        Random satunnainen = new Random();
        int satunnaineLuku = satunnainen.nextInt(rePeKor() + 1);
        palloImg.setBounds(x, y, koko, koko);
        if (x <= koko / 2) {
            peli.reKaksi().lisaaPiste();
            x = rePeLev() / 2;
            y = satunnaineLuku;
        }
        if (x >= peli.rePallo().rePeLev() - (koko / 2)) {
            peli.reYks().lisaaPiste();
            x = rePeLev() / 2;
            y = satunnaineLuku;
        }
        if (y <= koko / 2) {
            nopeusY = -nopeusY;
        }
        if (y >= peli.rePallo().rePeKor() - (koko / 2)) {
            nopeusY = -nopeusY;
        }
        x += nopeusX;
        y += nopeusY;
        tormaustesti(peli);
    }

    /**
     * piirtää pallon
     *
     * @param g
     */
    public void piirra(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, koko, koko);
    }

    /**
     * Testaa törmääkö pallo mailaan.
     *
     * @param peli pelattava peli
     */
    public void tormaustesti(Peli peli) {
        if (palloImg.intersects(peli.reYks().ReMaila()) || palloImg.intersects(peli.reKaksi().ReMaila())) {
            nopeusX = -nopeusX;
            x += nopeusX * 5;
        }

    }

    public int rePistemaara() {
        return pistemaara;
    }

    public int reY() {
        return y;
    }

    public void setPistemaara(int maara) {
        pistemaara = maara;
    }

}
