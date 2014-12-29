package pong_game.Kaynnistys;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tommi
 */
import pong_game.Grafiikka.Paavalikko2;

import pong_game.Oliot.Pallo;
import pong_game.Oliot.Maila;

public class Aloitus {

    /**
     * Tekee pelissä käytettävät mailat ja pallon, sekä käynnistää Päävalikon
     *
     * @param args
     */
    public static void main(String[] args) {
        Pallo pallo = new Pallo();
        Maila pelaaja_yksi = new Maila();
        Maila pelaaja_kaksi = new Maila();
        new Paavalikko2(pelaaja_yksi, pelaaja_kaksi, pallo).setVisible(true);
    }
}
