/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Simon Spittel
 */
public class LoadLevel {
    private FileReader fr;
    private BufferedReader br;
    private Aktionen.Aktion[][][] AktionsEbene = new Aktionen.Aktion[4][30][15];
    private Spielelement.Spielelement [][][] SpielEbene = new Spielelement.Spielelement[4][30][15];
    public Levels.Level Level = new Levels.Level();
    
    public LoadLevel(){
        Level.loadAktionLvlTurmseite(0);
        Level.loadAktionLvlTurmseite(1);
        Level.loadAktionLvlTurmseite(2);
        Level.loadAktionLvlTurmseite(3);
        Level.loadSpielElementLvlTurmseite(0);
        Level.loadSpielElementLvlTurmseite(1);
        Level.loadSpielElementLvlTurmseite(2);
        Level.loadSpielElementLvlTurmseite(3);
        SpielEbene = Level.getSpielEbene();
        AktionsEbene = Level.getAktionsEbene();
    }

      

    /**
     * @return the AktionsEbene
     */
    public Aktionen.Aktion[][][] getAktionsEbene() {
        return AktionsEbene;
    }

    /**
     * @return the SpielEbene
     */
    public Spielelement.Spielelement[][][] getSpielEbene() {
        return SpielEbene;
    }
    
}
