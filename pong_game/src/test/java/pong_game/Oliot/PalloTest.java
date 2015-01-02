package pong_game.Oliot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import pong_game.Oliot.Pallo;
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
public class PalloTest {

    private Pallo pallo;
    private PelinTiedot pelinTiedot;

    public PalloTest() {
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
        pallo = new Pallo(pelinTiedot);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoPallonKokoOikea() {
        assertEquals(20, pallo.getKoko());
    }

    @Test
    public void onkoPallonNopeusOikea() {
        assertEquals(2, pallo.getNopeusX());
    }

    @Test
    public void meneekoPallonNopeusAlleNollan() {
        pallo.kasvataNopeutta(-20);
        assertEquals(0, pallo.getNopeusX());
    }

    @Test
    public void meneekoPallonKokoAlleNollan() {
        pallo.kasvataKokoa(-20);
        assertEquals(0, pallo.getKoko());
    }

    @Test
    public void kasvaakoPallonKoonArvo() {
        pallo.kasvataKokoa(10);
        assertEquals(30, pallo.getKoko());
    }

    @Test
    public void onkoPeliLaudanLeveytta() {
        assertEquals(pelinTiedot.getPelilaudanLeveys() / 2, 400);
    }

    @Test
    public void onkoNopeusAlleNollanY() {
        pallo.setNopeusY(0);
        pallo.setNopeus(-10);
        assertEquals(0, pallo.getNopeusY());
    }

    @Test
    public void onkoNopeusAlleNollanX() {
        pallo.setNopeusX(0);
        pallo.setNopeus(-10);
        assertEquals(0, pallo.getNopeusX());
    }

    @Test
    public void onkokasvataNopeuttaXOikein() {
        pallo.setNopeusX(0);
        pallo.kasvataNopeutta(-10);
        assertEquals(0, pallo.getNopeusX());
    }

    @Test
    public void onkokasvataNopeuttaYOikein() {
        pallo.setNopeusY(0);
        pallo.kasvataNopeutta(-10);
        assertEquals(0, pallo.getNopeusY());
    }

    @Test
    public void onkokasvataKokoaOikein() {
        pallo.kasvataKokoa(-1000);
        assertEquals(0, pallo.getKoko());
    }
}
