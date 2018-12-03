/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ausrüstung;

/**
 *
 * @author Simon Spittel
 */
public abstract class Item {
    
    protected int ID ; //---------------Spzifiziert nummer des Items
    protected String Art;  //-----------gibt an um welche art von Item es sich handelt
    
    //---------Falls abgelegt geben Attribute ablage Standort an-------------
    private int xPos;
    private int yPos;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the Art
     */
    public String getArt() {
        return Art;
    }

    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }
    
    
    
    
}
