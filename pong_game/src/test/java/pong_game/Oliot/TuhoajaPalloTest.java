package pong_game.Oliot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import pong_game.Oliot.AmmuntaPallo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class TuhoajaPalloTest {

    private TuhoajaPallo pallo;
    private PelinTiedot pelinTiedot;
    private Peli peli;

    public TuhoajaPalloTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelinTiedot = new PelinTiedot();
        peli = new Peli(pelinTiedot);
        pallo = new TuhoajaPalloAmmus(pelinTiedot);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tormausTestiReunaVasen() {
        pallo.setX(-10);
        pallo.tormaustestiReuna();
        assertEquals(1, pallo.getPoista());

    }

    @Test
    public void tormausTestiReunaOikea() {
        pallo.setX(2000);
        pallo.tormaustestiReuna();
        assertEquals(1, pallo.getPoista());

    }

    @Test
    public void tormausTestiReunaYla() {
        int y = pallo.getNopeusY();
        pallo.setY(2000);
        pallo.tormaustestiReuna();
        assertEquals(-y, pallo.getNopeusY());

    }

    @Test
    public void tormausTestiReunaAla() {
        int y = pallo.getNopeusY();
        pallo.setY(-2000);
        pallo.tormaustestiReuna();
        assertEquals(-y, pallo.getNopeusY());

    }

    @Test
    public void tormaako() {
        pallo.setX(100);
        pallo.tormaustestiMaila(peli);
    }

    @Test
    public void tormaaMailaanVasenPiste() {
        int x = peli.getYks().getPisteet();
        peli.getPallo().setX(10);
        peli.getPallo().setY(10);
        peli.getYks().setX(10);
        peli.getYks().setY(10);
        peli.run();
        assertEquals(1, pallo.getPoista());
    }

    @Test
    public void tormaaMailaanVasen() {
        int x = peli.getYks().getPisteet();
        peli.getPallo().setX(10);
        peli.getPallo().setY(10);
        peli.getYks().setX(10);
        peli.getYks().setY(10);
        peli.run();
        assertEquals(x - 1, peli.getYks().getPisteet());
    }

    @Test
    public void tormaaMailaanOikeaPiste() {
        int x = peli.getKaksi().getPisteet();
        peli.getPallo().setX(10);
        peli.getPallo().setY(10);
        peli.getKaksi().setX(10);
        peli.getKaksi().setY(10);
        peli.run();
        assertEquals(1, pallo.getPoista());
    }

    @Test
    public void tormaaMailaanOikea() {
        int x = peli.getKaksi().getPisteet();
        peli.getPallo().setX(10);
        peli.getPallo().setY(10);
        peli.getKaksi().setX(10);
        peli.getKaksi().setY(10);
        peli.run();
        assertEquals(x - 1, peli.getKaksi().getPisteet());
    }

}
