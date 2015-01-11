/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import pong_game.PelinToiminta.PelinTiedot;

/**
 * Luokassa on Asetukset luokan laatikoiden toiminnallisuus
 * @author Tommi
 */
public class LaatikoidenRaksit implements ItemListener {

    private JCheckBox toinenPelaaja;
    private JCheckBox ammusPallo;
    private JCheckBox tuhoajaPallo;
    private PelinTiedot pelinTiedot;

    /**
     *
     * @param toinenPelaaja boolean joka kertoo onko ihmis vai Ai pelaaja
     * @param ammusPallo pallo minkä ottaessa saa ammuttua tuhoaja pallon
     * @param tuhoajaPallo jos osuu mailaa menettää pisteen
     * @param pelinTiedot kertoo pelin tiedot
     */
    public LaatikoidenRaksit(JCheckBox toinenPelaaja, JCheckBox ammusPallo, JCheckBox tuhoajaPallo, PelinTiedot pelinTiedot) {
        this.pelinTiedot = pelinTiedot;
        this.ammusPallo = ammusPallo;
        this.tuhoajaPallo = tuhoajaPallo;
        this.toinenPelaaja = toinenPelaaja;
    }

    /**
     * Metodi suorittaa asiat mitä tapahtuu kun laatikkoa on painettu ja siitä
     * on poistettu tai laitettu raksi
     *
     * @param e laatikko mitä on painettu
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox j = (JCheckBox) e.getSource();
        if (j.equals(toinenPelaaja)) {
            toinenPelaaja();

        }

        if (j.equals(tuhoajaPallo)) {
            tuhoajaPallo();

        }
        if (j.equals(ammusPallo)) {
            ammusPallo();
        }

    }

    /**
     * Metodi laittaa pelinTiedot luokasta AI:n vääräksi tai todeksi. Riippuen
     * onko laatikossa raksi vai ei.
     */
    private void toinenPelaaja() {
        if (!toinenPelaaja.isSelected()) {
            pelinTiedot.setAIFalse();
        }
        if (toinenPelaaja.isSelected()) {
            pelinTiedot.setAITrue();
        }
    }

    /**
     * Metodi laittaa pelinTiedot luokasta ammusPallon vääräksi tai todeksi.
     * Riippuen onko laatikossa raksi vai ei.
     */
    private void ammusPallo() {

        if (ammusPallo.isSelected()) {
            pelinTiedot.setAmmusPalloTrue();
        }
        if (!ammusPallo.isSelected()) {
            pelinTiedot.setAmmusPalloFalse();
        }

    }

    /**
     * Metodi laittaa pelinTiedot luokasta tuhoajaPallon vääräksi tai todeksi.
     * Riippuen onko laatikossa raksi vai ei.
     */
    private void tuhoajaPallo() {
        if (tuhoajaPallo.isSelected()) {
            pelinTiedot.setTuhoajaPalloTrue();
        }
        if (!tuhoajaPallo.isSelected()) {
            pelinTiedot.setTuhoajaPalloFalse();
        }
    }
}
