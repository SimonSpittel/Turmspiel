/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Simon Spittel
 */
public class Steuerung {
    //--------------------------------------------Allgemeine Atribute------------------------------
    
    
    private Oberflaeche o;
    private int Intervall =500;
    //------------------------------------------------AktionsEbene--------------------------------- 
    
    private Aktionen.Aktion[][] AktionsEbene = new Aktionen.Aktion[30][15];
    private int aktiveTurmseite;
    
    //--------------------------------------------SpielelementeEbene-------------------------------- 
    
    private Spielelement.Spielelement [][]SpielelementeEbene = new Spielelement.Spielelement[30][15];
    private double [][] test = new double[30][15];
    private Spielelement.Spielfigur figur = new Spielelement.Spielfigur();
    

    //-----------------------------------------------EndeAtribute-----------------------------------
    
    public Steuerung(Oberflaeche o){
        this.o=o;
        
        initSpielelemente();
        
    }
    
//    public void loadLvl(){
//        Scanner scanIn =null;
//        int Rowc = 0;
//        int Row  = 0;
//        int Colc = 0;
//        int Col  = 0;
//        String InputLine = "";
//        double xnum = 0;
//        String xfileLocation;
//    
//        xfileLocation = "/Dateien/Lvl1.txt";
//        try{
//            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));
//            
//            while(scanIn.hasNextLine()){
//                String [] InArray =InputLine.split(",");
//                for (int x=0;x< InArray.length; x++){
//                    test[Rowc][x]= Double.parseDouble(InArray[x]);
//                }
//                Rowc ++;
//            }
//        } catch (Exception e){
//            System.out.println("ERROR");
//        }
//    }    
//    public void printLvl(){
//        for(int y = 0 ; y < test.length ; y++){
//            for(int x = 0 ; x < test[0].length ; x++){
//                System.out.print(""+test[x][y]);
//            }
//            System.out.println("");
//        }
//    }
    
    private void initSpielelemente(){
        figur.setxPos(0);
        figur.setyPos(0);
    }
    
    public void zeichneSpielElemente(Graphics g){
        figur.zeichne(g);
    }
    public void verarbeiteTastendruck(java.awt.event.KeyEvent evt){
        
        figur.bewege(evt);
        o.repaint();
    }
    
    private boolean pruefeAufAktion(int x, int y){
        return AktionsEbene[y][x].getAktionVerfügbar();
    }
    
    public void VerarbeiteAktionstaste(){
 //       if(pruefeAufAktion(f.getX, f.getY)){
 //           AktionsEbene[f.getY][f.getX].aktion();
 //       }
    }


    

}
