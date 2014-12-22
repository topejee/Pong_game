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
public class MailaTest {

    private Maila maila;

    public MailaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        maila = new Maila();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoMailanXArvoOikea() {
        assertEquals(1, maila.reX());
    }

    @Test
    public void onkoMailanYArvoOikea() {
        assertEquals(10, maila.reY());
    }

    @Test
    public void onkoMailanLeveysArvoOikea() {
        assertEquals(2, maila.reLeveys());
    }

    @Test
    public void onkoMailanKorkeusArvoOikea() {
        assertEquals(4, maila.rekorkeus());
    }

    @Test
    public void onkoMailanNopeusArvoOikea() {
        assertEquals(2, maila.reNopeus());
    }
}
