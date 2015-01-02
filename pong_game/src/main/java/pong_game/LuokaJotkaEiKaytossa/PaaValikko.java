package pong_game.LuokaJotkaEiKaytossa;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pong_game.Grafiikka;
//
//import pong_game.Grafiikka.Nappaimet.KlikkaustenKuuntelija;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.WindowConstants;
//import pong_game.Oliot.Maila;
//import pong_game.Oliot.Pallo;
//
///**
// *
// * @author Tommi
// */
//public class PaaValikko extends JFrame {
//
//    private JFrame frame;
//    private JButton pelaa;
//    private JButton asetukset;
//    private JButton lopeta;
//    private Pallo pallo;
//    private Maila yksi;
//    private Maila kaksi;
//    private JPanel panel;
//
//    public PaaValikko(Maila yksi, Maila kaksi, Pallo pallo) {
//        this.pallo = pallo;
//        this.yksi = yksi;
//        this.kaksi = kaksi;
//        frame = new JFrame("Päävalikko");
//        try {
//            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Tommi/Desktop/pong_game_menu.png")))));
//        } catch (IOException e) {
//            System.out.println("Ei ollut kuvaa");
//        }
//        frame.setPreferredSize(new Dimension(500, 300));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        luoKomponentit(frame.getContentPane());
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void luoKomponentit(Container container) {
//        GridLayout layout = new GridLayout(3, 6);
//        container.setLayout(layout);
//        container.add(luoValikko(), BorderLayout.BEFORE_FIRST_LINE);
//        nappaimet();
//    }
//
//    public void nappaimet() {
//        KlikkaustenKuuntelija kopioija = new KlikkaustenKuuntelija(pelaa, asetukset, lopeta, frame, yksi, kaksi, pallo);
//        pelaa.addActionListener(kopioija);
//        asetukset.addActionListener(kopioija);
//        lopeta.addActionListener(kopioija);
//    }
//
//    public JFrame getFrame() {
//        return frame;
//    }
//
//    private JPanel luoValikko() {
//        JPanel panel = new JPanel(new GridLayout(1, 3));
//        pelaa = new JButton("Pelaa");
//        asetukset = new JButton("Asetukset");
//        lopeta = new JButton("Lopeta");
//
//        panel.add(pelaa);
//        panel.add(asetukset);
//        panel.add(lopeta);
//                             
//
//        return panel;
//    }
//
//}
