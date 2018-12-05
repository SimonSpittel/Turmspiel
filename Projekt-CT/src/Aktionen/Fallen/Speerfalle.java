/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen.Fallen;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Simon Spittel
 */
public class Speerfalle extends Falle {

    private Timer Countdown = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (auslößedauer == 0) {
                Schadensdauer.start();
                aktiv = true;
                Countdown.stop();
                animation.start();
            } else {
                //System.out.println("auslöße"+ auslößedauer);
                auslößedauer--;

            }
        }
    });
    private Timer Schadensdauer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (aktivDauer == 0) {

                aktiv = false;
                animation.stop();
                animationsbild = 0;
                auslößedauer = (wuerfel.nextInt(4) + 1);
                aktivDauer = (wuerfel.nextInt(3) + 1);
                Schadensdauer.stop();

            }
            if (xPos == f.getxPos() && yPos == f.getyPos()) {
                f.fügeSchadenZu(Schaden);
            }

            //System.out.println("aktivDauer"+ aktivDauer);
            aktivDauer--;

        }
    });
    private Timer animation = new Timer(99, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

            animationsbild++;
            if (animationsbild == 4) {
                animationsbild = 0;
            }
        }
    });
    private Random wuerfel = new Random();
    private int auslößedauer = (wuerfel.nextInt(4) + 1);
    private int aktivDauer = (wuerfel.nextInt(3) + 1);
    private int animationsbild = 0;

    public Speerfalle(int x, int y) {
        xPos = x;
        yPos = y;
        Falle = true;
        Schaden = 4;

    }

    public void aktion() {

        Countdown.start();

    }

    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.drawImage(grafik.getSpeerfalle(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, 25 * animationsbild, 0, 25 * (animationsbild + 1), 21, null);

    }

}
