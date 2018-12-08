/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Simon.Spittel
 */
public abstract class Spielelement {

    protected boolean Begehbarkeit = true;
    protected int xPos;
    protected int yPos;
    protected int breite;
    protected int hoehe;
    protected Grafiken.Grafiken grafik = new Grafiken.Grafiken();

    public abstract void zeichne(Graphics g, int hoehe, int breite);

    public void zeichneUnseen(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.drawImage(grafik.getDark(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isBegehbarkeit() {
        return Begehbarkeit;
    }
}
