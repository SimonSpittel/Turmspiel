/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

/**
 *
 * @author Simon Spittel
 */
public class Steuerung {
    //private Figur f;
    private Aktionen.Aktion[][] AktionsEbene = new Aktionen.Aktion[30][15];
    private int aktiveTurmseite;
    
    
    private boolean pruefeAufAktion(int x, int y){
        return AktionsEbene[y][x].getAktionVerfügbar();
    }
    
    public void VerarbeiteAktionstaste(){
 //       if(pruefeAufAktion(f.getX, f.getY)){
 //           AktionsEbene[f.getY][f.getX].aktion();
 //       }
    }
    

}
