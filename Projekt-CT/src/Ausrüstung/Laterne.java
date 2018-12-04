/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ausrüstung;

import java.awt.Graphics;
import javax.swing.Timer;

/**
 *
 * @author Simon Spittel
 */
public class Laterne extends Item {
    private boolean brennt = true;
    
    
    public Laterne(int x, int y){
        xPos = x;
        yPos = y;
        Art = "L";
        brennt = true;
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
