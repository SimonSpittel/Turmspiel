/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wurmspiel;

import static java.awt.Color.*;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author noah.hauke
 */
public class Wurmzelle extends Zelle {

    public Wurmzelle(int pX, int pY) {
        super(pX, pY);        
    }
    public Point getPos(){
        return this.pos;
        
    }



    @Override
    public void zeichne(Graphics g) {
        g.setColor(GREEN);
        g.fillRect(pos.x*Breite, pos.y*Hoehe, Breite,Hoehe );
        g.setColor(BLACK);
        g.drawRect(pos.x*Breite, pos.y*Hoehe, Breite,Hoehe );
    }
    
    
}
