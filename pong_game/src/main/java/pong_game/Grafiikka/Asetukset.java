package pong_game.Grafiikka;

import pong_game.Grafiikka.Nappaimet.KlikkaustenKuuntelijaAsetukset;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import pong_game.Oliot.Maila;
import pong_game.Oliot.Pallo;

/**
 *
 * @author Tommi
 */
public class Asetukset extends JFrame {

    private JFrame frame;
    // private OmaLaskuri lol;
    private JButton paavalikko;
    private JButton pallonNopeus;
    private JButton mailanNopeus;
    private JButton pistemaara;
    private JTextField pallonNopeusTeksti;
    private JTextField mailanNopeusTeksti;
    private JTextField pistemaaraTeksti;
    private JButton lopeta;
    private Pallo pallo;
    private Maila yksi;
    private Maila kaksi;

    //  @Override
    public Asetukset(Maila yksi, Maila kaksi, Pallo pallo) {
        this.yksi = yksi;
        this.kaksi = kaksi;
        this.pallo = pallo;
        frame = new JFrame("Asetukset");
        //    frame.getContentPane().setBackground(Color.BLACK);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Tommi/Desktop/pong_game_menu.png")))));
        } catch (IOException e) {
            System.out.println("Ei ollut kuvaa");
        }
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 6);
        container.setLayout(layout);
        container.add(luoValikko(), BorderLayout.BEFORE_FIRST_LINE);
        nappaimet();
    }

    public void nappaimet() {
        KlikkaustenKuuntelijaAsetukset kopioija = new KlikkaustenKuuntelijaAsetukset(pallonNopeus, pallonNopeusTeksti, mailanNopeus, mailanNopeusTeksti, pistemaara, pistemaaraTeksti, paavalikko, lopeta, frame, yksi, kaksi, pallo);
        paavalikko.addActionListener(kopioija);
        pallonNopeus.addActionListener(kopioija);
        mailanNopeus.addActionListener(kopioija);
        pistemaara.addActionListener(kopioija);
        lopeta.addActionListener(kopioija);
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        paavalikko = new JButton("Palaa päävalikkoon");
        pallonNopeus = new JButton("Pallon nopeus");
        mailanNopeus = new JButton("Mailan nopeus");
        pistemaara = new JButton("Pistemaara");
        lopeta = new JButton("Lopeta");
        pallonNopeusTeksti = new JTextField();
        pallonNopeusTeksti.setText(pallo.reNopeusX() + "");
        mailanNopeusTeksti = new JTextField();
        mailanNopeusTeksti.setText(yksi.reNopeus() + "");
        pistemaaraTeksti = new JTextField();
        pistemaaraTeksti.setText(pallo.rePistemaara() + "");
        panel.add(pallonNopeus);
        panel.add(pallonNopeusTeksti);
        panel.add(mailanNopeus);
        panel.add(mailanNopeusTeksti);
        panel.add(pistemaara);
        panel.add(pistemaaraTeksti);
        panel.add(paavalikko);
        panel.add(lopeta);

        return panel;
    }

}
