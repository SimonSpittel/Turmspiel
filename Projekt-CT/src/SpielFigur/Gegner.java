/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpielFigur;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Simon.Spittel
 */
public abstract class Gegner {


    protected int xPos;
    protected int yPos;
    protected int Richtung;
    protected int schaden;
    protected Spielelement.Spielelement[][][] SpielelementeEbene;
    protected Gegner[] gegner;
    protected SpielFigur.Spielfigur figur;
    protected int aktiveTurmseite;
    protected Random wuerfel = new Random();
    protected Timer AttackeAnimation;

    public void bewege() {

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

//        if(getxPos() > 14 || getyPos() > 8 || getxPos() < 0 || getyPos() < 0){
//            switch(Richtung){
//                case 1: setxPos(getxPos() - 1);
//                        break;
//              case 2: setyPos(getyPos() + 1);
//                      break;
//               case 3: setxPos(getxPos() + 1);
//                       break;
//               case 4: setyPos(getyPos() - 1);
//                     break;
//                      default:break;
//        }
//        }
    }

    public void berechneRichtung() {
        while (!pruefeNaechstenSchritt()) {
            Richtung++;
            if (Richtung == 5) {
                Richtung = 1;
            }
        }

    }

    public boolean pruefeNaechstenSchritt() {
        int zdieRichtung = Richtung;
        int zposY = getyPos();
        int zposX = getxPos();

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

        for (int i = 0; i < gegner.length; i++) {
            if (gegner[i].getxPos() == zposX && gegner[i].getyPos() == zposY) {
                return false;
            }
        }
        if (!SpielelementeEbene[aktiveTurmseite][zposY][zposX].isBegehbarkeit()) {
            return false;
        }
        return true;

    }

    public boolean pruefeAufFeind() {
        if ((getxPos() + 1 == figur.getxPos() && getyPos() == figur.getyPos()) || (getxPos() - 1 == figur.getyPos() && getyPos() == figur.getyPos()) || (getyPos() + 1 == figur.getyPos() && getxPos() == figur.getxPos()) || (getyPos() - 1 == figur.getyPos() && getxPos() == figur.getxPos())) {
            return true;
        }else{
            return false;
        }
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
