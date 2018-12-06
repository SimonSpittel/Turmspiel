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
public abstract class Item implements Comparable<Item> {

    protected int ID; //---------------Spezifiziert nummer des Items
    protected String Art;  //-----------gibt an um welche art von Item es sich handelt
    protected Grafiken.Grafiken grafik = new Grafiken.Grafiken();
    protected boolean brennt = false;
    protected int breite;
    protected int hoehe;
    protected int[] FigurID;

    //---------Falls abgelegt geben Attribute ablage Standort an-------------
    protected int xPos;
    protected int yPos;

    public abstract void zeichne(Graphics g, int hoehe, int breite);

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    public Item getItem() {
        return this;
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

    /**
     * @return the brennt
     */
    public boolean isBrennt() {
        return brennt;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @param FigurID the FigurID to set
     */
    public void setFigurID(int[] FigurID) {
        this.FigurID = FigurID;
    }

    @Override
    public int compareTo(Item o) {
        return this.Art.compareTo(o.getArt());
    }

    public abstract void zeichneInventarIcon(Graphics g, int hoehe, int breite, int Inventarstelle);

    public abstract void nutzen();

    public abstract void inaktiv();

}
