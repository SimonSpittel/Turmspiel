/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpielFigur;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Simon.Spittel
 */
public class Minotaurus extends Gegner {

    public Minotaurus(int x, int y, int Turmseite) {
        xPos = x;
        yPos = y;
        schaden = wuerfel.nextInt(16) + 5;
        aktiveTurmseite = Turmseite;

    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
          
        if((getxPos() + 1 == figur.getxPos() && getyPos() == figur.getyPos()) && Attackiere.isRunning()){
            g.drawImage(grafik.getMinotaur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (890/9) * animationsbild,(1920/20)*3 , (890/9) * (animationsbild + 1), (1920/20)*4, null);
        }else if((getxPos() - 1 == figur.getyPos() && getyPos() == figur.getyPos()) && Attackiere.isRunning()){
            g.drawImage(grafik.getMinotaur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (890/9) * animationsbild,(1920/20)*13 , (890/9) * (animationsbild + 1), (1920/20)*14, null);
        }else{
            g.drawImage(grafik.getMinotaur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, 0,0 , (890/9) , (1920/20), null);
        }
        
        
        

    }

}
