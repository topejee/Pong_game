/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.AI;

import java.util.Random;
import pong_game.Kaynnistys.Peli;
import pong_game.Oliot.Maila;
import pong_game.Oliot.Ammus;

/**
 *
 * @author Tommi
 */
public class BossAI extends AI{

    private Maila pelaaja;
    private Peli peli;
    private Random stn;

    public BossAI(Maila maila, Peli peli) {
        this.pelaaja = maila;
        this.peli = peli;
        stn = new Random();
    }

    @Override
    public void teeSiirto() {
        int x = peli.rePallo().reNopeusX() * 2 / 3;
        int satun = stn.nextInt(10)+1;
        satun = 5;
        if (x < 0) {
            x = -x;
        }
        if (peli.rePallo().reY() > pelaaja.reY()) {
            pelaaja.setY(pelaaja.reY() + x);
        }
        if (peli.rePallo().reY() < pelaaja.reY()) {
            pelaaja.setY(pelaaja.reY() - x);
        }
        if (satun == 5){
            Ammus ammus = new Ammus(pelaaja.reX(), pelaaja.reY());
        }
    }

}
