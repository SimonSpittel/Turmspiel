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

    protected int xPos;
    protected int yPos;

    protected int schaden;
    protected int breite;
    protected int hoehe;
    protected Spielelement.Spielelement[][][] SpielelementeEbene;
    protected Gegner[] gegner;
    protected SpielFigur.Spielfigur figur;
    protected int aktiveTurmseite;
    protected int animationsbild = 0;
    protected Random wuerfel = new Random();
    protected int Richtung = wuerfel.nextInt(4) + 1;
    protected Timer AttackeAnimation= new Timer(33, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            
            if(animationsbild < 9 ){
                animationsbild++;
            }else{
                animationsbild = 0;
            }
        }
    });
    protected Timer Bewege = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            bewege();
            if(pruefeAufFeind()){
                Attackiere.start();
            }
            Attackiere.stop(); 
            AttackeAnimation.stop();
            
        }
    });
    protected Timer Attackiere = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            AttackeAnimation.start();
            
        }
    });

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
            switch(wuerfel.nextInt(2)){
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
            if (gegner[i].getxPos() == zposX && gegner[i].getyPos() == zposY) {
                return false;
            }
        }
        if (!SpielelementeEbene[Turmseite][zposY][zposX].isBegehbarkeit()) {
            return false;
        }
        return true;

    }

    public boolean pruefeAufFeind() {
        if ((getxPos() + 1 == figur.getxPos() && getyPos() == figur.getyPos()) || (getxPos() - 1 == figur.getyPos() && getyPos() == figur.getyPos()) || (getyPos() + 1 == figur.getyPos() && getxPos() == figur.getxPos()) || (getyPos() - 1 == figur.getyPos() && getxPos() == figur.getxPos())) {
            Bewege.stop();
            return true;
        }else{
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

}
