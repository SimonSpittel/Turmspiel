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
public class KeinItem extends Item {

    public KeinItem(int x, int y) {
        xPos = x;
        yPos = y;

    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {

    }

    @Override
    public void zeichneInventarIcon(Graphics g, int hoehe, int breite, int Inventarstelle) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;

        g.drawImage(grafik.getOpenChest(), ((17) * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
    }

    @Override
    public void nutzen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inaktiv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
