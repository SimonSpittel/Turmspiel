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

    /**
     * @return the Gang
     */
    public Image getGang() {
        return Gang;
    }

    /**
     * @return the Leiter
     */
    public Image getLeiter() {
        return Leiter;
    }

    /**
     * @return the Tür
     */
    public Image getTür() {
        return Tür;
    }

    /**
     * @return the Figur
     */
    public Image getFigur() {
        return Figur;
    }
    
    private Image Mauer;
    private Image Gang;
    private Image Leiter;
    private Image Tür;
    private Image Figur;
    
    public Grafiken() {
        loadMauer();
        loadGang();
        loadLeiter();
        loadTür();
        loadFigur();
    }
    
//----------------------Laden der Grafiken aus dem Ordner Pictures-------------   
    private void loadMauer() {

        try {
            Mauer = ImageIO.read(new File("Texturen" + File.separator + "Mauer.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void loadGang() {

        try {
            Gang = ImageIO.read(new File("Texturen" + File.separator + "Gang.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void loadLeiter() {

        try {
            Leiter = ImageIO.read(new File("Texturen" + File.separator + "Leiter.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void loadTür() {

        try {
            Tür = ImageIO.read(new File("Texturen" + File.separator + "Tür.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void loadFigur() {

        try {
            Figur = ImageIO.read(new File("Texturen" + File.separator + "Figur.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
    
//-----------------------Methoden um an Bilder zu kommen--------------    
        public Image getMauer() {
        return Mauer;
    }
    
}
