package Oliot;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Oliot.Pallo;
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
        pallo = new Pallo(5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoPallonIntOikea() {
        assertEquals(6, pallo.reInt());
    }
}
