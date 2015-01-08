/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import pong_game.PelinToiminta.Peli;

/**
 *
 * @author Tommi
 */
public class Pelaaja {

    private int nopeus;
    private int korkeus;
    private int leveys;
    private int x;
    private int y;
    private int pisteet;
    private Rectangle maila;
    private int ylaNappain;
    private int alaNappain;

    /**
     * Alustetaan mailan muuttujien arvot
     */
    public Pelaaja() {
        this.x = 1;
        this.y = 10;
        this.nopeus = 10;
        this.korkeus = 50 * 2;
        this.leveys = 20 * 2;
        this.pisteet = 0;
        maila = new Rectangle(x, y, leveys, korkeus);
        ylaNappain = (KeyEvent.VK_W);
        alaNappain = (KeyEvent.VK_S);
    }

    public void setMailanKorkeus(int x) {
        korkeus = x;
    }

    public int getNopeus() {
        return nopeus;
    }

    public int getkorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void lisaaPiste() {
        pisteet++;
    }

    public void vahennaPiste() {
        pisteet--;
    }

    public int getPisteet() {
        return pisteet;
    }

    public Rectangle getMaila() {
        return maila;
    }

    public int getYlaNappain() {
        return ylaNappain;
    }

    public int getAlaNappain() {
        return alaNappain;
    }

    public void setYlaNappain(int x) {
        ylaNappain = x;
    }

    public void setAlaNappain(int x) {
        alaNappain = x;
    }

    /**
     * Asettaa mailan kuvan paikan
     *
     * @param peli pelattava peli
     */
    public void liiku(Peli peli) {
        maila.setBounds(x, y, leveys, korkeus);
    }

    /**
     * piirtää mailan valittuun paikkaan
     *
     * @param g
     */
    public void piirra(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, leveys, korkeus);
    }

    public void getNopeus(int nopeus) {
        this.nopeus = nopeus;
    }

    public void setNopeus(int nopeus) {
        this.nopeus = nopeus;
    }

    public void nollaaPisteet() {
        pisteet = 0;
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
