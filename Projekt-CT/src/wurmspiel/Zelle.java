/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wurmspiel;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author noah.hauke
 */
public abstract class Zelle {

    public Random wuerfel = new Random();
    protected Point pos = new Point();
    public int Breite = 50;
    public int Hoehe = 50;

    public Zelle(int pX, int pY) {
        this.pos.x = pX;
        this.pos.y = pY;
    }
    public void setPos(int pX, int pY){
        this.pos.x = pX;
        this.pos.y = pY;
    }

    public boolean hatGleicheXY(int pX, int pY) {
        if (pX == pos.x && pY == pos.y) {
            return true;
        }
        return false;
    }

    public abstract void zeichne(Graphics g);

}
