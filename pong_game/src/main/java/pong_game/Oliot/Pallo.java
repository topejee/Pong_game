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
public class Pallo {

    private int koko;
    private int nopeus;

    public Pallo() {
        this.koko = 5;
        this.nopeus = 10;
    }

    public int reKoko() {
        return koko;
    }

    public int reNopeus() {
        return nopeus;
    }

    public void kasvataNopeutta(int maara) {
        nopeus += maara;
        if (nopeus < 0) {
            nopeus = 0;
        }
    }

    public void kasvataKokoa(int maara) {
        koko += maara;
        if (koko < 0) {
            koko = 0;
        }
    }

}
