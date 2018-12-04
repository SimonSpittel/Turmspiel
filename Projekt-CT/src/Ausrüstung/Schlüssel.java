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
    public Schlüssel(int x, int y, int ID){
        xPos = x;
        yPos = y;
        this.ID = ID;
        Art = "S";
        
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.drawImage(grafik.getKey(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
    }
}
