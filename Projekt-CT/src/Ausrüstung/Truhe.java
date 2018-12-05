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
    private int benötigteID;

    public Truhe(int x, int y, Item inhalt, int ID) {
        xPos = x;
        yPos = y;
        this.inhalt = inhalt;
        benötigteID = ID;
        Art = "T";
    }

    private boolean pruefeID(int ID) {
        return benötigteID == ID;
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

}
