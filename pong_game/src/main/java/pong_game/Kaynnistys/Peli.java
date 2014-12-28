/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Kaynnistys;

import java.awt.BorderLayout;
import pong_game.Grafiikka.Nappaimet.peliNappaimet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pong_game.AI.AI;
import pong_game.AI.BossAI;
import pong_game.AI.HelppoAI;
import pong_game.AI.VaikeaAI;
import pong_game.Oliot.Maila;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class Peli extends Canvas implements Runnable {

    private Maila yksi;
    private Maila kaksi;
    private Pallo pallo;
    private JFrame frame;
    private Dimension peliLauta;
    private peliNappaimet nappaimet;
    private BufferStrategy grafiikat;
    private BufferedImage kuva;
    private AI AI;

    public Peli(Maila yksi, Maila kaksi, Pallo pallo) {
        this.pallo = pallo;
        this.yksi = yksi;
        this.kaksi = kaksi;
        frame = new JFrame();
        peliLauta = new Dimension(pallo.rePeLev() + 15, pallo.rePeKor() + 47);
        frame.setMinimumSize(peliLauta);
        frame.setPreferredSize(peliLauta);
        //      frame.setMaximumSize(peliLauta);
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(true);
        frame.setTitle("Pong game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        nappaimet = new peliNappaimet(yksi, kaksi, pallo, this);
        kuva = new BufferedImage(pallo.rePeLev() + 50, pallo.rePeKor() + 40, BufferedImage.TYPE_INT_RGB);
        yksi.setX(1);
        yksi.setY(pallo.rePeKor() / 2);
        kaksi.setX(pallo.rePeLev() - kaksi.reLeveys());
        kaksi.setY(pallo.rePeKor() / 2);
        //   kaksi.setMailanKorkeus(200);

        AI = new BossAI(kaksi, this);
    }

    @Override
    public void run() {
        while (true) {
            if (pallo.rePistemaara() <= yksi.rePisteet()) {
                voittaja("VASEN PELAAJA");
                break;
            }
            if (pallo.rePistemaara() <= kaksi.rePisteet()) {
                voittaja("OIKEA PELAAJA");
                break;
            }
            AI.teeSiirto();
            pallo.liiku(this);
            kaksi.liiku(this);
            yksi.liiku(this);
            piirra();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Peli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void aloita() {
        new Thread(this).start();
    }

    public void piirra() {
        BufferStrategy kuvaa = getBufferStrategy();
        if (kuvaa == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = kuvaa.getDrawGraphics();
        g.drawImage(kuva, 0, 0, pallo.rePeLev() + 10, pallo.rePeKor() + 10, null);
        g.setColor(Color.WHITE);
        g.drawString("Pelaajan yksi pisteet " + yksi.rePisteet(), 20, 10);
        g.drawString("Pelaajan kaksi pisteet " + kaksi.rePisteet(), pallo.rePeLev() - 200, 10);
        g.drawLine(pallo.rePeLev() / 2, 1, pallo.rePeLev() / 2, pallo.rePeKor());
        pallo.piirra(g);
        yksi.piirra(g);
        kaksi.piirra(g);
        g.dispose();
        kuvaa.show();
    }

    public void voittaja(String x) {
        BufferStrategy kuvaa = getBufferStrategy();
        if (kuvaa == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = kuvaa.getDrawGraphics();
        g.drawImage(kuva, 0, 0, pallo.rePeLev() + 10, pallo.rePeKor() + 10, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("timesRoman", Font.BOLD, 20));
        g.drawString("PELI ON LOPPUNUT, VOITTAJA ON " + x, 20, 20);
        g.dispose();
        kuvaa.show();
    }

    public Maila reYks() {
        return yksi;
    }

    public Maila reKaksi() {
        return kaksi;
    }

    public Pallo rePallo() {
        return pallo;
    }
}
