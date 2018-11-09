/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;

/**
 *
 * @author Simon Spittel
 */
public class wechsleTurmseite extends Aktion {
    private int neueTurmseite; //<--- gibt an zu welhcer turmseite gewechselt werden soll
    
    public wechsleTurmseite(int Turmseite){
        
        this.neueTurmseite = Turmseite;
    }
    
    
    public int aktion() {
        return neueTurmseite;
    }


     
    
}
