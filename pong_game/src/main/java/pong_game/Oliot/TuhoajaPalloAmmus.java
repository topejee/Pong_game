/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import pong_game.PelinToiminta.PelinTiedot;

/**
 * Luokassa tuhoajaPalloAmmuksen toiminnallisuus
 *
 * @author Tommi
 */
public class TuhoajaPalloAmmus extends TuhoajaPallo {

    public TuhoajaPalloAmmus(PelinTiedot tiedot) {
        super(tiedot);
        setNopeusX(reVanhaNopeusX());
    }

}
