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
public class Mauer extends Spielelement {
    
    public Mauer(){
        Begehbarkeit = false;
    }
    



    @Override
    public void zeichne(Graphics g) {
        System.out.print("M");
    }
    
}
