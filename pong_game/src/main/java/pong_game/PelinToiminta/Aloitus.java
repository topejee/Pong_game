package pong_game.PelinToiminta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tommi
 */
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import pong_game.Valikkot.Paavalikko;
import pong_game.Oliot.Pallo;
import pong_game.Oliot.Pelaaja;

public class Aloitus {

    /**
     * Tekee pelissä käytettävät mailat ja pallon, sekä käynnistää Päävalikon
     *
     * @param args
     */
    public static void main(String[] args) {

         new Paavalikko(new PelinTiedot()).setVisible(true);
  
    }

}
