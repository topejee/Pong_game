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
import static java.lang.Math.random;
import java.util.Random;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class Pallo extends Olio {

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
        int satunnaineLuku = satunnainen.nextInt(pelinTiedot.getPelilaudanKorkeus() + 1);
        y = satunnaineLuku;
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
    public void tormaustestiMaila(Peli peli) {
        if (palloImg.intersects(peli.getYks().getMaila()) || palloImg.intersects(peli.getKaksi().getMaila())) {

            nopeusX = -nopeusX;
            x += nopeusX * 5;
        }

    }

    public void tormaustestiReuna() {
        Random satunnainen = new Random();
        int satunnaineLuku = satunnainen.nextInt(pelinTiedot.getPelilaudanKorkeus()) + 1;
        if (x <= koko / 2) {
            peli.getKaksi().lisaaPiste();
            x = pelinTiedot.getPelilaudanLeveys() / 2;
            y = satunnaineLuku;
            int yy = satunnainen.nextInt(1) + 1;
            if (yy == 1) {
                setNopeusX(-getNopeusX());
            }
        }
        if (x >= pelinTiedot.getPelilaudanLeveys() - (koko / 2)) {
            peli.getYks().lisaaPiste();
            x = pelinTiedot.getPelilaudanLeveys() / 2;
            y = satunnaineLuku;
            int yy = satunnainen.nextInt(1) + 1;
            if (yy == 1) {
                setNopeusX(-getNopeusX());
            }
        }
        if (y <= 0) {
            nopeusY = -nopeusY;
        }
        if (y >= pelinTiedot.getPelilaudanKorkeus() - (koko / 2)) {
            nopeusY = -nopeusY;
        }
    }

    public int getX() {
        return x;
    }

    public void setNopeusX(int x) {
        nopeusX = x;
    }

    public void setNopeusY(int x) {
        nopeusY = x;
    }

    public int getY() {
        return y;
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

}
