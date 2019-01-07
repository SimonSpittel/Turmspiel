/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wurmspiel;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 *
 * @author noah.hauke
 */
public class Wurm {

    private int aLaenge = 4;
    public int aRichtung = KeyEvent.VK_RIGHT ;
    public Wurmzelle[] wurm = new Wurmzelle[10];
    private Graphics g;

    public Wurm() {

    }

    public void intitialiesiereWurm() {
        for (int i = 0; i < aLaenge; i++) {
            wurm[i] = new Wurmzelle(0, i);
        }
        wurm[9]= new Wurmzelle (100,100);
    }

    public boolean liegtAufWurm(int px, int py) {
        for (int i = 0; i < aLaenge; i++) {
            if (wurm[i].hatGleicheXY(px, py)) {
                return true;
            }
        }
        return false;
    }
    public void setKopfPos(int x,int y){
        wurm[0].setPos(x,y);
    }
    public Point getKopfPos() {
        return wurm[0].getPos();
    }

    public void setzeRichtung(int pRichtung) {
        aRichtung = pRichtung;
    }

    public void krieche() {
        for (int i = aLaenge - 1 ; i > 0; i--) {
            wurm[i].pos.x = wurm[i - 1].pos.x;
            wurm[i].pos.y = wurm[i - 1].pos.y;
        }
        switch (this.aRichtung) {
            case KeyEvent.VK_DOWN:  
                wurm[0].pos.y += 1;
                break;

            case KeyEvent.VK_UP:
                wurm[0].pos.y -= 1;
                break;

            case KeyEvent.VK_RIGHT:
                wurm[0].pos.x += 1;
                break;

            case KeyEvent.VK_LEFT:
                wurm[0].pos.x -= 1;
                break;

        }
    }

    public void zeichneWurm(Graphics g) {
        this.g = g;
        for (int i = 0; i < aLaenge; i++) {
            wurm[i].zeichne(g);
        }

    }

    public void setaLaenge(int aLaenge) {
        this.aLaenge = aLaenge;
    }
    public boolean WurmKO(int pX, int pY){
        for (int i = 1; i < aLaenge; i++) {
            if (wurm[i].hatGleicheXY(pX, pY)) {
                return true;
            }
        }
        return false;
        
    }
    public boolean pruefeGewonnen(){
        if(wurm[9].pos.x != 100 ||wurm[9].pos.y != 100 ){
            return true;
        }return false;
    }

    public void wachse() {
            wurm[aLaenge] =new Wurmzelle(0,0);
            aLaenge++;
            
    }
}