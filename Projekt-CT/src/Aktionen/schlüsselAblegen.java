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
public class schlüsselAblegen extends Aktion {

    public schlüsselAblegen(int x, int y) {
        xPos = x;
        yPos = y;
        aktionVerfügbar = true;

    }

    public void aktion() {
//        f.setSchlüssel = false;           //<--- schlüssel muss noch als Ausrüstung erstellt werden
    }

}
