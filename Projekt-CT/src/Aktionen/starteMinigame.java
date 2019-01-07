/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Simon Spittel
 */
public class starteMinigame extends Aktion {
    private MiniGame.MGFrame mgF;
    
    public starteMinigame(int x, int y) {
        xPos = x;
        yPos = y;
        aktionVerfügbar = true;
        mgF = new MiniGame.MGFrame();
        
    }

    public void aktion() {

    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.setColor(Color.CYAN);
        g.drawString("S", (2 + xPos) * this.breite, (yPos + 3) * this.hoehe);
    }

}
