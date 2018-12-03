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
public class ItemAblegen extends Aktion {
    private String Art;
    private int benötigteID;

    public ItemAblegen(int x, int y, int ID, String Art) {
        xPos = x;
        yPos = y;
        benötigteID = ID;
        this.Art = Art;
        aktionVerfügbar = true;

    }

    public void aktion() {    
        f.deleteItem(prüfeID(f.getIDs())); 
    }
    
    public int prüfeID(int[] ID){
        for(int i = 1; i < ID.length+1; i++){
            if(benötigteID == ID[i]){
                return i;
            }
        }
        return 0;
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.setColor(Color.CYAN);

        g.drawString("A", (2 + xPos) * this.breite, (yPos + 3) * this.hoehe);
    }

}
