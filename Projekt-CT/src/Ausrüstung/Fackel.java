/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ausrüstung;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Simon Spittel
 */
public class Fackel extends Item {

    private Timer Lebensdauer;
    private Timer animation;
    private int animationsbild = 0;

    private int Brenndauer;

    public Fackel(int x, int y) {
        Random wuerfel = new Random();
        Brenndauer = wuerfel.nextInt(10);
        xPos = x;
        yPos = y;
        brennt = true;
        Art = "F";
        animation = new Timer(99, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                animationsbild++;
                if (animationsbild == 4) {
                    animationsbild = 0;
                }
            }
        });
        animation.start();
        Lebensdauer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (Brenndauer <= 0) {
                    brennt = false;
                    Lebensdauer.stop();
                } else {
                    Brenndauer--;
                }
                System.out.println(Brenndauer);
            }
        });

    }

    public Item getItem() {
//        Lebensdauer.start();
        return this;
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        switch (animationsbild) {
            case 0:
                g.drawImage(grafik.getFackel1(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 1:
                g.drawImage(grafik.getFackel2(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 2:
                g.drawImage(grafik.getFackel3(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;
            case 3:
                g.drawImage(grafik.getFackel4(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
                break;

        }
    }

    @Override
    public void zeichneInventarIcon(Graphics g, int hoehe, int breite, int Inventarstelle) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;

        if (Lebensdauer.isRunning()) {
            switch (animationsbild) {
                case 0:
                    g.drawImage(grafik.getFackel1(), ((17) * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
                    break;
                case 1:
                    g.drawImage(grafik.getFackel2(), ((17) * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
                    break;
                case 2:
                    g.drawImage(grafik.getFackel3(), ((17) * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
                    break;
                case 3:
                    g.drawImage(grafik.getFackel4(), ((17) * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
                    break;

            }
        } else {
            g.drawImage(grafik.getFackel0(), ((17) * this.breite) + (this.breite / 2), (Inventarstelle + 2) * this.hoehe, this.breite, this.hoehe, null);
        }
    }

    @Override
    public void nutzen() {
        Lebensdauer.start();
    }

    @Override
    public void inaktiv() {
        Lebensdauer.stop();
    }

}
