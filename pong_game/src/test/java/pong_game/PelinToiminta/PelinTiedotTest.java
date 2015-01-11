/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.PelinToiminta;

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
public class PelinTiedotTest {

    private PelinTiedot pelinTiedot;

    public PelinTiedotTest() {
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
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void peliLaudanLeveys() {
        pelinTiedot.setPeliLaudanLeveys(200);
        assertEquals(200, pelinTiedot.getPelilaudanLeveys());
    }

    @Test
    public void peliLaudanKorkus() {
        pelinTiedot.setPeliLaudanKorkeus(200);
        assertEquals(200, pelinTiedot.getPelilaudanKorkeus());
    }

    @Test
    public void peliPistemaarat() {
        pelinTiedot.setPistemaara(10);
        assertEquals(10, pelinTiedot.getPelinPisteet());
    }
}
