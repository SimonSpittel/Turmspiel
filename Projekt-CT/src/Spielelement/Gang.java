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
public class Gang extends Spielelement {
    
    public Gang(){
        Begehbarkeit = true;
    }


    @Override
    public void zeichne(Graphics g) {
        System.out.print("1");
    }
    
}
     