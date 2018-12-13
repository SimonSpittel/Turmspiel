/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpielFigur;

import Spielelement.Spielelement;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Timer;

/**
 *
 * @author Simon.Spittel
 */
public class Spielfigur extends Spielelement {

    public void setAktiveTurmseite(int aktiveTurmseite) {
        this.aktiveTurmseite = aktiveTurmseite;
    }

    public int getAktiveTurmseite() {
        return aktiveTurmseite;
    }

    private Ausrüstung.Item[][][] ItemEbene = new Ausrüstung.Item[4][30][15];
    private ArrayList<Ausrüstung.Item> Items = new ArrayList<Ausrüstung.Item>();
    private int Sichtweite = 1;
    private Timer refresh;
    private boolean leuchtmittel = false;
    private int aktiverInventarplatz = 1;
    private int aktiveTurmseite;
    private int animationsbild = 0;
    private Timer AttackeAnimation = new Timer(99, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            animationsbild++;
            if (animationsbild == 8) {
                animationsbild = 0;
                BewegeAnimation.start();
                AttackeAnimation.stop();

            }
        }
    });
    private Timer BewegeAnimation = new Timer(99, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

            animationsbild++;
            if (animationsbild == 4) {
                animationsbild = 0;
            }

        }
    });
    private int Richtung;
    private int schaden = 1;

    private int Lebenspunkte = 100;

    public Spielfigur(Ausrüstung.Item[][][] ItemEbene, int Turmseite) {
        this.ItemEbene = ItemEbene;
        refresh = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AktualisiereAttribute();
            }
        });
        refresh.start();
        aktiveTurmseite = Turmseite;
        BewegeAnimation.start();

    }

    public int bewege(java.awt.event.KeyEvent evt, int aktiveTurmseite) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                yPos--;

                break;
            case KeyEvent.VK_DOWN:
                yPos++;

                break;

            case KeyEvent.VK_LEFT:
                xPos--;
                Richtung = 3;
                break;

            case KeyEvent.VK_RIGHT:
                xPos++;
                Richtung = 4;
                break;

        }
        if (getxPos() > 14) {
            setxPos(0);
            if (aktiveTurmseite == 3) {
                return 0;
            } else {
                return (aktiveTurmseite + 1);
            }
        } else if (getxPos() < 0) {
            setxPos(14);
            if (aktiveTurmseite == 0) {
                return 3;
            } else {
                return (aktiveTurmseite - 1);
            }
        } else {
            return aktiveTurmseite;
        }

//        System.out.println("x:" + xPos);
//        System.out.println("y:" + yPos);
    }

    public Point pruefeBegehbarkeit(java.awt.event.KeyEvent evt, int aktiveTurmseite) {
        int tempX = xPos;
        int tempY = yPos;
        this.setAktiveTurmseite(aktiveTurmseite);
        Point p = new Point();
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                tempY--;

                break;
            case KeyEvent.VK_DOWN:

                tempY++;
                break;
            case KeyEvent.VK_LEFT:
                Richtung = 3;
                tempX--;
                break;
            case KeyEvent.VK_RIGHT:
                Richtung = 4;
                tempX++;
                break;
            default:
                break;
        }
        if (tempX < 0) {
            tempX = 14;
            if (this.aktiveTurmseite == 0) {
                this.setAktiveTurmseite(3);
            } else {
                this.setAktiveTurmseite(this.aktiveTurmseite - 1);
            }
        }
        if (tempX > 14) {
            tempX = 0;
            if (this.aktiveTurmseite == 3) {
                this.setAktiveTurmseite(0);
            } else {
                this.setAktiveTurmseite(this.aktiveTurmseite + 1);
            }
        }

        p.x = tempX;
        p.y = tempY;

        return p;
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        //g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
        //g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, 0, 0, 32, 32, null);
        if (AttackeAnimation.isRunning()) {
            switch (Richtung) {
                case 4:
                    g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (258 / 8) * animationsbild, (320 / 10) * 2, (258 / 8) * (animationsbild + 1), (315 / 10) * 3, null);
                    break;
                case 3:
                    g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (258 / 8) * animationsbild, (320 / 10) * 7, (258 / 8) * (animationsbild + 1), (315 / 10) * 8, null);
                    break;
                default:
                    g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (258 / 8) * animationsbild, (320 / 10) * 7, (258 / 8) * (animationsbild + 1), (315 / 10) * 8, null);
                    break;
            }
        } else {
            switch (Richtung) {
                case 4:
                    g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (258 / 8) * animationsbild, (315 / 10) * 3, (258 / 8) * (animationsbild + 1), (315 / 10) * 4, null);
                    break;
                case 3:
                    g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (258 / 8) * animationsbild, (315 / 10) * 8, (258 / 8) * (animationsbild + 1), (315 / 10) * 9, null);
                    break;
                default:
                    g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, (258 / 8) * animationsbild, (315 / 10) * 8, (258 / 8) * (animationsbild + 1), (315 / 10) * 9, null);
                    break;    

            }

        }
        //-------------------------------Sichtbereich-------------------------
//            g.drawImage(grafik.getUnseen(), ((2 + xPos-Sichtweite) * this.breite), ((yPos + 2-Sichtweite) * this.hoehe), this.breite*(2*Sichtweite+1), this.hoehe*(2*Sichtweite+1), null);
//            g.drawOval( ((2 + xPos) * this.breite), ((yPos + 2) * this.hoehe),  this.breite,  this.hoehe);   

    }

    public void AktualisiereAttribute() {
        if (Items.size() != 0 && Items.size() > aktiverInventarplatz - 1) {
            switch (Items.get(aktiverInventarplatz - 1).getArt()) {
                case "L":
                    if (Sichtweite < 3) {
                        Sichtweite = 3;

                    }
                    break;
                case "F":
                    if (Items.get(aktiverInventarplatz - 1).isBrennt()) {
                        Items.get(aktiverInventarplatz - 1).nutzen();
                        Sichtweite = 2;
                    } else {
                        Sichtweite = 1;
                        Items.remove(aktiverInventarplatz - 1);
                    }
                    break;
                case "SCH":
                        schaden = 15;
                        break;
                default:
                    Sichtweite = 1;
                    break;

            }
        } else {
            Sichtweite = 1;

        }
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getArt() == "F" && i != aktiverInventarplatz - 1) {
                Items.get(i).inaktiv();

            }
        }
        pruefeAufAusgebrannteFackeln();

    }

    public int getSichtweite() {
        return Sichtweite;
    }

    public void addItem(Ausrüstung.Item item) {
        System.out.println(Items.size());
        System.out.println(item.getArt());
        Items.add(item);

    }

    public void deleteItem(int ID) {
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getID() == ID) {
                Items.remove(i);
            }
        }
    }

    public void pruefeAufAusgebrannteFackeln() {
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getArt() == "F") {
                if (!tempItem.isBrennt()) {
                    Items.remove(i);
                }
            }
        }
    }

    //-----------------gibt alle IDs welche sich in dem Inventar befinden--------
    public int[] getIDs() {
        int[] IDs = new int[Items.size()];
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            IDs[i] = tempItem.getID();
        }
        return IDs;
    }

    public void setItemEbene(Ausrüstung.Item[][][] ItemEbene) {
        this.ItemEbene = ItemEbene;
    }

    public void pruefeAufFackel() {
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getArt() == "F") {
                Items.remove(i);
            }
        }
    }

    public void pruefeAufLaterne() {
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getArt() == "L") {
                Items.remove(i);
            }
        }
    }

    public void pruefeAufSchwert() {
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getArt() == "SCH") {
                Items.remove(i);
            }
        }
    }

    public void pruefeAufZauberstab() {
        Ausrüstung.Item tempItem;
        for (int i = 0; i < Items.size(); i++) {
            tempItem = Items.get(i);
            if (tempItem.getArt() == "Z") {
                Items.remove(i);
            }
        }
    }

    public void sortiereInventar() {
        Collections.sort(Items);
    }

    public void fügeSchadenZu(int schaden) {
        Lebenspunkte = Lebenspunkte - schaden;
        System.out.println("Leben: " + Lebenspunkte);
    }

    public void zeichneInventar(Graphics g, int hoehe, int breite) {
        sortiereInventar();
        for (int i = 0; i < 10; i++) {
            g.drawImage(grafik.getInventarhintergrund(), (17 * (breite / 19)) + (breite / 48), (i + 2) * (hoehe / 32), breite / 19, hoehe / 32, null);
        }
        for (int i = 0; i < Items.size(); i++) {
            Items.get(i).zeichneInventarIcon(g, hoehe, breite, i);
        }

        g.drawImage(grafik.getCursor(), (17 * (breite / 19)) + (breite / 48), (aktiverInventarplatz + 1) * (hoehe / 32), breite / 19, hoehe / 32, null);
    }

    public void setAktiverInventarplatz(int aktiverInventarplatz) {
        this.aktiverInventarplatz = aktiverInventarplatz;
    }

    public Point attacke() {
        int tempX = xPos;
        int tempY = yPos;
        Point p = new Point();
        switch (Richtung) {
            case 1:
                tempY--;
                break;
            case 2:
                tempY++;
                break;
            case 3:
                tempX--;
                break;
            case 4:
                tempX++;
                break;

        }
        if (getxPos() > 14 || getxPos() < 0 || getyPos() < 0 || getyPos() > 29) {
            return null;
        } else {
            p.x = tempX;
            p.y = tempY;
            if (!AttackeAnimation.isRunning()) {

                BewegeAnimation.stop();
                animationsbild = 0;
                AttackeAnimation.start();
            } else {

                BewegeAnimation.stop();
                animationsbild = 0;
                AttackeAnimation.restart();
            }
            return p;
        }

    }

    public int getSchaden() {
        return schaden;
    }
}
