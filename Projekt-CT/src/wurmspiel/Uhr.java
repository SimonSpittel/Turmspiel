/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wurmspiel;

/**
 *
 * @author Noah Hauke
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author noah.hauke
 */
public class Uhr {

    private int aTakt = 500;
    private Timer t;

    public Uhr( final Steuerung s) {

        t = new Timer(aTakt, new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {
                s.verarbeiteUhrTick();
            }
        });
    }

    public void starten() {
        t.start();
    }

    public void stoppen() {
        t.stop();
    }
}