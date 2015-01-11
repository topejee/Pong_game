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
public class AmmuntaPalloTest {

    private Peli peli;
    private AmmuntaPallo pallo;
    private PelinTiedot pelinTiedot;

    public AmmuntaPalloTest() {
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
        pallo = new AmmuntaPallo(pelinTiedot);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void poistuukoPalloOsumasta() {
        pallo.osuma();
        assertEquals(1, pallo.getPoista());
    }

    @Test
    public void nopeusPalloOsumasta() {
        Pallo pallo1 = new Pallo(pelinTiedot);
        pallo1 = pallo.osuma();
        assertEquals(0, pallo1.getNopeusY());
    }

    @Test
    public void osumaVasenMaila() {
        pallo.osumaOikeaPallo(peli);
    }
}
