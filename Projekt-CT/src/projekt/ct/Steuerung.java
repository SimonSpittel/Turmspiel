/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

import java.awt.Graphics;

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
    private Spielelement.Spielelement[][][] SpielelementeEbene = new Spielelement.Spielelement[4][30][15]; // <--- muss später aus Klasse Level geladen werden somit Array [][][][] erstes gibt die turmseite an um so auch wechseln zu können
    private Spielelement.Spielfigur figur = new Spielelement.Spielfigur();                                   // <-- nur zum test

    //-----------------------------------------------EndeAtribute-----------------------------------
    public Steuerung(Oberflaeche o) {
        this.o = o;

        initSpielelemente();

    }

    private void initSpielelemente() {
        figur.setxPos(0);
        figur.setyPos(0);
        AktionsEbene = loadLevel.getAktionsEbene();
        SpielelementeEbene = loadLevel.getSpielEbene();

    }

    public void zeichneSpielElemente(Graphics g) {
        //figur.zeichne(g);
        System.out.println("-------------------------------------");
        for (int v = 0; SpielelementeEbene[aktiveTurmseite].length > v; v++) {        //  v  <--- Durchlaufvariable für die Turmhöhe
            for (int h = 0; SpielelementeEbene[aktiveTurmseite][v].length > h; h++) { //  h  <--- Durchlaufvariable für die Turmbreite    
                SpielelementeEbene[aktiveTurmseite][v][h].zeichne(g);
            }
            System.out.println("");
        }

    }

    //--------------------reagiert auf tastendruck zum Bewegen---------------------
    public void verarbeiteTastendruck(java.awt.event.KeyEvent evt) {
        if (figur.pruefeBegehbarkeit(evt).x < 15 && figur.pruefeBegehbarkeit(evt).y < 30 && figur.pruefeBegehbarkeit(evt).x >= 0 && figur.pruefeBegehbarkeit(evt).y >= 0) {   //<--- prüft ob Figur die Außenmase des Turms verlassen würde                                            // <--- prüft ob er die Turmmaße verlässt )
            if (SpielelementeEbene[aktiveTurmseite][figur.pruefeBegehbarkeit(evt).y][figur.pruefeBegehbarkeit(evt).x].isBegehbarkeit()) {   //<---- prüft ob nächstes Feld begehbar ist oder nicht
                figur.bewege(evt);
                if (figur.getxPos() == -1) {
                    figur.setxPos(30);
                    if (aktiveTurmseite == 0) {
                        aktiveTurmseite = 3;
                    } else {
                        aktiveTurmseite--;
                    }
                } else if (figur.getxPos() == 31) {
                    figur.setxPos(0);
                    if (aktiveTurmseite == 3) {
                        aktiveTurmseite = 0;
                    } else {
                        aktiveTurmseite++;
                    }
                }
            }
//            System.out.println(figur.getxPos()+" / "+ figur.getyPos()); //<--- nur zum test

        }
        o.repaint();
    }

    //----------------prüft bei betreten eines Feldes oder bei Auswahl ob Aktion vorliegt----------------------
    private boolean pruefeAufAktion(int x, int y) {
        return AktionsEbene[aktiveTurmseite][y][x].getAktionVerfügbar();
    }
    //----------------reagiert auf taste um gewollte Aktion auszulösen-------- 

    public void VerarbeiteAktionstaste() {
        //       if(pruefeAufAktion(f.getX, f.getY)){
        //           AktionsEbene[f.getY][f.getX].aktion();
        //       }
    }

}
