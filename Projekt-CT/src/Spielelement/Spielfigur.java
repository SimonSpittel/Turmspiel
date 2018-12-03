/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Simon.Spittel
 */
public class Spielfigur extends Spielelement {

    private ArrayList<Ausrüstung.Item> Items = new ArrayList<Ausrüstung.Item>();
    private int Sichtweite = 1;

    public void bewege(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
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
//        System.out.println("x:" + xPos);
//        System.out.println("y:" + yPos);
    }

    public Point pruefeBegehbarkeit(java.awt.event.KeyEvent evt) {
        int tempX = xPos;
        int tempY = yPos;
        Point p = new Point();
        switch (evt.getKeyCode()) {
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

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
    }

    public void AktualisiereAttribute() {
        Ausrüstung.Item tempItem;
        for(int i = 0; i < Items.size(); i++){
            tempItem = Items.get(i);
            switch(tempItem.getArt()){
                case "L":
                        Sichtweite = 3;
                        break;
                case "S":
                        //-------------------
                        break;
                default: 
                        break;
                        
            }
        }
    }

    /**
     * @return the Sichtweite
     */
    public int getSichtweite() {
        return Sichtweite;
    }
    
    public void addItem(Ausrüstung.Item item){
        Items.add(item);
    }
    
    public void deleteItem(int ID){
        Ausrüstung.Item tempItem;
        for(int i = 0; i < Items.size(); i++){
            tempItem = Items.get(i);
            if(tempItem.getID() == ID){
                Items.remove(i);
            }
        }
    }
    
    //-----------------gibt alle IDs welche sich in dem Inventar befinden--------
    
    public int[] getIDs(){
        int[] IDs = new int[Items.size()];
        Ausrüstung.Item tempItem;
        for(int i = 0; i< Items.size(); i++){
            tempItem = Items.get(i);
            IDs[i] = tempItem.getID();
        }
        return IDs;
    }

}
