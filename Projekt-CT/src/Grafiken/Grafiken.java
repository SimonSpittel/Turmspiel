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

    private Image Mauer1;
    private Image Mauer2;
    private Image Mauer3;
    private Image Mauer4;
    private Image Mauer5;
    private Image Gang;
    private Image Leiter;
    private Image Tür;
    private Image Figur;
    private Image Unseen;

    public Grafiken() {
        loadMauer1();
        loadMauer2();
        loadMauer3();
        loadMauer4();
        loadMauer5();
        loadGang();
        loadLeiter();
        loadTür();
        loadFigur();
        loadUnseen();
    }

//----------------------Laden der Grafiken aus dem Ordner Pictures-------------   
    private void loadMauer1() {

        try {
            Mauer1 = ImageIO.read(new File("Texturen" + File.separator + "Mauer1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadMauer2() {
        try {
            Mauer2 = ImageIO.read(new File("Texturen" + File.separator + "Mauer2.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadMauer3() {
        try {
            Mauer3 = ImageIO.read(new File("Texturen" + File.separator + "Mauer3.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadMauer4() {
        try {
            Mauer4 = ImageIO.read(new File("Texturen" + File.separator + "Mauer4.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadMauer5() {
        try {
            Mauer5 = ImageIO.read(new File("Texturen" + File.separator + "Mauer5.png"));
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
    
    private void loadUnseen() {

        try {
            Unseen = ImageIO.read(new File("Texturen" + File.separator + "unseen.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//-----------------------Methoden um an Bilder zu kommen--------------    
 

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

    /**
     * @return the Mauer1
     */
    public Image getMauer1() {
        return Mauer1;
    }

    /**
     * @return the Mauer2
     */
    public Image getMauer2() {
        return Mauer2;
    }

    /**
     * @return the Mauer3
     */
    public Image getMauer3() {
        return Mauer3;
    }

    /**
     * @return the Mauer4
     */
    public Image getMauer4() {
        return Mauer4;
    }

    /**
     * @return the MauerGras
     */
    public Image getMauer5() {
        return Mauer5;
    }

    /**
     * @return the Unseen
     */
    public Image getUnseen() {
        return Unseen;
    }

}
