/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import pong_game.PelinToiminta.Peli;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Random;
import pong_game.PelinToiminta.PelinTiedot;

/**
 * Luokassa pallon toiminnallisuus
 * @author Tommi
 */
public class Pallo {

    private int koko;
    private int nopeusX;
    private int nopeusY;
    private int x;
    private int y;
    private Rectangle palloImg;
    private Peli peli;
    private PelinTiedot pelinTiedot;
    Object getX;
    private int vanhaNopeusX;
    private Random satunnainen;

    /**
     * Asettaa pallon muuttujien arvot
     */
    public Pallo(PelinTiedot tiedot) {
        pelinTiedot = tiedot;
        koko = 10 * 2;
        nopeusX = 2;
        nopeusY = 2;
        x = pelinTiedot.getPelilaudanLeveys() / 2;
        satunnainen = new Random();
        y = satunnainen.nextInt(pelinTiedot.getPelilaudanKorkeus() + 1);
        palloImg = new Rectangle(x, y, koko, koko);
        palloImg.setBounds(x, y, koko, koko);
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

    public int getKoko() {
        return koko;
    }

    public int getNopeusX() {
        return nopeusX;
    }

    public int getNopeusY() {
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

    /**
     * Metodissa asetetaan pallon paikka, sekä muutetaan sen x ja y arvoja eli
     * liikutetaan palloa
     *
     * @param peli pelattava peli
     */
    public void liiku(Peli peli) {
        this.peli = peli;
        palloImg.setBounds(x, y, koko, koko);
        tormaustestiReuna();
        x += nopeusX;
        y += nopeusY;
        tormaustestiMaila(peli);
    }

    /**
     * piirtää pallon
     *
     * @param g kyseinen graphics
     */
    public void piirra(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, koko, koko);
    }

    /**
     * Metodi testaa törmääkö pallo mailaan ja tekee siitä seuraavan tapahtuman.
     *
     * @param peli pelattava peli
     */
    public void tormaustestiMaila(Peli peli) {
        if (palloImg.intersects(peli.getYks().getMaila()) || palloImg.intersects(peli.getKaksi().getMaila())) {
            if ((palloImg.intersects(peli.getYks().getMaila()) && palloImg.getX() <= 38) || (palloImg.intersects(peli.getKaksi().getMaila()) && palloImg.getX() >= 743)) {
                tormausMailaNopeus();
            } else {
                nopeusX = -nopeusX;
                x += nopeusX * 5;
            }
        }
    }

    public void tormausMailaNopeus() {
        nopeusY = -nopeusY;
        y += nopeusY * 5;
    }
/**
 * Metodi testaa törmääkö pallo seinään ja tekee siitä seuravaan tapahtuman.
 */
    public void tormaustestiReuna() {
        if (x <= 0) {
            peli.getKaksi().lisaaPiste();
            arvoPallonPaikka();
        }
        if (x >= pelinTiedot.getPelilaudanLeveys()) {
            peli.getYks().lisaaPiste();
            arvoPallonPaikka();
        }
        if (y <= 0) {
            nopeusY = -nopeusY;
        }
        if (y >= pelinTiedot.getPelilaudanKorkeus() - (koko / 2)) {
            nopeusY = -nopeusY;
        }
    }
/**
 * Metodi arpoo pallolle uuden paikan.
 */
    public void arvoPallonPaikka() {
        int satunnaineLuku = satunnainen.nextInt(pelinTiedot.getPelilaudanKorkeus() - 10) + 5;
        x = pelinTiedot.getPelilaudanLeveys() / 2;
        y = satunnaineLuku;
        int yy = satunnainen.nextInt(1) + 1;
        if (yy == 1) {
            setNopeusX(-getNopeusX());
        }
    }

    public void setNopeusX(int x) {
        nopeusX = x;
    }

    public void setNopeusY(int x) {
        nopeusY = x;
    }

    public Rectangle getPalloImg() {
        return palloImg;
    }

    public Peli getPeli() {
        return peli;
    }

    public PelinTiedot getPelinTiedot() {
        return pelinTiedot;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
