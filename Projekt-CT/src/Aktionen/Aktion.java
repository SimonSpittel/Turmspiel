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
    protected boolean benutzt;
    protected boolean aktionVerfügbar;
    
    public abstract void aktion();

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
    
    
}
