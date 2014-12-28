/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import pong_game.Kaynnistys.Peli;

/**
 *
 * @author Tommi
 */
public class Maila {

    private int nopeus;
    private int korkeus;
    private int leveys;
    private int x;
    private int y;
    private int pisteet;
    private Rectangle maila;

    public Maila() {
        this.x = 1;
        this.y = 10;
        this.nopeus = 10;
        this.korkeus = 50*2;
        this.leveys = 20*2;
        this.pisteet = 0;
        maila = new Rectangle(x, y, leveys, korkeus);
    }
public void setMailanKorkeus(int x){
    korkeus = x;
}
    public int reNopeus() {
        return nopeus;
    }

    public int rekorkeus() {
        return korkeus;
    }

    public int reLeveys() {
        return leveys;
    }

    public int reX() {
        return x;
    }

    public int reY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void lisaaPiste() {
        pisteet++;
    }
    public int rePisteet(){
        return pisteet;
    }

    public Rectangle ReMaila() {
        return maila;
    }

    public void liiku(Peli peli) {
        maila.setBounds(x, y, leveys, korkeus);
    }

    public void piirra(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, leveys, korkeus);
    }
    public void setNopeus(int nopeus){
        this.nopeus = nopeus;
    }
}
