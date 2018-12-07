/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;

import SpielFigur.Spielfigur;
import java.awt.Graphics;
import projekt.ct.Steuerung;

/**
 *
 * @author Simon Spittel
 */
public abstract class Aktion {

    protected Steuerung s;
    protected int breite;
    protected int hoehe;
    protected int xPos;
    protected int yPos;
    protected Spielfigur f;
    protected boolean benutzt;
    protected boolean aktionVerfügbar = true; // <-- standardmäsig true nur bei Klasse KeineAktion wird dieser im Konstruktor auf false gesetzt
    protected boolean Falle = false;
    protected Grafiken.Grafiken grafik = new Grafiken.Grafiken();

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public boolean isBenutzt() {
        return benutzt;
    }

    public abstract void aktion();

    /**
     * @return the aktionVerfügbar
     */
    public boolean getAktionVerfügbar() {
        return aktionVerfügbar;
    }

    /**
     * @param f the f to set
     */
    public void setF(Spielfigur f) {
        this.f = f;
    }

    /**
     * @param s the s to set
     */
    public void setS(Steuerung s) {
        this.s = s;
    }

    public abstract void zeichne(Graphics g, int hoehe, int breite);

    /**
     * @return the Falle
     */
    public boolean isFalle() {
        return Falle;
    }

}
