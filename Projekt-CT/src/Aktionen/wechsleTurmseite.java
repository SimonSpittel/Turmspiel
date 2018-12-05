/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aktionen;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Simon Spittel
 */
public class wechsleTurmseite extends Aktion {

    private int neueTurmseite; //<--- gibt an zu welhcer turmseite gewechselt werden soll

    public wechsleTurmseite(int Turmseite, int x, int y) {
        xPos = x;
        yPos = y;
        this.neueTurmseite = Turmseite;
    }

    public void aktion() {
        System.out.println("rea");
        s.setAktiveTurmseite(neueTurmseite);
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
