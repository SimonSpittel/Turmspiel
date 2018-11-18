/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Simon Spittel
 */
public class Level {
    private Aktionen.Aktion[][][] AktionsEbene = new Aktionen.Aktion[4][30][15];
    private Spielelement.Spielelement [][][] SpielEbene = new Spielelement.Spielelement[4][30][15];
    private double[][][] test = new double[4][30][15];
    
                                                        //<-- Muss nacher in die einzelnen Levels
        
    public void loadAktionLvlTurmseite(int Turmseite){
        Scanner scanIn =null;
        int Rowc = 0;
        String InputLine = "";
  //      double xnum = 0;
        String xfileLocation;
        
    
        xfileLocation = "Dateien/Lvl1_Aktion_Turmseite"+(Turmseite+1)+".txt";
        try{
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
            
            while(scanIn.hasNextLine()){
                
                InputLine =scanIn.nextLine();
                String [] InArray =InputLine.split(",");
                
                for (int x=0;x < test[Turmseite][Rowc].length; x++){
                    test[Turmseite][Rowc][x]= Double.parseDouble(InArray[x]);
                }
                
                Rowc ++;
                
            }
        } catch (Exception e){
            System.out.println("ERROR: "+e);
        }
        
//-----------------Wandelt das eingelesene array test in jeweilige Aktionen um------------    
            for(int y = 0 ; y < test[Turmseite].length ; y++){
                for(int x = 0 ; x < test[Turmseite][y].length ; x++){
                    switch((int)test[Turmseite][y][x]){
                        case 0:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.KeineAktion();
                            break;
                        case 1:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.schlüsselAblegen();
                            break;
                        case 2:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.schlüsselAufheben();
                            break;
                        case 3:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.starteMinigame();
                            break;
                        case 4:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.wechsleTurmseite(1);
                            break;
                        case 5:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.wechsleTurmseite(2);
                            break;
                        case 6:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.wechsleTurmseite(3);
                            break;
                        case 7:
                            AktionsEbene[Turmseite][y][x] = new Aktionen.wechsleTurmseite(4);
                            break;
                        default: 
                            break;
                    }
                }
                
            }
            
         
    }
    
    
    public void loadSpielElementLvlTurmseite(int Turmseite){
        Scanner scanIn =null;
        int Rowc = 0;
        String InputLine = "";
  //      double xnum = 0;
        String xfileLocation;
        
    
        xfileLocation = "Dateien/Lvl1_SpielElement_Turmseite"+(Turmseite+1)+".txt";
        try{
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
            
            while(scanIn.hasNextLine()){
                
                InputLine =scanIn.nextLine();
                String [] InArray =InputLine.split(",");
                
                for (int x=0;x < test[Turmseite][Rowc].length; x++){
                    test[Turmseite][Rowc][x]= Double.parseDouble(InArray[x]);
                }
                
                Rowc ++;
                
            }
        } catch (Exception e){
            System.out.println("ERROR: "+e);
        }
        
                
            for(int y = 0 ; y < test[Turmseite].length ; y++){
                for(int x = 0 ; x < test[Turmseite][y].length ; x++){
                    switch((int)test[Turmseite][y][x]){
                        case 0:
                            SpielEbene[Turmseite][y][x] = new Spielelement.Gang();
                            break;
                        case 1:
                            SpielEbene[Turmseite][y][x] = new Spielelement.Mauer();
                            break;
                        case 2:
                            SpielEbene[Turmseite][y][x] = new Spielelement.Leiter();
                            break;
                        case 3:
                            SpielEbene[Turmseite][y][x] = new Spielelement.Tür();
                            break;
                        default: 
                            break;
                    }
                }
                
            }
            
         
    }
    
    
    public void printLvl(){
        for(int Turmseite = 0 ; Turmseite < test.length ; Turmseite++){
            for(int y = 0 ; y < test[Turmseite].length ; y++){
                for(int x = 0 ; x < test[Turmseite][y].length ; x++){
                    System.out.print("["+test[Turmseite][y][x]+"]");
                }
                System.out.println("");
            }
            System.out.println("");
        }    
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