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
    
    //-----------------------------FACKEL----------------------
    private Image Fackel1;
    private Image Fackel2;
    private Image Fackel3;
    private Image Fackel4;
    private Image Fackel0;
    
    
    //-----------------truhen----------
    
    private Image openChest;
    private Image closedChest;

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
        loadFackel0();
        loadFackel1();
        loadFackel2();
        loadFackel3();
        loadFackel4();
        loadOpenChest();
        loadClosedChest();
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

    
//--------------------------FACKELN-------------------------
    private void loadFackel0() {

        try {
            Fackel0 = ImageIO.read(new File("Texturen" + File.separator + "torch_0.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadFackel1() {

        try {
            Fackel1 = ImageIO.read(new File("Texturen" + File.separator + "torch_1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadFackel2() {

        try {
            Fackel2 = ImageIO.read(new File("Texturen" + File.separator + "torch_2.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadFackel3() {

        try {
            Fackel3 = ImageIO.read(new File("Texturen" + File.separator + "torch_3.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadFackel4() {

        try {
            Fackel4 = ImageIO.read(new File("Texturen" + File.separator + "torch_4.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //-------------TRUHEN-----------
    
    private void loadOpenChest() {

        try {
            openChest = ImageIO.read(new File("Texturen" + File.separator + "chest_2_open.png"));
        } catch (IOException ex) {
            Logger.getLogger(Grafiken.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadClosedChest() {

        try {
            closedChest = ImageIO.read(new File("Texturen" + File.separator + "chest_2_closed.png"));
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

    /**
     * @return the Fackel1
     */
    public Image getFackel1() {
        return Fackel1;
    }

    /**
     * @return the Fackel2
     */
    public Image getFackel2() {
        return Fackel2;
    }

    /**
     * @return the Fackel3
     */
    public Image getFackel3() {
        return Fackel3;
    }

    /**
     * @return the Fackel4
     */
    public Image getFackel4() {
        return Fackel4;
    }

    /**
     * @return the Fackel5
     */
    public Image getFackel0() {
        return Fackel0;
    }

    /**
     * @return the openChest
     */
    public Image getOpenChest() {
        return openChest;
    }

    /**
     * @return the closedChest
     */
    public Image getClosedChest() {
        return closedChest;
    }

}
