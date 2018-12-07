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
        g.setColor(Color.red);
        g.fillRect((2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe);

    }

}
