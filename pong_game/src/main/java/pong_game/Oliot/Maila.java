/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

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

    public Maila() {
        this.x = 1;
        this.y = 10;
        this.nopeus = 2;
        this.korkeus = 4;
        this.leveys = 2;
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
}
