/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.AI;

import pong_game.Kaynnistys.Peli;
import pong_game.Oliot.Maila;

/**
 *
 * @author Tommi
 */
public class VaikeaAI extends AI{

    private Maila pelaaja;
    private Peli peli;

    public VaikeaAI(Maila maila, Peli peli) {
        pelaaja = maila;
        this.peli = peli;
    }

    public void teeSiirto() {
        int x = peli.rePallo().reNopeusX()*2/3;
        if (x <0){
            x = -x;
        }
        if (peli.rePallo().reY() > pelaaja.reY()) {
            pelaaja.setY(pelaaja.reY() + x);
        }
        if (peli.rePallo().reY() < pelaaja.reY()) {
            pelaaja.setY(pelaaja.reY() - x);
        }
    }
}
