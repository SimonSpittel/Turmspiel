/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ausrüstung;

import java.awt.Graphics;

/**
 *
 * @author Simon Spittel
 */
public class Schlüssel extends Item{
    public Schlüssel(int x, int y){
        xPos = x;
        yPos = y;
        Art = "S";
        
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
