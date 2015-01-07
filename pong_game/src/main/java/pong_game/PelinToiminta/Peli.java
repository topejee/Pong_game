/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.PelinToiminta;

import java.awt.BorderLayout;
import pong_game.Nappaimet.PeliNappaimet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pong_game.AI.AI;
import pong_game.AI.VaikeaAI;
import pong_game.Oliot.AmmuntaPallo;
import pong_game.Oliot.Pelaaja;
import pong_game.Oliot.Pallo;
import pong_game.Oliot.TuhoajaPallo;

/**
 *
 * @author Tommi
 */
public class Peli extends Canvas implements Runnable {

    private Pelaaja pelaajaYksi;
    private Pelaaja pelaajaKaksi;
    private Pallo pallo;
    private JFrame frame;
    private Dimension peliLauta;
    private PeliNappaimet nappaimet;
    private BufferStrategy grafiikat;
    private BufferedImage kuva;
    private AI AI;
    private PelinTiedot pelinTiedot;
    private boolean tauko;
    private ArrayList<TuhoajaPallo> tuhoajaPallot;
    private ArrayList<AmmuntaPallo> ammuntaPallot;
    private int nopeus;

    /**
     * Alustetaan peli, eli tehdään JFrame, AI, nappaimet, alustetaan mailojen
     * aloitus paikka
     *
     * @param yksi pelin vasen maila
     * @param kaksi pelin oikea maila
     * @param pallo pelissä oleva pallo
     */
    public Peli(PelinTiedot tiedot) {
        tuhoajaPallot = new ArrayList<>();
        ammuntaPallot = new ArrayList<>();
        nopeus = 0;
        this.pelinTiedot = tiedot;
        this.pallo = pelinTiedot.getPallo();
        this.pelaajaYksi = pelinTiedot.getPelaajaYksi();
        this.pelaajaKaksi = pelinTiedot.getPelaajaKaksi();
        if (pelinTiedot.getOnkoToinenPelaaja() == false) {
            this.AI = new VaikeaAI(pelaajaKaksi, this);
        }
        pelaajaYksi.setX(1);
        pelaajaYksi.setY(pelinTiedot.getPelilaudanKorkeus() / 2);
        pelaajaKaksi.setX(pelinTiedot.getPelilaudanLeveys() - pelaajaKaksi.getLeveys());
        pelaajaKaksi.setY(pelinTiedot.getPelilaudanKorkeus() / 2);
        pelinGrafiikka();

    }

    public void pelinGrafiikka() {
        frame = new JFrame();
        peliLauta = new Dimension(pelinTiedot.getPelilaudanLeveys() + 10, pelinTiedot.getPelilaudanKorkeus() + pallo.getKoko() * 2);
        frame.setAutoRequestFocus(true);
        frame.setMinimumSize(peliLauta);
        frame.setPreferredSize(peliLauta);
        frame.setMaximumSize(peliLauta);
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setTitle("Pong game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        nappaimet = new PeliNappaimet(pelinTiedot, this);
        kuva = new BufferedImage(pelinTiedot.getPelilaudanLeveys() + 50, pelinTiedot.getPelilaudanKorkeus() + 40, BufferedImage.TYPE_INT_RGB);
        this.requestFocus();
    }

    /**
     * Metodi on itse pelin toiminnallisuus. metodissa kutstuaan AI:ta tekemään
     * siirtonsa ja liikutetaan palloa, sekä mailoja. jonka jälkeen kutsutaan
     * piirrä metodia
     *
     * @see piirra()
     *
     * Lisäksi jos pistemäärä saavutetaan kutsutaan metodia joka piirtää tekstin
     * jossa on tieto kuka on voittanut pelin
     *
     * @see voittaja(String)
     */
    @Override
    public void run() {
        while (true) {
            if (tauko == false) {
                if (jokuVoitti()) {
                    break;
                }
                if ((pelinTiedot.getOnkoToinenPelaaja() == false)) {
                    AI.teeSiirto();
                }
                ammuntaPallo();
                tuhoajaPallo();
                pallo.liiku(this);
                pelaajaKaksi.liiku(this);
                pelaajaYksi.liiku(this);
                piirra();

            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Peli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean jokuVoitti() {
        if (pelinTiedot.getPelinPisteet() <= pelaajaYksi.getPisteet() || -pelinTiedot.getPelinPisteet() >= pelaajaKaksi.getPisteet()) {
            voittaja("VASEN PELAAJA");
            return true;
        }
        if (pelinTiedot.getPelinPisteet() <= pelaajaKaksi.getPisteet() || -pelinTiedot.getPelinPisteet() >= pelaajaYksi.getPisteet()) {
            voittaja("OIKEA PELAAJA");
            return true;
        }
        return false;
    }

    /**
     * aloittaa pelin
     */
    public void aloita() {
        new Thread(this).start();
    }

    public void tuhoajaPallo() {
        if ((pelinTiedot.getOnkoTuhoajaPallo() == true)) {
            lisaaMahdollisestiTuhoajaPallo();
            for (TuhoajaPallo pallo : tuhoajaPallot) {
                pallo.liiku(this);
            }
            Iterator<TuhoajaPallo> i = tuhoajaPallot.iterator();
            while (i.hasNext()) {
                TuhoajaPallo pallo = i.next();
                if (pallo.getPoista() == 1) {
                    i.remove();
                }
            }
        }
    }

    /**
     * Piirtää pelissä olevat asiat. Eli mailat, pallon, keskiviivan, sekä
     * tekstin joka kertoo piste tilanteen
     */
    public void piirra() {
        BufferStrategy kuvaa = getBufferStrategy();
        if (kuvaa == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = kuvaa.getDrawGraphics();
        g.drawImage(kuva, 0, 0, pelinTiedot.getPelilaudanLeveys() + 10, pelinTiedot.getPelilaudanKorkeus() + 47, null);
        g.setColor(Color.WHITE);
        g.drawString("Pelaajan yksi pisteet " + pelaajaYksi.getPisteet() + "/" + pelinTiedot.getPelinPisteet(), 60, 10);
        g.drawString("Uusi peli: R       Päävalikko: M    Tauko: P                       Pelaajan kaksi pisteet " + pelaajaKaksi.getPisteet() + "/" + pelinTiedot.getPelinPisteet(), pelinTiedot.getPelilaudanLeveys() - 480, 10);
        g.drawLine((pelinTiedot.getPelilaudanLeveys() / 2), 1, (pelinTiedot.getPelilaudanLeveys() / 2), pelinTiedot.getPelilaudanKorkeus() + 47);
        pallo.piirra(g);
        pelaajaYksi.piirra(g);
        pelaajaKaksi.piirra(g);
        g.setColor(Color.RED);
        if ((pelinTiedot.getOnkoTuhoajaPallo() == true)) {
            for (TuhoajaPallo pallo : tuhoajaPallot) {
                pallo.piirra(g);
            }
        }
        g.setColor(Color.ORANGE);
        if ((pelinTiedot.getOnkoAmmusPallo() == true)) {
            for (AmmuntaPallo pallo : ammuntaPallot) {
                pallo.piirra(g);
            }
        }
        g.dispose();
        kuvaa.show();
    }

    /**
     * Metodi piirtää näkyviin tekstin, jossa kerrotaan voittaja.
     *
     * @param x Teksti jossa kerrotaan voittaja. Teksti saadan run metodista kun
     * peli on loppunut
     */
    public void voittaja(String x) {
        BufferStrategy kuvaa = getBufferStrategy();
        if (kuvaa == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = kuvaa.getDrawGraphics();
        g.drawImage(kuva, 0, 0, pelinTiedot.getPelilaudanKorkeus() + 10, pelinTiedot.getPelilaudanKorkeus() + 10, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("timesRoman", Font.BOLD, 20));
        g.drawString("PELI ON LOPPUNUT, VOITTAJA ON " + x, 20, 20);
        g.dispose();
        kuvaa.show();
        lopeta();
    }

    public Pelaaja getYks() {
        return pelaajaYksi;
    }

    public Pelaaja getKaksi() {
        return pelaajaKaksi;
    }

    public Pallo getPallo() {
        return pallo;
    }

    public PelinTiedot getPelinTiedot() {
        return pelinTiedot;
    }

    public ArrayList<TuhoajaPallo> getTuhoajaPallot() {
        return tuhoajaPallot;
    }

    private void lopeta() {
        System.exit(0);
    }

    public void tauko() {
        if (tauko == true) {
            tauko = false;
        } else {
            tauko = true;
            BufferStrategy kuvaa = getBufferStrategy();
            if (kuvaa == null) {
                createBufferStrategy(3);
                return;
            }
            Graphics g = kuvaa.getDrawGraphics();
            g.drawImage(kuva, 0, 0, pelinTiedot.getPelilaudanLeveys() + 10, pelinTiedot.getPelilaudanKorkeus() + 47, null);
            g.setColor(Color.WHITE);
            g.drawString("Pelaajan yksi pisteet " + pelaajaYksi.getPisteet(), 60, 10);
            g.drawString("Pelaajan kaksi pisteet " + pelaajaKaksi.getPisteet(), pelinTiedot.getPelilaudanLeveys() - 200, 10);
            g.drawLine((pelinTiedot.getPelilaudanLeveys() / 2), 1, (pelinTiedot.getPelilaudanLeveys() / 2), pelinTiedot.getPelilaudanKorkeus() + 47);
            pallo.piirra(g);
            pelaajaYksi.piirra(g);
            pelaajaKaksi.piirra(g);
            g.setColor(Color.RED);
            if ((pelinTiedot.getOnkoTuhoajaPallo() == true)) {
                for (TuhoajaPallo pallo : tuhoajaPallot) {
                    pallo.piirra(g);
                }
            }
            g.setColor(Color.ORANGE);
            if ((pelinTiedot.getOnkoAmmusPallo() == true)) {
                for (AmmuntaPallo pallo : ammuntaPallot) {
                    pallo.piirra(g);
                }
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("timesRoman", Font.ITALIC, 50));
            g.drawString("TAUKO", 300, 300);
            g.dispose();
            kuvaa.show();
        }
    }

    private void lisaaMahdollisestiTuhoajaPallo() {
        Random x = new Random();
        int satunnainen = x.nextInt(400) + 1;
        if (satunnainen == 10) {
            TuhoajaPallo pallo = new TuhoajaPallo(pelinTiedot);
            tuhoajaPallot.add(pallo);
        }
    }

    private void lisaaMahdollisestiAmmusPallo() {
        Random x = new Random();
        int satunnainen = x.nextInt(400) + 1;
        if (satunnainen == 10) {
            AmmuntaPallo pallo = new AmmuntaPallo(pelinTiedot);
            ammuntaPallot.add(pallo);
        }
    }

    private void ammuntaPallo() {
        if ((pelinTiedot.getOnkoAmmusPallo() == true)) {
            lisaaMahdollisestiAmmusPallo();
            for (AmmuntaPallo pallo : ammuntaPallot) {
                pallo.liiku(this);
            }
            Iterator<AmmuntaPallo> i = ammuntaPallot.iterator();
            while (i.hasNext()) {
                AmmuntaPallo pallo = i.next();
                if (pallo.getPoista() == 1) {
                    i.remove();
                }
            }
        }
    }

    public JFrame getPeliAlusta() {
        return frame;
    }

}
