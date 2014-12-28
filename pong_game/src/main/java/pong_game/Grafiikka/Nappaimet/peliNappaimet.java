/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Grafiikka.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pong_game.Kaynnistys.Peli;
import pong_game.Oliot.Maila;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class peliNappaimet implements KeyListener {

    private Maila yksi;
    private Maila kaksi;
    private Pallo pallo;

    public peliNappaimet(Maila yksi, Maila kaksi, Pallo pallo, Peli peli) {
        this.yksi = yksi;
        this.kaksi = kaksi;
        this.pallo = pallo;
        peli.addKeyListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent e) { 
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int nappain = e.getKeyCode();
        if (nappain == KeyEvent.VK_W) {
          
            if (yksi.reY()>0){
           yksi.setY(yksi.reY()-yksi.reNopeus());
            }
        }
        if (nappain == KeyEvent.VK_S) {
            System.out.println(pallo.rePeKor());
            if (pallo.rePeKor()>(yksi.reY()+yksi.rekorkeus()/1.2)){
           yksi.setY(yksi.reY()+yksi.reNopeus());
                System.out.println("wtf");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        
    }

}
