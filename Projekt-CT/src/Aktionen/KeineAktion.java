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
public class KeineAktion extends Aktion {

    public KeineAktion(int x, int y) {
        xPos = x;
        yPos = y;
        aktionVerfügbar = false;
    }

    @Override
    public void aktion() {

    }

}
