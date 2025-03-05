/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.GUI.Components;

import BeatBox.GUI.Listeners.ButtonListener;
import javax.swing.*;

/**
 *
 * @author dosum
 */
public class BeatBoxButtons {
    
    private static BeatBoxButtons instance;

    public BeatBoxButtons(){}
    
    public static BeatBoxButtons getInstance(){
    
        if(instance ==null){
            instance =  new BeatBoxButtons();
        }
        return instance;
    }
    
    public JPanel Jpanels(){
        JPanel panel = new JPanel();
        
        panel.add(Jbutton("Start"));
        panel.add(Jbutton("Stop"));
        panel.add(Jbutton("Tempo Up"));
        panel.add(Jbutton("Tempo Down"));
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        return panel;
    }
    
    private JButton Jbutton(String name){
        JButton button = new JButton(name);
        button.setActionCommand(name);
        
        button.addActionListener(new ButtonListener() );
        return button;
    } 
    
}
