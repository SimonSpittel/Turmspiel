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
public class schlüsselAufheben extends Aktion {


    public void aktion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public schlüsselAufheben(int x, int y){
        xPos = x;
        yPos = y;
        aktionVerfügbar = true;    
    }
   
//    public void aktion(){
//        f.setSchlüssel = true;        //<--- schlüssel muss noch als Ausrüstung erstellt werden
//    }
    

    
}
