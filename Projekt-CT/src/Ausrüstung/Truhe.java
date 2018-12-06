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
public class Truhe extends Item {

    boolean geöffnet = false;
    private Item inhalt;

    public Truhe(int x, int y, Item inhalt, int ID) {
        xPos = x;
        yPos = y;
        this.inhalt = inhalt;
        this.ID = ID;
        Art = "T";
    }

    private boolean pruefeID(int ID) {
        return this.ID == ID;
    }

    public Item getItem() {
        for (int i = 0; i < FigurID.length; i++) {
            if (pruefeID(FigurID[i])) {
                geöffnet = true;
                return inhalt;
            }
        }
        return null;
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        if (geöffnet) {
            g.drawImage(grafik.getOpenChest(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
        } else {
            g.drawImage(grafik.getClosedChest(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
        }

    }

    @Override
    public void zeichneInventarIcon(Graphics g, int hoehe, int breite, int Inventarstelle) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;

        g.drawImage(grafik.getOpenChest(), (17 * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
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
