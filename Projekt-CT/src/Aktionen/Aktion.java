/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;




/**
 *
 * @author Simon Spittel
 */
public abstract class Aktion {
    protected int xPos;
    protected int yPos;
    private Spielelement.Spielfigur f = new Spielelement.Spielfigur();
    protected boolean benutzt;
    protected boolean aktionVerfügbar = true; // <-- standardmäsig true nur bei Klasse KeineAktion wird dieser im Konstruktor auf false gesetzt
    
    //public abstract void aktion();

    public int getxPos() {
        return xPos;
    }

 
    public int getyPos() {
        return yPos;
    }
         

    public boolean isBenutzt() {
        return benutzt;
    }            

    /**
     * @return the aktionVerfügbar
     */
    public boolean getAktionVerfügbar() {
        return aktionVerfügbar;
    }

    /**
     * @param f the f to set
     */
    public void setF(Spielelement.Spielfigur f) {
        this.f = f;
    }
    
    
}
