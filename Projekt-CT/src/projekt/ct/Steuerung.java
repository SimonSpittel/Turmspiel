/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Simon Spittel
 */
public class Steuerung {
    //--------------------------------------------Allgemeine Atribute------------------------------

    private Oberflaeche o;
    private int Intervall = 500;
    private Levels.LoadLevel loadLevel = new Levels.LoadLevel();

    //------------------------------------------------AktionsEbene--------------------------------- 
    private Aktionen.Aktion[][][] AktionsEbene;   //<-- [1] gibt Turmseite; [2] gibt Höhe im Turm;  [3] gibt breite im Turm
    private int aktiveTurmseite = 0;

    //--------------------------------------------SpielelementeEbene-------------------------------- 
    private Spielelement.Spielelement[][][] SpielelementeEbene; // <--- muss später aus Klasse Level geladen werden somit Array [][][][] erstes gibt die turmseite an um so auch wechseln zu können
    private SpielFigur.Spielfigur figur;                                  // <-- nur zum test
    private SpielFigur.Minotaurus[] Gegner = new SpielFigur.Minotaurus[2];
    //------------------------------------ItemEbene----------------------------
    private Ausrüstung.Item[][][] ItemEbene;

    //-----------------------------------------------EndeAtribute-----------------------------------
    public Steuerung(Oberflaeche o) {
        this.o = o;

        initSpielelemente();

    }

    private void initSpielelemente() {
        AktionsEbene = loadLevel.getAktionsEbenen();
        SpielelementeEbene = loadLevel.getSpielEbenen();
        ItemEbene = loadLevel.getItemEbene();
        figur = new SpielFigur.Spielfigur(ItemEbene, aktiveTurmseite);

//        for (int i = 0; i < Minotaurus.length; i++) {
//            Minotaurus[i] = new Minotaurus(derPacMan);    
//        }
        Gegner[0] = new SpielFigur.Minotaurus(2, 28, aktiveTurmseite);
        Gegner[1] = new SpielFigur.Minotaurus(2, 26, aktiveTurmseite);

        SpielFigur.Gegner[] m = new SpielFigur.Minotaurus[1];
        int k = 0;
        for (int s = 0; s < Gegner.length; s++) {
            k = 0;
            for (int i = 0; i < Gegner.length; i++) {

                if (s == i) {
                    i++;
                }

                if (i != Gegner.length) {

                    m[k] = Gegner[i];
                }
                k++;

            }
            Gegner[s].setGegner(m);
        }

        for (int i = 0; AktionsEbene.length > i; i++) {
            for (int v = 0; AktionsEbene[i].length > v; v++) {        //  v  <--- Durchlaufvariable für die Turmhöhe
                for (int h = 0; AktionsEbene[i][v].length > h; h++) { //  h  <--- Durchlaufvariable für die Turmbreite    
                    AktionsEbene[i][v][h].setF(figur);
                    AktionsEbene[i][v][h].setS(this);
                }
            }
        }

        figur.setxPos(7);
        figur.setyPos(29);

        for (int i = 0; Gegner.length > i; i++) {
            Gegner[i].setSpielelementeEbene(SpielelementeEbene);
            Gegner[i].setFigur(figur);
            Gegner[i].BewegeStart();
        }

    }

    public void zeichneSpielElemente(Graphics g, int breite, int hoehe) {

        for (int v = 0; SpielelementeEbene[aktiveTurmseite].length > v; v++) {        //  v  <--- Durchlaufvariable für die Turmhöhe
            for (int h = 0; SpielelementeEbene[aktiveTurmseite][v].length > h; h++) { //  h  <--- Durchlaufvariable für die Turmbreite 

//-----------------------------------------dient um die Sichtweite der Spielfigur einzugrenzen ---------------------------
                if (h < figur.getxPos() - figur.getSichtweite() || h > figur.getxPos() + figur.getSichtweite() || v < figur.getyPos() - figur.getSichtweite() || v > figur.getyPos() + figur.getSichtweite()) {
                    //SpielelementeEbene[aktiveTurmseite][v][h].zeichneUnseen(g, breite, hoehe);
                    SpielelementeEbene[aktiveTurmseite][v][h].zeichne(g, breite, hoehe);
                    ItemEbene[aktiveTurmseite][v][h].zeichne(g, breite, hoehe);

                } else {

                    SpielelementeEbene[aktiveTurmseite][v][h].zeichne(g, breite, hoehe);
                    ItemEbene[aktiveTurmseite][v][h].zeichne(g, breite, hoehe);

                }
            }
        }
        //------------------------------------------------Darstellen der Items an der Wand----------------------------------------------
//        for (int v = 0; ItemEbene[aktiveTurmseite].length > v; v++) {        //  v  <--- Durchlaufvariable für die Turmhöhe
//            for (int h = 0; ItemEbene[aktiveTurmseite][v].length > h; h++) { //  h  <--- Durchlaufvariable für die Turmbreite    
//                ItemEbene[aktiveTurmseite][v][h].zeichne(g, breite, hoehe);
//            }
//        }

        //------------------------------------------dient zum darstellen der Aktionseben um zu überprüfen----------------------------
        for (int v = 0; AktionsEbene[aktiveTurmseite].length > v; v++) {        //  v  <--- Durchlaufvariable für die Turmhöhe
            for (int h = 0; AktionsEbene[aktiveTurmseite][v].length > h; h++) { //  h  <--- Durchlaufvariable für die Turmbreite    
                AktionsEbene[aktiveTurmseite][v][h].zeichne(g, breite, hoehe);
            }
        }

        //-----------------Zeichne Figur----------------------
        figur.zeichne(g, breite, hoehe);
        figur.zeichneInventar(g, breite, hoehe);

        //-----------Zeichne Gegner------------
        for (int i = 0; Gegner.length > i; i++) {
            Gegner[i].zeichne(g, breite, hoehe);
        }

    }

    //--------------------reagiert auf tastendruck zum Bewegen---------------------
    public void verarbeiteTastendruck(java.awt.event.KeyEvent evt) {

        Point p = figur.pruefeBegehbarkeit(evt, aktiveTurmseite);
        int akT = figur.getAktiveTurmseite();

        if (SpielelementeEbene[akT][p.y][p.x].isBegehbarkeit()) {   //<---- prüft ob nächstes Feld begehbar ist oder nicht
            aktiveTurmseite = figur.bewege(evt, aktiveTurmseite);

            //----------------------Falls falle vorhanden wird sie ausgelöst-----------------
            if (figur.getxPos() != 0 && figur.getxPos() != 14 && figur.getyPos() != 0 && figur.getyPos() != 29) {
                if (AktionsEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos() + 1].isFalle()) {
                    AktionsEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos() + 1].aktion();
                }
                if (AktionsEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos() - 1].isFalle()) {
                    AktionsEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos() - 1].aktion();
                }
                if (AktionsEbene[aktiveTurmseite][figur.getyPos() + 1][figur.getxPos()].isFalle()) {
                    AktionsEbene[aktiveTurmseite][figur.getyPos() + 1][figur.getxPos()].aktion();
                }
                if (AktionsEbene[aktiveTurmseite][figur.getyPos() - 1][figur.getxPos()].isFalle()) {
                    AktionsEbene[aktiveTurmseite][figur.getyPos() - 1][figur.getxPos()].aktion();
                }
            }
            //----------------------------------------------------------------------------
        }
        o.repaint();
    }

    //----------------prüft bei betreten eines Feldes oder bei Auswahl ob Aktion vorliegt----------------------
    private boolean pruefeAufAktion(int x, int y) {

        return AktionsEbene[aktiveTurmseite][y][x].getAktionVerfügbar();

    }
    //----------------reagiert auf taste um gewollte Aktion auszulösen-------- 

    public void verarbeiteAktionstaste() {
        if (pruefeAufAktion(figur.getxPos(), figur.getyPos())) {
            AktionsEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].aktion();
            figur.setAktiveTurmseite(aktiveTurmseite);
            o.repaint();
        }

        figur.AktualisiereAttribute();

        switch (ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getArt()) {
            case "S":
                figur.addItem(ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getItem());
                ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()] = new Ausrüstung.KeinItem(figur.getxPos(), figur.getyPos());
                break;
            case "F":
                figur.pruefeAufFackel();
                figur.addItem(ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getItem());
                ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()] = new Ausrüstung.KeinItem(figur.getxPos(), figur.getyPos());
                break;
            case "T":
                ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].setFigurID(figur.getIDs());
                if (ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getItem() != null) {
                    figur.addItem(ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getItem());
                    figur.deleteItem(ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getID());
                }
                break;
            case "L":
                figur.pruefeAufLaterne();
                figur.pruefeAufFackel();
                figur.addItem(ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()].getItem());
                ItemEbene[aktiveTurmseite][figur.getyPos()][figur.getxPos()] = new Ausrüstung.KeinItem(figur.getxPos(), figur.getyPos());
                break;
            case "K":
                break;
            default:
                break;

        }
    }

    public void verarbeiteInventarTaste(int platz) {
        figur.setAktiverInventarplatz(platz);
    }

    public void setAktiveTurmseite(int aktiveTurmseite) {
        this.aktiveTurmseite = aktiveTurmseite;
    }

}
