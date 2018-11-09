/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafiken;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon.Spittel
 */
public class Grafiken {
    
    private Image Mauer;
    private Image Gang;
    private Image Leiter;
    private Image Tür;
    private Image Figur;
    
    public Grafiken() {
        loadMauer();

    }
    
//----------------------Laden der Grafiken aus dem Ordner Pictures-------------   
    private void loadMauer() {

        try {
            Mauer = ImageIO.read(new File("Pictures" + File.separator + "Mauer.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
//-----------------------Methoden um an Bilder zu kommen--------------    
        public Image getMauer() {
        return Mauer;
    }
    
}
