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

/**
 *
 * @author Tommi
 */
public class PalloTest {

    private Pallo pallo;

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
        pallo = new Pallo();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoPallonIntOikea() {
        assertEquals(5, pallo.reKoko());
    }

    @Test
    public void onkoPallonNopeusOikea() {
        assertEquals(10, pallo.reNopeus());
    }

    @Test
    public void meneekoPallonNopeusAlleNollan() {
        pallo.kasvataNopeutta(-20);
        assertEquals(0, pallo.reNopeus());
    }

    @Test
    public void meneekoPallonKokoAlleNollan() {
        pallo.kasvataKokoa(-20);
        assertEquals(0, pallo.reKoko());
    }

    @Test
    public void kasvaakoPallonKoonArvo() {
        pallo.kasvataKokoa(10);
        assertEquals(15, pallo.reKoko());
    }
}
