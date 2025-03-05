/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BeatBox;

import BeatBox.GUI.Components.BeatBoxButtons;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author dosum
 */
public class BeatBox {

    /**
     * @param args the command line arguments
     */
    BeatBoxButtons bbButtons = BeatBoxButtons.getInstance();
    
    public static void main(String[] args) {
        BeatBox bb = new BeatBox();
        bb.gui();
    }

    private void gui() {
        JFrame frame = new JFrame("Cyber BeatBox");
        
        frame.getContentPane().add(BorderLayout.CENTER, bbButtons.Jpanels());
        
        frame.setVisible(true);
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
