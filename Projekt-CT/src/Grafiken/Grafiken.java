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

    private static Image Mauer1;
    private static Image Mauer2;
    private static Image Mauer3;
    private static Image Mauer4;
    private static Image Mauer5;
    private static Image Gang;
    private static Image Leiter;
    private static Image Tür;
    private static Image Wand;
    private static Image Figur;
    private static Image Unseen;

    //-----------------------------FACKEL----------------------
    private static Image Fackel1;
    private static Image Fackel2;
    private static Image Fackel3;
    private static Image Fackel4;
    private static Image Fackel0;

    //-----------------truhen----------
    private static Image openChest;
    private static Image closedChest;

    //------------Schlüssel------
    private static Image key;

    //------------Laterne----------
    private static Image Laterne;

    //---------Inventar----
    private static Image cursor;
    private static Image Inventarhintergrund;

    //------------Fallen------------
    private static Image Netzfalle;
    private static Image Speerfalle;

    static {
        loadGrafik("Mauer");
        loadGrafik("Gang");
        loadGrafik("Leiter");
        loadGrafik("Tür");
        loadGrafik("Figur");
        loadGrafik("Unseen");
        loadGrafik("Fackel");
        loadGrafik("Chest");
        loadGrafik("Key");
        loadGrafik("Netzfalle");
        loadGrafik("Speerfalle");
        loadGrafik("Laterne");
        loadGrafik("Cursor");
        loadGrafik("Inventarhintergrund");

    }

    public Grafiken() {

    }
//----------------------------Figuren-------------------

    public static void loadGrafik(String name) {
        try {
            switch (name) {
    
                case "Mauer":
                    Mauer1 = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Mauer1.png"));
                    Mauer2 = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Mauer2.png"));
                    Mauer3 = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Mauer3.png"));
                    Mauer4 = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Mauer4.png"));
                    Mauer5 = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Mauer5.png"));
                    break;
                    
                case "Gang":
                    Gang = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Gang.png"));
                    break;
                    
                case "Leiter":
                    Leiter = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Leiter.png"));
                    Wand = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "stone_brick_2.png"));
                    break;
                    
                case "Tür":
                    Tür = ImageIO.read(new File("Texturen" + File.separator + "Spielelemente" + File.separator + "Tür.png"));
                    break;
                case "Unseen":
                    Unseen = ImageIO.read(new File("Texturen" + File.separator + "Schatten" + File.separator + "unseen.png"));
                    break;
                    
                case "Fackel":
                    Fackel0 = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Fackel" + File.separator + "torch_0.png"));
                    Fackel1 = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Fackel" + File.separator + "torch_1.png"));
                    Fackel2 = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Fackel" + File.separator + "torch_2.png"));
                    Fackel3 = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Fackel" + File.separator + "torch_3.png"));
                    Fackel4 = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Fackel" + File.separator + "torch_4.png"));
                    break;
                    
                case "Chest":
                    openChest = ImageIO.read(new File("Texturen" + File.separator + "Kiste" + File.separator + "chest_2_open.png"));
                    closedChest = ImageIO.read(new File("Texturen" + File.separator + "Kiste" + File.separator + "chest_2_closed.png"));
                    break;
                    
                case "Key":
                    key = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "key.png"));
                    break;
                    
                case "Laterne":
                    Laterne = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Laterne" + File.separator + "misc_lamp_new.png"));
                    break;
                    
                case "Netzfalle":
                    Netzfalle = ImageIO.read(new File("Texturen" + File.separator + "Fallen" + File.separator + "trap_net.png"));
                    break;
                    
                case "Speerfalle":
                    Speerfalle = ImageIO.read(new File("Texturen" + File.separator + "Fallen" + File.separator + "spike-animation.png"));
                    break;
                    
                case "Cursor":
                    cursor = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Inventar" + File.separator + "cursor.png"));
                    break;
                    
                case "Inventarhintergrund":
                    Inventarhintergrund = ImageIO.read(new File("Texturen" + File.separator + "Items" + File.separator + "Inventar" + File.separator + "mirrored_wall_new.png"));
                    break;
                    
                case "Figur":
                    Figur = ImageIO.read(new File("Texturen" + File.separator + "Adventurer" + File.separator + "AdventurerSpriteMove.png"));
                    break;
                    
            }
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

    /**
     * @return the key
     */
    public Image getKey() {
        return key;
    }

    /**
     * @return the Netzfalle
     */
    public Image getNetzfalle() {
        return Netzfalle;
    }

    /**
     * @return the Speerfalle
     */
    public Image getSpeerfalle() {
        return Speerfalle;
    }

    /**
     * @return the Wand
     */
    public Image getWand() {
        return Wand;
    }

    /**
     * @return the cursor
     */
    public Image getCursor() {
        return cursor;
    }

    /**
     * @return the Inventarhintergrund
     */
    public Image getInventarhintergrund() {
        return Inventarhintergrund;
    }

    /**
     * @return the Laterne
     */
    public Image getLaterne() {
        return Laterne;
    }

}
