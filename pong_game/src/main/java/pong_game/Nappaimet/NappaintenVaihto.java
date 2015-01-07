/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.Canvas;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Valikkot.Asetukset;
import pong_game.Valikkot.NappaintenVaihtoValikko;

/**
 *
 * @author Tommi
 */
public class NappaintenVaihto implements ActionListener {

    private NappaintenVaihtoValikko valikko;
    private PelinTiedot pelinTiedot;
    private int nappain;
    private boolean totta;
    private JTextField nappainTeksti;

    public NappaintenVaihto(JTextField NappainTeksti, NappaintenVaihtoValikko valikko, PelinTiedot tiedot) {
        this.valikko = valikko;
        this.pelinTiedot = tiedot;
        this.nappain = 0;
        this.totta = true;
        this.nappainTeksti = NappainTeksti;
        nappainTeksti.setText("          ");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        totta = true;
        JButton j = (JButton) ae.getSource();
        String teksti = j.getName();

        if (teksti.equals("vasenPelaajaAlas")) {
            char x = (nappainTeksti.getText()).charAt(0);

            String xx = "";
            xx += x;
            xx = xx.toUpperCase();
            x = xx.charAt(0);
            nappain = (int) x;

            pelinTiedot.getPelaajaYksi().setAlaNappain(nappain);
            j.setText(x + "");
            nappainTeksti.setText("");

        }
        if (teksti.equals("vasenPelaajaYlos")) {
            char x = (nappainTeksti.getText()).charAt(0);
            String xx = "";
            xx += x;
            xx = xx.toUpperCase();
            x = xx.charAt(0);
            nappain = (int) x;
            pelinTiedot.getPelaajaYksi().setYlaNappain(nappain);
            j.setText(x + "");
            nappainTeksti.setText("");

        }
        if (teksti.equals("oikeaPelaajaAlas")) {
            char x = (nappainTeksti.getText()).charAt(0);
            String xx = "";
            xx += x;
            xx = xx.toUpperCase();
            x = xx.charAt(0);
            nappain = (int) x;
            pelinTiedot.getPelaajaKaksi().setAlaNappain(nappain);
            j.setText(x + "");
            nappainTeksti.setText("");

        }
        if (teksti.equals("oikeaPelaajaYlos")) {
            char x = (nappainTeksti.getText()).charAt(0);
            String xx = "";
            xx += x;
            xx = xx.toUpperCase();
            x = xx.charAt(0);
            nappain = (int) x;
            pelinTiedot.getPelaajaKaksi().setYlaNappain(nappain);
            j.setText(x + "");
            nappainTeksti.setText("");

        }
        if (teksti.equals("asetukset")) {
            valikko.setVisible(false);
            Asetukset x = new Asetukset(pelinTiedot);
        }
    }

}
