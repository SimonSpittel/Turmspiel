/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ausrüstung;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Simon Spittel
 */
public class Schwert extends Item{
    
    private int Schaden;
    private int Haltbarkeit;
    private Random wuerfel = new Random();
    
    public Schwert(int x, int y){
        xPos = x;
        yPos = y;
        Schaden = wuerfel.nextInt(10)+1;
        Haltbarkeit = wuerfel.nextInt(20)+1;
        Art = "SCH";
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zeichneInventarIcon(Graphics g, int hoehe, int breite, int Inventarstelle) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        
        g.drawImage(grafik.getOpenChest(), ((17) * this.breite)+(this.breite/2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
    }
    
}
