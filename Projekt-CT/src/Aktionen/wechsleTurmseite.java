/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Simon Spittel
 */
public class wechsleTurmseite extends Aktion {

    private int neueTurmseite; //<--- gibt an zu welhcer turmseite gewechselt werden soll
    private wurmspiel.WFrame WF;
 
    private Timer t = new Timer(2, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {

            pruefeObGewonnen();

        }
    });

    public wechsleTurmseite(int Turmseite, int x, int y) {
        xPos = x;
        yPos = y;
        this.neueTurmseite = Turmseite;
        WF = new wurmspiel.WFrame();
    }

    public void aktion() {
   
            WF.setVisible(true);
            WF.restart();
        
        t.start();

    }

    public void pruefeObGewonnen() {

        if (WF.getGelöst() == 1) {
            WF.setGelöst(0);
 
            WF.setVisible(false);
            s.setAktiveTurmseite(neueTurmseite);
            t.stop();
        } else if (WF.getGelöst() == 2) {
            WF.setGelöst(0);

            WF.setVisible(false);
            t.stop();
        }
    }

    @Override
    public void zeichne(Graphics g, int hoehe, int breite) {
        this.breite = breite / 19;
        this.hoehe = hoehe / 32;
        g.setColor(Color.CYAN);
        g.drawString("W", (2 + xPos) * this.breite, (yPos + 3) * this.hoehe);
        //g.drawImage(grafik.getTür(), (2 + xPos) * this.breite, (yPos + 2) * this.hoehe, this.breite, this.hoehe, null);
    }

}
