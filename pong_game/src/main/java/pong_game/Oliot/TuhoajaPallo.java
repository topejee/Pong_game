/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class TuhoajaPallo extends Pallo {

    private int poista;
    private int vanhaNopeusX;

    public TuhoajaPallo(PelinTiedot tiedot) {
        super(tiedot);
        poista = 0;
        Random satunnainen = new Random();
        vanhaNopeusX = getNopeusX();
        int yy = satunnainen.nextInt(2) + 1;
        if (yy == 1) {
            setNopeusX(-getNopeusX());
        }
    }

    public int reVanhaNopeusX() {
        return vanhaNopeusX;
    }

    public void setPoistaYksi() {
        poista = 1;
    }

    /**
     * testaa törmääkö pallo mailaan
     *
     * @param peli pelattava peli
     */
    @Override
    public void tormaustestiMaila(Peli peli) {
        vasenMaila(peli);
        oikeaMaila(peli);

    }

    @Override
    public void tormaustestiReuna() {
        if (getX() <= getKoko() / 2) {
            poista = 1;
        }
        if (getX() >= getPelinTiedot().getPelilaudanLeveys() - (getKoko() / 2)) {
            poista = 1;
        }
        if (getY() <= 0) {
            setNopeusY(-getNopeusY());
        }
        if (getY() >= getPelinTiedot().getPelilaudanKorkeus() - (getKoko() / 2)) {
            setNopeusY(-getNopeusY());
        }
    }

    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getX(), getY(), getKoko(), getKoko());
    }

    public int getPoista() {
        return poista;
    }

    private void vasenMaila(Peli peli) {
        if (getPalloImg().intersects(peli.getYks().getMaila())) {
            poista = 1;
            peli.getPelinTiedot().getPelaajaYksi().vahennaPiste();

        }
    }

    private void oikeaMaila(Peli peli) {
        if (getPalloImg().intersects(peli.getKaksi().getMaila())) {
            poista = 1;
            peli.getPelinTiedot().getPelaajaKaksi().vahennaPiste();
        }
    }
}
