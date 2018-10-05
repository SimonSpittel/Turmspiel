/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.image.BufferedImage;

/**
 *
 * @author Simon.Spittel
 */
public abstract class Spielelement {
    protected BufferedImage alleBilder[];
    private int xPos;
    private int yPos;
    
    public abstract void berechneBilder();
    
    public abstract void zeichne();


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
    
    
}
