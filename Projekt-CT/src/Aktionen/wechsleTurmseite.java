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
    private int Turmseite;
    
    public wechsleTurmseite(int Turmseite){
        aktionVerfügbar = true;
        this.Turmseite = Turmseite;
    }
    
    @Override
    public void aktion() {
        
    }


     
    
}
