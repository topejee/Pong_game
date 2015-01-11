/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.AI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong_game.Oliot.Pallo;
import pong_game.PelinToiminta.Peli;
import pong_game.PelinToiminta.PelinTiedot;

/**
 *
 * @author Tommi
 */
public class AInTest {

    private Peli peli;
    private PelinTiedot pelinTiedot;
    private AI ai;

    public AInTest() {
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
        ai = new AI(peli.getYks(), peli);
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
    public void aInMailanNopeus() {
        peli.getPallo().setNopeusX(30);
        assertEquals(20, ai.mailanNopeus());
    }

    @Test
    public void aInMailanNopeusAlleNoppan() {
        peli.getPallo().setNopeusX(-30);
        assertEquals(20, ai.mailanNopeus());
    }

    @Test
    public void onkoMailaReunallayla() {
        peli.getKaksi().setY(-1000);
        assertEquals(2, ai.onkoPeliLaudanReunalla());
    }

    @Test
    public void onkoMailaReunallakeski() {
        peli.getKaksi().setY(50);
        assertEquals(1, ai.onkoPeliLaudanReunalla());
    }

    @Test
    public void onkoMailaReunallaala() {
        peli.getKaksi().setY(5000);
        assertEquals(2, ai.onkoPeliLaudanReunalla());
    }

    @Test
    public void ylosvaialasYlos() {
        peli.getKaksi().setY(900);
        peli.getPallo().setY(10);
        ai.ylosVaiAlas();
        assertEquals(false, ai.ylosVaiAlas());
    }

    @Test
    public void ylosvaialasAlas() {
        peli.getKaksi().setY(-900);
        peli.getPallo().setY(10);
        ai.ylosVaiAlas();
        assertEquals(false, ai.ylosVaiAlas());
    }

    @Test
    public void liikeNopeus() {
        int y = peli.getKaksi().getY();
        ai.liiku(10);
        int x = ai.getliikemaaraArvo();
        if (x > 4) {
            assertEquals(320, peli.getKaksi().getY());
        } else {
            assertEquals(300, peli.getKaksi().getY());
        }
    }
}
