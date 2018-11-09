/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

import java.awt.Graphics;

/**
 *
 * @author Simon Spittel
 */
public class Steuerung {
    //--------------------------------------------Allgemeine Atribute------------------------------
    
    
    private Oberflaeche o;
    private int Intervall =500;
    //------------------------------------------------AktionsEbene--------------------------------- 
    
    private Aktionen.Aktion[][] AktionsEbene = new Aktionen.Aktion[30][15];
    private int aktiveTurmseite;
    
    //--------------------------------------------SpielelementeEbene-------------------------------- 
    
    private Spielelement.Spielelement [][]SpielelementeEbene = new Spielelement.Spielelement[30][15];
    private Spielelement.Spielfigur figur = new Spielelement.Spielfigur();
    

    //-----------------------------------------------EndeAtribute-----------------------------------
    
    public Steuerung(Oberflaeche o){
        this.o=o;
        
        initSpielelemente();
        
    }
    
    private void initSpielelemente(){
        figur.setxPos(0);
        figur.setyPos(0);
    }
    
    public void zeichneSpielElemente(Graphics g){
        figur.zeichne(g);
    }
    public void verarbeiteTastendruck(java.awt.event.KeyEvent evt){
        
        figur.bewege(evt);
        o.repaint();
    }
    
    private boolean pruefeAufAktion(int x, int y){
        return AktionsEbene[y][x].getAktionVerfügbar();
    }
    
    public void VerarbeiteAktionstaste(){
 //       if(pruefeAufAktion(f.getX, f.getY)){
 //           AktionsEbene[f.getY][f.getX].aktion();
 //       }
    }


    

}
