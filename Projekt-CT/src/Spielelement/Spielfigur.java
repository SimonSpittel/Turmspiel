/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;
import java.awt.event.KeyEvent;



/**
 *
 * @author Simon.Spittel
 */
public class Spielfigur extends Spielelement{
    
    @Override
    public void berechneBilder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zeichne(Graphics g) {
        System.out.print("F");
    }
    
    public void bewege(java.awt.event.KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_UP :
                
                break;
            case KeyEvent.VK_DOWN:
                break;
                
            case KeyEvent.VK_LEFT:
                break;
                
            case KeyEvent.VK_RIGHT:
                break;
                
        }
    }
    
    
    private boolean pruefeBegehbarkeit(String Richtung){
        int tempX = xPos;
        int tempY = yPos;
        switch(Richtung){
            case "Hoch":
                tempY--;
                break;
            case "Runter":
                tempY++;
                break;
            case "Links":
                tempX--;
                break;
            case "Rechts":
                tempX++;
                break;
            default: 
                break;               
        }
        
        
        return true;
    }
    
    
    
}
