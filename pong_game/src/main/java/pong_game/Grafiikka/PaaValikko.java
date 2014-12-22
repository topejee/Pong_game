/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Grafiikka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Tommi
 */
public class PaaValikko extends JFrame {

    private JFrame frame;
    // private OmaLaskuri lol;
    private JButton pelaa;
    private JButton asetukset;
    private JButton lopeta;

    //  @Override
    public PaaValikko() {
        frame = new JFrame("Päävalikko");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 3);
        container.setLayout(layout);
        container.add(luoValikko(), BorderLayout.SOUTH);
        KlikkaustenKuuntelija kopioija = new KlikkaustenKuuntelija(pelaa, asetukset, lopeta);
        pelaa.addActionListener(kopioija);
        asetukset.addActionListener(kopioija);
        lopeta.addActionListener(kopioija);
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        pelaa = new JButton("Pelaa");
        asetukset = new JButton("Asetukset");
        lopeta = new JButton("Lopeta");
        panel.add(pelaa);
        panel.add(asetukset);
        panel.add(lopeta);
        return panel;
    }

}
