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

    
    public void LoadAktionLevel(int level) throws FileNotFoundException, IOException{
        fr = new FileReader(level+".Aktionslayout.txt");
        br = new BufferedReader(fr);
        
        
        String zeile;
        
//        for(int i = 0; i <= 1800; i++){
//            zeile = br.readLine();
//            if("".equals(zeile)){
//                Turmseite++;
//            }else{
//                switch(Integer.parseInt(zeile)){
//                    case 0:
//                            break;
//                    // <-- je nach text in Zeile wird aktionsebene Gefüllt
//                }
//            }
//        }
        for(int Turmseite = 0; Turmseite <= AktionsEbene.length; Turmseite++){
            for(int h = 0; h <= AktionsEbene[Turmseite].length; h++){
                for(int b = 0; b <= AktionsEbene[Turmseite][h].length; b++){
                    zeile = br.readLine();
                    switch(Integer.parseInt(zeile)){
                        case 0:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.KeineAktion();
                            break;
                        case 1:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.schlüsselAblegen();
                            break;
                        case 2:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.schlüsselAufheben();
                            break;
                        case 3:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.starteMinigame();
                            break;
                        case 4:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.wechsleTurmseite(1);
                            break;
                        case 5:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.wechsleTurmseite(2);
                            break;
                        case 6:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.wechsleTurmseite(3);
                            break;
                        case 7:
                            AktionsEbene[Turmseite][h][b] = new Aktionen.wechsleTurmseite(4);
                            break;
                        default: 
                            break;
                    }
                }
            }
        
        
        }
    }    
    
}
