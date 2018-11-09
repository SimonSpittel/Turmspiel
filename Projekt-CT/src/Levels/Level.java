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
    private double [][] test = new double[30][15];
    projekt.ct.Steuerung steuerung;
    public Level(projekt.ct.Steuerung s){
        steuerung = s;
    }                                                         //<-- Muss nacher in die einzelnen Levels
        
    public void loadLvl(){
        Scanner scanIn =null;
        int Rowc = 0;
        String InputLine = "";
        double xnum = 0;
        String xfileLocation;
    
        xfileLocation = "Dateien/Lvl1.txt";
        try{
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
            
            while(scanIn.hasNextLine()){
                
                InputLine =scanIn.nextLine();
                String [] InArray =InputLine.split(",");
                
                for (int x=0;x < test[Rowc].length; x++){
                    test[Rowc][x]= Double.parseDouble(InArray[x]);
                }
                
                Rowc ++;
                
            }
        } catch (Exception e){
            System.out.println("ERROR: "+e);
        }
    }    
    public void printLvl(){
        for(int y = 0 ; y < test.length ; y++){
            for(int x = 0 ; x < test[0].length ; x++){
                System.out.print("["+test[y][x]+"]");
            }
            System.out.println("");
        }
    }
    
    
} 