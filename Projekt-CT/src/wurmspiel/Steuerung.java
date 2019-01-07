/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wurmspiel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author noah.hauke
 */
public class Steuerung {
    public int gelöst=0;
    public Uhr c;
    private GUI gui;
    private Wurm w = new Wurm();
    private Random erzeugeZufallsZahl = new Random();
    private Futterzelle f = new Futterzelle(0, 0);
    private int a = 0;

    public Steuerung() {

    }
    public void restart(){
        w.setKopfPos(0, 0);
        for (int i = 0; i < 4; i++) {
            w.wurm[i].setPos(0, i);

        }
        w.aRichtung = KeyEvent.VK_RIGHT;
        w.setaLaenge(4);
        c.starten();
    }
    public void initialiesiereSpiel(GUI gui) {
        this.gui = gui;
        c = new Uhr(this);
        w.intitialiesiereWurm();
        erzeugeFutterAusserhalbWurm();
        gui.repaint();

    }

    private void erzeugeFutterAusserhalbWurm() {
        int x = erzeugeZufallsZahl.nextInt(10);
        int y = erzeugeZufallsZahl.nextInt(10);

        while (w.liegtAufWurm(x, y)) {
            x = erzeugeZufallsZahl.nextInt(10);
            y = erzeugeZufallsZahl.nextInt(10);

        }
        f.setPos(x, y);
    }

    public void zeichneFutterUndWurm(Graphics g) {
        f.zeichne(g);
        w.zeichneWurm(g);
    }

    public void verarbeiteTastenDruck(int a) {

        w.setzeRichtung(a);

    }

    public void verarbeiteUhrTick() {

        gui.repaint();

        if (w.getKopfPos().x == f.getPos().x && w.getKopfPos().y == f.getPos().y) {
            w.wachse();
            erzeugeFutterAusserhalbWurm();
        }
        if (!pruefeVerloren()) {
            w.krieche();
            gelöst=2;
            JOptionPane.showMessageDialog(null, "Verloren", "Verloren", JOptionPane.INFORMATION_MESSAGE);
            c.stoppen();


        } else if (w.pruefeGewonnen()) {
            gelöst=1;
            w.krieche();
            JOptionPane.showMessageDialog(null, "Gewonnen", "Gewonnen", JOptionPane.INFORMATION_MESSAGE);
            c.stoppen();
        } else {
            w.krieche();
        }
    }

    public boolean pruefeVerloren() {
        if (w.WurmKO(w.getKopfPos().x, w.getKopfPos().y)) {
            return false;
        } else if (w.getKopfPos().x < 0 || w.getKopfPos().x > 9) {
            return false;
        } else if (w.getKopfPos().y < 0 || w.getKopfPos().y > 9) {
            return false;
        }
        return true;
    }

}
