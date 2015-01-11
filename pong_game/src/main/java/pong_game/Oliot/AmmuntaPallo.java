/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import java.awt.Graphics;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;

/**
 * Luokassa tapahtuu ammuntaPallon toiminnallisuus
 *
 * @author Tommi
 */
public class AmmuntaPallo extends TuhoajaPallo {

    public AmmuntaPallo(PelinTiedot tiedot) {
        super(tiedot);
    }

    /**
     * Metodi piirtää pallon
     *
     * @param g graphicsin nimi
     */
    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(getX(), getY(), getKoko(), getKoko());
    }

    /**
     * Metodi testaa törmääkö pallo mailaan
     *
     * @param peli pelattava peli
     */
    @Override
    public void tormaustestiMaila(Peli peli) {
        osumaOikeaPallo(peli);
        osumaVasenMaila(peli);
    }

    /**
     * Metodissa tapahtuu vasempaan mailaan törmäämisen seuraus.
     *
     * @param peli pelattava peli
     */
    public void osumaVasenMaila(Peli peli) {
        if (getPalloImg().intersects(peli.getYks().getMaila())) {
            TuhoajaPalloAmmus pallo = osuma();
            pallo.setX(peli.getYks().getX() + 50);
            pallo.setY(peli.getYks().getY() + peli.getKaksi().getkorkeus() / 2);
            if (pallo.getNopeusX() < 0) {
                pallo.setNopeusX(-1 * getNopeusX());
            }
            getPeli().getTuhoajaPallot().add(pallo);

        }
    }

    /**
     * Metodissa tapahtuu oikeaan mailaan törmäämisen seuraus.
     *
     * @param peli pelattava peli
     */
    public void osumaOikeaPallo(Peli peli) {
        if (getPalloImg().intersects(peli.getKaksi().getMaila())) {
            TuhoajaPalloAmmus pallo = osuma();
            pallo.setX(peli.getKaksi().getX() - 50);
            pallo.setY(peli.getKaksi().getY() + peli.getKaksi().getkorkeus() / 2);
            if (pallo.getNopeusX() > 0) {
                pallo.setNopeusX(-1 * getNopeusX());
            }
            getPeli().getTuhoajaPallot().add(pallo);
        }
    }

    /**
     * Metodissa tapahtuu osumisessa seuraava tapahtuma. Missä AmmuntaPallo
     * katoaa ja tehdään uusi TuhoajaPallo.
     *
     * @return palauttaa uuden tuhoajaPallon
     */
    public TuhoajaPalloAmmus osuma() {
        setPoistaYksi();
        TuhoajaPalloAmmus pallo = new TuhoajaPalloAmmus(getPelinTiedot());
        pallo.setNopeusY(0);
        return pallo;
    }
}
