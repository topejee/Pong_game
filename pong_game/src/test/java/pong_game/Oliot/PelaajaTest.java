/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

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
public class PelaajaTest {

    private Pelaaja maila;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        maila = new Pelaaja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoMailanXArvoOikea() {
        assertEquals(1, maila.getX());
    }

    @Test
    public void onkoMailanYArvoOikea() {
        assertEquals(10, maila.getY());
    }

    @Test
    public void onkoMailanLeveysArvoOikea() {
        assertEquals(40, maila.getLeveys());
    }

    @Test
    public void onkoMailanKorkeusArvoOikea() {
        assertEquals(100, maila.getkorkeus());
    }

    @Test
    public void onkoMailanNopeusArvoOikea() {
        assertEquals(10, maila.getNopeus());
    }

    @Test
    public void lisaaPiste() {
        maila.lisaaPiste();
        assertEquals(1, maila.getPisteet());
    }

    @Test
    public void onkoKorkeusOikea() {
        maila.setMailanKorkeus(10);
        assertEquals(10, maila.getkorkeus());
    }

    @Test
    public void onkoXOikea() {
        maila.setX(5);
        assertEquals(5, maila.getX());
    }

    @Test
    public void onkoYOikea() {
        maila.setX(5);
        assertEquals(10, maila.getY());
    }


    @Test
    public void onkoNopeusOikeaLisatessa() {
        maila.setNopeus(10);
        assertEquals(10, maila.getNopeus());
    }

}
