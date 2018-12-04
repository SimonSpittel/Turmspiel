/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Simon.Spittel
 */
public class Spielfigur extends Spielelement {
    
    private Ausrüstung.Item[][][] ItemEbene = new Ausrüstung.Item[4][30][15];
    private ArrayList<Ausrüstung.Item> Items = new ArrayList<Ausrüstung.Item>();
    private int Sichtweite = 1;
    private Timer refresh;
    private boolean leuchtmittel = false;
    
    public Spielfigur(Ausrüstung.Item[][][] ItemEbene){
        this.ItemEbene = ItemEbene;
        refresh = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AktualisiereAttribute();
            }
        });
        refresh.start();
    }

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
                        if(Sichtweite < 3){
                            Sichtweite = 3;
                            
                        }
                        break;
                case "F":
                        if(tempItem.isBrennt()){
                            Sichtweite = 2;                            
                        }else{
                            Sichtweite = 1;
                        }                      
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
        System.out.println(Items.size());
        System.out.println(item.getArt());
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

    /**
     * @param ItemEbene the ItemEbene to set
     */
    public void setItemEbene(Ausrüstung.Item[][][] ItemEbene) {
        this.ItemEbene = ItemEbene;
    }
       
    public void pruefeAufFackel(){
        Ausrüstung.Item tempItem;
        for(int i = 0; i < Items.size(); i++){
            tempItem = Items.get(i);
            if(tempItem.getArt() == "F"){
                Items.remove(i);
            }
        }
    }
    
    public void pruefeAufLaterne(){
        Ausrüstung.Item tempItem;
        for(int i = 0; i < Items.size(); i++){
            tempItem = Items.get(i);
            if(tempItem.getArt() == "L"){
                Items.remove(i);
            }
        }
    }
    
    

}
