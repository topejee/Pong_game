/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class AmmuntaPallo extends TuhoajaPallo {

    public AmmuntaPallo(PelinTiedot tiedot) {
        super(tiedot);
    }

    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(getX(), getY(), getKoko(), getKoko());
    }

    public void tormaustestiMaila(Peli peli) {
        if (getPalloImg().intersects(peli.getYks().getMaila())) {
            setPoistaYksi();
            TuhoajaPalloAmmus pallo = new TuhoajaPalloAmmus(getPelinTiedot());
            pallo.setX(peli.getYks().getX() + 50);
            pallo.setY(peli.getYks().getY()+peli.getKaksi().getkorkeus()/2);
            if (pallo.getNopeusX() < 0) {
                setNopeusX(-getNopeusX());
            }
            pallo.setNopeusY(0);
            getPeli().getTuhoajaPallot().add(pallo);

        }
        if (getPalloImg().intersects(peli.getKaksi().getMaila())) {
            setPoistaYksi();
            TuhoajaPalloAmmus pallo = new TuhoajaPalloAmmus(getPelinTiedot());
            pallo.setX(peli.getKaksi().getX() - 50);
            pallo.setY(peli.getKaksi().getY()+peli.getKaksi().getkorkeus()/2);
            if (pallo.getNopeusX() > 0) {
                setNopeusX(-getNopeusX());
            }
            pallo.setNopeusY(0);
            getPeli().getTuhoajaPallot().add(pallo);

        }

    }
}
