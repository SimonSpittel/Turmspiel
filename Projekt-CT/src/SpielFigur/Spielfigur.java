/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpielFigur;

import Spielelement.Spielelement;
import java.awt.Color;
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

    private Ausrüstung.Item[][][] ItemEbene = new Ausrüstung.Item[4][30][15];
    private ArrayList<Ausrüstung.Item> Items = new ArrayList<Ausrüstung.Item>();
    private int Sichtweite = 1;
    private Timer refresh;
    private boolean leuchtmittel = false;
    private int aktiverInventarplatz = 1;

    private int Lebenspunkte = 100;

    public Spielfigur(Ausrüstung.Item[][][] ItemEbene) {
        this.ItemEbene = ItemEbene;
        refresh = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AktualisiereAttribute();
            }
        });
        refresh.start();

    }

    public void bewege(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                yPos--;
                break;
            case KeyEvent.VK_DOWN:
                yPos++;
                break;

            case KeyEvent.VK_LEFT:
                xPos--;
                break;

            case KeyEvent.VK_RIGHT:
                xPos++;
                break;

        }
//        System.out.println("x:" + xPos);
//        System.out.println("y:" + yPos);
    }

    public Point pruefeBegehbarkeit(java.awt.event.KeyEvent evt) {
        int tempX = xPos;
        int tempY = yPos;
        Point p = new Point();
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                tempY--;
                break;
            case KeyEvent.VK_DOWN:
                tempY++;
                break;
            case KeyEvent.VK_LEFT:
                tempX--;
                break;
            case KeyEvent.VK_RIGHT:
                tempX++;
                break;
            default:
                break;
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
        g.drawImage(grafik.getFigur(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, (3 + xPos) * this.breite, (yPos + 3) * this.hoehe, 0, 0, 32, 32, null);
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

    /**
     * @return the Sichtweite
     */
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

    /**
     * @param ItemEbene the ItemEbene to set
     */
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

    /**
     * @param aktiverInventarplatz the aktiverInventarplatz to set
     */
    public void setAktiverInventarplatz(int aktiverInventarplatz) {
        this.aktiverInventarplatz = aktiverInventarplatz;
    }

}
