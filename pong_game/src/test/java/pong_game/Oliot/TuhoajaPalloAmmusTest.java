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
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class TuhoajaPalloAmmusTest {

    private TuhoajaPalloAmmus pallo;
    private PelinTiedot pelinTiedot;

    public TuhoajaPalloAmmusTest() {
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
        pallo = new TuhoajaPalloAmmus(pelinTiedot);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoPallonKokoOikea() {
        int x = pallo.reVanhaNopeusX();
        pallo.setNopeus(10);
        assertEquals(10, pallo.getNopeusX());
    }

}
