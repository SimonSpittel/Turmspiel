/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.ct;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;

/**
 *
 * @author Noah Hauke
 */
public class Oberflaeche extends javax.swing.JPanel {
    
    private Graphics g;
    private Steuerung s;
    

    public Oberflaeche() {
        
        s= new Steuerung(this);
        initComponents();
        setFocusable(true);
        requestFocus();     
    }


    protected void paintComponent(Graphics g){     
        super.paintComponent(g);
        s.zeichneSpielElemente(g);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()){
            case KeyEvent.VK_UP:

                s.verarbeiteTastendruck(evt);
                break;
            case KeyEvent.VK_DOWN:
                s.verarbeiteTastendruck(evt);
                break;
            case KeyEvent.VK_LEFT:
                s.verarbeiteTastendruck(evt);
                break;
            case KeyEvent.VK_RIGHT:
                s.verarbeiteTastendruck(evt);
                break;
                    
        }
        
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
