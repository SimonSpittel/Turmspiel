/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Simon Spittel
 */
public class Steuerung {
    //--------------------------------------------Allgemeine Atribute------------------------------
    
    
    private Oberflaeche o;
    private int Intervall =500;
    //------------------------------------------------AktionsEbene--------------------------------- 
    
    private Aktionen.Aktion[][][] AktionsEbene;   //<-- [1] gibt Turmseite; [2] gibt Höhe im Turm;  [3] gibt breite im Turm
    private int aktiveTurmseite = 0;
    
    //--------------------------------------------SpielelementeEbene-------------------------------- 
    
    private Spielelement.Spielelement [][][] SpielelementeEbene =  new Spielelement.Spielelement[4][30][15]; // <--- muss später aus Klasse Level geladen werden somit Array [][][][] erstes gibt die turmseite an um so auch wechseln zu können
    private Spielelement.Spielfigur figur = new Spielelement.Spielfigur();                                   // <-- nur zum test
    

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
        for(int v = 0; SpielelementeEbene[aktiveTurmseite].length > v ; v++){        //  
            for(int h = 0; SpielelementeEbene[aktiveTurmseite][v].length > h ; h++){ // 
                SpielelementeEbene[aktiveTurmseite][v][h] = new Spielelement.Mauer();//  <--- NUR ZUM TESTEN
            }                                                                        //
            
        }
        
    }
    
    public void zeichneSpielElemente(Graphics g){
        figur.zeichne(g);

        for(int v = 0; SpielelementeEbene[aktiveTurmseite].length > v ; v++){        //  v  <--- Durchlaufvariable für die Turmhöhe
            for(int h = 0; SpielelementeEbene[aktiveTurmseite][v].length > h ; h++){ //  h  <--- Durchlaufvariable für die Turmbreite    
                SpielelementeEbene[aktiveTurmseite][v][h].zeichne(g);
            }
            System.out.println("");
        }
    }
    
    
   //--------------------reagiert auf tastendruck zum Bewegen---------------------
    public void verarbeiteTastendruck(java.awt.event.KeyEvent evt){    
        figur.bewege(evt);
        o.repaint();
    }
  
   //----------------prüft bei betreten eines Feldes oder bei Auswahl ob Aktion vorliegt----------------------

    private boolean pruefeAufAktion(int x, int y){
        return AktionsEbene[aktiveTurmseite][y][x].getAktionVerfügbar();
    }
      //----------------reagiert auf taste um gewollte Aktion auszulösen-------- 
    public void VerarbeiteAktionstaste(){
 //       if(pruefeAufAktion(f.getX, f.getY)){
 //           AktionsEbene[f.getY][f.getX].aktion();
 //       }
    }


    

}
