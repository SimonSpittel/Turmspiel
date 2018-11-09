/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;



/**
 *
 * @author Simon.Spittel
 */
public class Spielfigur extends Spielelement{
    


    @Override
    public void zeichne(Graphics g) {
        System.out.print("F");
    }
    
    public void bewege(java.awt.event.KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_UP :
                yPos--;
                break;
            case KeyEvent.VK_DOWN:
                yPos++;
                break;
                
            case KeyEvent.VK_LEFT:
                xPos--;
                break;
                
            case KeyEvent.VK_RIGHT:
                xPos++;
                break;
                
        }
    }
    
    
    public Point pruefeBegehbarkeit(java.awt.event.KeyEvent evt){
        int tempX = xPos;
        int tempY = yPos;
        Point p = new Point();
        switch(evt.getKeyCode()){
            case KeyEvent.VK_UP:
                tempY--;
                break;
            case KeyEvent.VK_DOWN:
                tempY++;
                break;
            case KeyEvent.VK_LEFT:
                tempX--;
                break;
            case KeyEvent.VK_RIGHT:
                tempX++;
                break;
            default: 
                break;               
        }
        p.x = tempX;
        p.y = tempY;
        
        return p;
    }
    
    
    
}
