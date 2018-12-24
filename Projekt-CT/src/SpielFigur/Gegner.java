/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpielFigur;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Simon.Spittel
 */
public abstract class Gegner {

    /**
     * @return the lebendig
     */
    public boolean isLebendig() {
        return lebendig;
    }

    protected int xPos;
    protected int yPos;

    protected int schaden;
    protected int breite;
    protected int hoehe;
    protected int Lebenspunkte = 20;
    private boolean lebendig = true;
    protected Spielelement.Spielelement[][][] SpielelementeEbene;
    protected Gegner[] gegner;
    protected SpielFigur.Spielfigur figur;
    protected int aktiveTurmseite;
    protected int animationsbild = 8;
    protected Random wuerfel = new Random();
    protected int Richtung = 1;
    protected Timer AttackeAnimation = new Timer(99, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

            animationsbild++;

            if (animationsbild == 9) {
                animationsbild = 0;
            }
        }
    });
    protected Timer SterbeAnimation = new Timer(99, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

            

            if (animationsbild == 6) {
                

                Bewege.stop();
                Attackiere.stop();
                SterbeAnimation.stop();
            }
            
            
            animationsbild++;
        }
    });
    protected Timer Bewege = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {            
            bewege();
                if (Lebenspunkte > 0) {
                    if (pruefeAufFeind() && !Attackiere.isRunning()) {
                        Attackiere.start();

                        Bewege.stop();
                    }
                } else {
                    lebendig = false;
                    animationsbild = 0;
                    SterbeAnimation.start();
                    Bewege.stop();
                }

            
        }
    });
    protected Timer Attackiere = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (Lebenspunkte > 0) {
                if (pruefeAufFeind()) {

                    if (!AttackeAnimation.isRunning()) {
                        AttackeAnimation.start();

                    }
                    figur.fügeSchadenZu(schaden);
                } else {
                    AttackeAnimation.stop();
                    Bewege.start();
                    Attackiere.stop();
                }
            } else {
                lebendig = false;
                AttackeAnimation.stop();
                animationsbild = 0;
                SterbeAnimation.start();

            }
        }
    });
    protected Grafiken.Grafiken grafik = new Grafiken.Grafiken();

    public void bewege() {
        berechneRichtung();
        switch (Richtung) {
            case 1:
                setxPos(getxPos() + 1);
                break;
            case 2:
                setyPos(getyPos() - 1);
                break;
            case 3:
                setxPos(getxPos() - 1);
                break;
            case 4:
                setyPos(getyPos() + 1);
                break;
            default:
                break;
        }
        if (getxPos() > 14) {
            setxPos(0);
            if (getAktiveTurmseite() == 3) {
                setAktiveTurmseite(0);
            } else {
                setAktiveTurmseite(getAktiveTurmseite() + 1);
            }
        } else if (getxPos() < 0) {
            setxPos(14);
            if (getAktiveTurmseite() == 0) {
                setAktiveTurmseite(3);
            } else {
                setAktiveTurmseite(getAktiveTurmseite() - 1);
            }
        }

    }

    public void berechneRichtung() {
        while (!pruefeNaechstenSchritt()) {
            switch (wuerfel.nextInt(2)) {
                case 0:
                    Richtung = 1;
                    break;
                case 1:
                    Richtung = 3;
                    break;
            }
        }

    }

    public boolean pruefeNaechstenSchritt() {
        
        int zdieRichtung = Richtung;
        int zposY = getyPos();
        int zposX = getxPos();
        int Turmseite = aktiveTurmseite;

        switch (zdieRichtung) {
            case 1:
                zposX++;
                break;
            case 2:
                zposY--;
                break;
            case 3:
                zposX--;
                break;
            case 4:
                zposY++;
                break;
            default:
                break;
        }
        if (zposX < 0) {
            zposX = 14;
            if (Turmseite == 0) {
                Turmseite = 3;
            } else {
                Turmseite = (this.aktiveTurmseite - 1);
            }
        }
        if (zposX > 14) {
            zposX = 0;
            if (Turmseite == 3) {
                Turmseite = 0;
            } else {
                Turmseite = (this.aktiveTurmseite + 1);
            }
        }

        for (int i = 0; i < gegner.length; i++) {
            if (gegner[i].getxPos() == zposX && gegner[i].getyPos() == zposY ) {
                return false;
            }
        }
        
        if(zposY == figur.getyPos() && zposX == figur.getxPos()){
            return false;
        }
        if (!SpielelementeEbene[Turmseite][zposY][zposX].isBegehbarkeit()) {
            return false;
        }
        return true;

    }

    public boolean pruefeAufFeind() {
        if ((getxPos() + 1 == figur.getxPos() && getyPos() == figur.getyPos()) || (getxPos() - 1 == figur.getxPos() && getyPos() == figur.getyPos())) {

            return true;
        } else {
            return false;
        }

    }

    public void BewegeStart() {
        Bewege.start();
    }

    public abstract void zeichne(Graphics g, int hoehe, int breite);

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setSpielelementeEbene(Spielelement.Spielelement[][][] SpielelementeEbene) {
        this.SpielelementeEbene = SpielelementeEbene;
    }

    public void setGegner(Gegner[] gegner) {
        this.gegner = gegner;
    }

    public void setFigur(SpielFigur.Spielfigur figur) {
        this.figur = figur;
    }

    public void setAktiveTurmseite(int aktiveTurmseite) {
        this.aktiveTurmseite = aktiveTurmseite;
    }

    public int getAktiveTurmseite() {
        return aktiveTurmseite;
    }

    public void fügeSchadenZu(int schaden) {
        Lebenspunkte = Lebenspunkte - schaden;
        System.out.println("Leben-Gegner: " + Lebenspunkte);
    }

}
