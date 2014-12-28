/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Oliot;

import java.awt.Color;
import java.awt.Graphics;
import pong_game.Kaynnistys.Peli;

/**
 *
 * @author Tommi
 */
public class Ammus extends Pallo {

    private int x;
    private int y;

    public Ammus(int x, int y) {
        this.x = x;
        this.y = y;
        setSuuntaVasen();
    }

    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, reKoko(), reKoko());
    }

}
