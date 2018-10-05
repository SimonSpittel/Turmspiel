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
    private Aktionen.Aktion[][] AktionsEbene1 = new Aktionen.Aktion[30][15];
    private Aktionen.Aktion[][] AktionsEbene2 = new Aktionen.Aktion[30][15];
    private Aktionen.Aktion[][] AktionsEbene3 = new Aktionen.Aktion[30][15];
    private Aktionen.Aktion[][] AktionsEbene4 = new Aktionen.Aktion[30][15];
    
    public void LoadAktionLevel(int level) throws FileNotFoundException, IOException{
        fr = new FileReader(level+".Aktionslayout.txt");
        br = new BufferedReader(fr);
        int Turmseite = 1;
        
        String zeile;
        
        for(int i = 0; i <= 1800; i++){
            zeile = br.readLine();
            if("".equals(zeile)){
                Turmseite++;
            }else{
                switch(zeile){
                    // <-- je nach text in Zeile wird aktionsebene Gefüllt
                }
            }
        }
        
        
    }
    
}
