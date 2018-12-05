/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spielelement;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Simon.Spittel
 */
public class Mauer extends Spielelement {

    private Random wuerfel = new Random();
    private int var = wuerfel.nextInt(5);

    public Mauer(int x, int y) {
        xPos = x;
        yPos = y;
        Begehbarkeit = false;
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;

        //----------------------------Abwechslung der Mauertexturen + Mauer mit Grasnabe Ganz unten-----------------------------------
        switch (var) {
            case 0:
                g.drawImage(grafik.getMauer1(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 1:
                g.drawImage(grafik.getMauer2(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 2:
                g.drawImage(grafik.getMauer3(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 3:
                g.drawImage(grafik.getMauer4(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 4:
                g.drawImage(grafik.getMauer5(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;

        }
    }

}
