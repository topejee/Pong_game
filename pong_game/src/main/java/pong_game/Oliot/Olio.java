/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import pong_game.PelinToiminta.Peli;

/**
 *
 * @author Tommi
 */

public abstract class Olio {
public abstract void liiku(Peli peli);
public abstract void piirra(Graphics g);
public abstract void setNopeus(int nopeus);    
}
