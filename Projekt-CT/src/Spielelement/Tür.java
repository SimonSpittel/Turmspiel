/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;

/**
 *
 * @author Simon.Spittel
 */
public class Tür extends Spielelement{
    
    public Tür(){
        Begehbarkeit = true;
    }


    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite/19;
        this.hoehe = hoehe/32;
       
        g.drawImage(grafik.getTür(), (2+xPos)*this.breite, (yPos+2)*this.hoehe, this.breite, this.hoehe, null);
    }
    
}
