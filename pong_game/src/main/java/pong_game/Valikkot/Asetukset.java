package pong_game.Valikkot;

import pong_game.Nappaimet.KlikkaustenKuuntelijaAsetukset;
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
import pong_game.PelinToiminta.PelinTiedot;
import pong_game.Oliot.Pelaaja;
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
    private Pelaaja yksi;
    private Pelaaja kaksi;
    private PelinTiedot pelinTiedot;

    //  @Override
    /**
     *
     * @param yksi on vasemman puolinen maila
     * @param kaksi on oikean puolinen maila
     * @param pallo on pelissä oleva pallo
     */
    public Asetukset(PelinTiedot pelinTiedot) {
        this.pelinTiedot = pelinTiedot;
        this.yksi = pelinTiedot.getPelaajaYksi();
        this.kaksi = pelinTiedot.getPelaajaKaksi();
        this.pallo = pelinTiedot.getPallo();
        frame = new JFrame("Asetukset");
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

    /**
     * Tehdään Asetukset Luokka missä on nappulat ym. Käyttämällä monia
     * metodeita
     *
     * @param container säilö, missä on näppäimet ym.
     */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 6);
        container.setLayout(layout);
        container.add(luoValikko(), BorderLayout.BEFORE_FIRST_LINE);
        nappaimet();
    }

    /**
     * Metodi tekee Asetukset luokalle uuden Klikkaustenkuuntelijan, jonka
     * avulla saadan aikaan Asetukset luokan nappulat ym. toiminnallisuudet
     * aikaan.
     */
    public void nappaimet() {
        KlikkaustenKuuntelijaAsetukset kopioija = new KlikkaustenKuuntelijaAsetukset(pallonNopeus, pallonNopeusTeksti, mailanNopeus, mailanNopeusTeksti, pistemaara, pistemaaraTeksti, paavalikko, lopeta, frame, pelinTiedot);
        paavalikko.addActionListener(kopioija);
        pallonNopeus.addActionListener(kopioija);
        mailanNopeus.addActionListener(kopioija);
        pistemaara.addActionListener(kopioija);
        lopeta.addActionListener(kopioija);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Medodissa luodaan valikkoon kuuluvat nappulat, sekä teksti alueet.
     * nappulat, sekä teksti alueet nimetään. Tämän jälkeen nappulat sekä teksti
     * alueet lisätään paneeliin
     *
     * @return palauttaa paneelin
     */
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        paavalikko = new JButton("Palaa päävalikkoon");
        pallonNopeus = new JButton("Pallon nopeus");
        mailanNopeus = new JButton("Mailan nopeus");
        pistemaara = new JButton("Pistemaara");
        lopeta = new JButton("Lopeta");
        lopeta.setText("testi");
        pallonNopeusTeksti = new JTextField();
        pallonNopeusTeksti.setText(pallo.getNopeusX() + "");
        mailanNopeusTeksti = new JTextField();
        mailanNopeusTeksti.setText(yksi.getNopeus() + "");
        pistemaaraTeksti = new JTextField();
        pistemaaraTeksti.setText(pelinTiedot.getPelinPisteet() + "");
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
