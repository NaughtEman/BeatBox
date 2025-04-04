/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BeatBox;

import BeatBox.GUI.Components.Buttons;
import BeatBox.GUI.Components.InstrumentsGUI;
import BeatBox.Music.Beats;
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
    Buttons bbButtons = Buttons.getInstance();
    Beats beats = Beats.getInstance();
    InstrumentsGUI iGUI = new InstrumentsGUI();
    
    JFrame frame;
    JPanel background;
    
    public static void main(String[] args) {
        BeatBox bb = new BeatBox();
        bb.gui();
    }

    private void gui() {
        beats.setUpMidi();
        frame = new JFrame("Cyber BeatBox");
        BorderLayout layout = new BorderLayout();
        background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        background.add(BorderLayout.EAST, bbButtons.Jpanels());
        background.add(BorderLayout.CENTER, iGUI.getIPanel());
        
        frame.getContentPane().add(background);
        
        frame.setVisible(true);
        frame.setBounds(50,50,300,300);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
