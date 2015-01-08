/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
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
/**
 * 
 * @param NappainTeksti teksti mihin uusi nappula kirjoitetaan
 * @param valikko valikko missä nappuloiden vaihtotehdään
 * @param tiedot pelintiedot
 */
    public NappaintenVaihto(JTextField NappainTeksti, NappaintenVaihtoValikko valikko, PelinTiedot tiedot) {
        this.valikko = valikko;
        this.pelinTiedot = tiedot;
        this.nappain = 0;
        this.totta = true;
        this.nappainTeksti = NappainTeksti;
        nappainTeksti.setText("          ");

    }
/**
 * Vaihtaa peli näppäimet
 * @param ae nappula mitä on painettu
 */
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
