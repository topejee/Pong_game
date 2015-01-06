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
 *
 * @author Tommi
 */
public class LaatikoidenRaksit implements ItemListener {

    private JCheckBox toinenPelaaja;
    private JCheckBox ammusPallo;
    private JCheckBox tuhoajaPallo;
    private PelinTiedot pelinTiedot;

    public LaatikoidenRaksit(JCheckBox toinenPelaaja, JCheckBox ammusPallo, JCheckBox tuhoajaPallo, PelinTiedot pelinTiedot) {
        this.pelinTiedot = pelinTiedot;
        this.ammusPallo = ammusPallo;
        this.tuhoajaPallo = tuhoajaPallo;
        this.toinenPelaaja = toinenPelaaja;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (toinenPelaaja.isSelected()) {
            pelinTiedot.setAITrue();
        }
        if (!toinenPelaaja.isSelected()) {
            pelinTiedot.setAIFalse();
        }
        if (tuhoajaPallo.isSelected()) {
            pelinTiedot.setTuhoajaPalloFalse();
        }
        if (!tuhoajaPallo.isSelected()) {

            pelinTiedot.setTuhoajaPalloTrue();
        }
        if (ammusPallo.isSelected()) {
            pelinTiedot.setAmmusPalloFalse();
        }
        if (!ammusPallo.isSelected()) {

            pelinTiedot.setAmmusPalloTrue();
        }
    }

}
