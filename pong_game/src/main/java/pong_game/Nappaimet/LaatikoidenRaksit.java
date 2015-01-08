/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Nappaimet;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
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
 * Suorittaa asiat mitä tapahtuu kun laatikkoa on painettu ja siitä on poistettu tai laitettu raksi
 * @param e laatikko mitä on painettu 
 */
    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox j = (JCheckBox) e.getSource();
        if (j.equals(toinenPelaaja)) {
            if (!toinenPelaaja.isSelected()) {
                pelinTiedot.setAIFalse();
            }
            if (toinenPelaaja.isSelected()) {
                pelinTiedot.setAITrue();
            }

        }

        if (j.equals(tuhoajaPallo)) {
            if (tuhoajaPallo.isSelected()) {
                pelinTiedot.setTuhoajaPalloTrue();
            }
            if (!tuhoajaPallo.isSelected()) {
                pelinTiedot.setTuhoajaPalloFalse();
            }

        }
        if (j.equals(ammusPallo)) {
            if (ammusPallo.isSelected()) {

                pelinTiedot.setAmmusPalloTrue();

            }
            if (!ammusPallo.isSelected()) {
                pelinTiedot.setAmmusPalloFalse();
            }
        }

    }
}
