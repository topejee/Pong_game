/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.KeyEvent.VK_W;
import javax.swing.JButton;
import javax.swing.JTextField;
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Valikkot.Asetukset;
import pong_game.Valikkot.NappaintenVaihtoValikko;

/**
 * Luokassa on NappaintenVaihtoValkko luokan näppäinten ja teksti alueiden
 * toiminnallisuus
 *
 * @author Tommi
 */
public class NappaintenVaihto implements ActionListener {

    private NappaintenVaihtoValikko valikko;
    private PelinTiedot pelinTiedot;
    private int nappain;
    private boolean totta;
    private JTextField nappainTeksti;
    private char x;
    private JButton nappula;
    private String teksti;
    private Object VK;

    /**
     *
     * @param NappainTeksti teksti mihin uusi nappula kirjoitetaan
     * @param valikko valikko missä nappuloiden vaihtotehdään
     * @param tiedot pelintiedot
     */
    public NappaintenVaihto(JTextField NappainTeksti, NappaintenVaihtoValikko valikko, PelinTiedot tiedot) {
        this.valikko = valikko;
        this.pelinTiedot = tiedot;
        this.nappain = VK_W;
        this.totta = true;
        this.nappainTeksti = NappainTeksti;
        this.nappainTeksti.setText("          ");
        this.nappula = null;
        this.teksti = "";
    }

    /**
     * Metodi vaihtaa peli näppäimet
     *
     * @param ae nappula mitä on painettu
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        totta = true;
        nappula = (JButton) ae.getSource();
        teksti = nappula.getName();
        if (teksti.equals("vasenPelaajaAlas")) {
            nappain();
            pelinTiedot.getPelaajaYksi().setAlaNappain(nappain);
        }
        if (teksti.equals("vasenPelaajaYlos")) {
            nappain();
            pelinTiedot.getPelaajaYksi().setYlaNappain(nappain);
        }
        if (teksti.equals("oikeaPelaajaAlas")) {
            nappain();
            pelinTiedot.getPelaajaKaksi().setAlaNappain(nappain);
        }
        if (teksti.equals("oikeaPelaajaYlos")) {
            nappain();
            pelinTiedot.getPelaajaKaksi().setYlaNappain(nappain);
        }
        if (teksti.equals("asetukset")) {
            valikko.setVisible(false);
            Asetukset x = new Asetukset(pelinTiedot);
        }
    }

    /**
     * Metodi varmistaa, että syötetty arvo on kirjain ja asettaa nappain intiin
     * uuden nappaimen teksti, sekä vaihtaa tekstit uusiksi.
     */
    public void nappain() {
        if (onkoKirjain()) {
            x = (nappainTeksti.getText()).charAt(0);
            String xx = "";
            xx += x;
            xx = xx.toUpperCase();
            x = xx.charAt(0);
            nappain = (int) x;
            nappula.setText(x + "");
        }
    }

    /**
     * @return palauttaa totta tai epätotta arvon sen perusteella onko
     * Stringissä kirjain vai ei
     */
    public boolean onkoKirjain() {

        return nappainTeksti.getText().matches("[a-zA-Z]");
    }
}
