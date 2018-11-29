/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;

import Spielelement.Spielelement;
import Spielelement.Spielfigur;
import projekt.ct.Steuerung;

/**
 *
 * @author Simon Spittel
 */
public abstract class Aktion {

    protected Steuerung s;
    protected int xPos;
    protected int yPos;
    private Spielfigur f = new Spielfigur();
    protected boolean benutzt;
    protected boolean aktionVerfügbar = true; // <-- standardmäsig true nur bei Klasse KeineAktion wird dieser im Konstruktor auf false gesetzt

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

}
