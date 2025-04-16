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
public class Buttons {
    
    private static Buttons instance;

    public Buttons(){}
    
    public static Buttons getInstance(){
    
        if(instance ==null){
            instance =  new Buttons();
        }
        return instance;
    }
    
    public JPanel Jpanels(){
        JPanel panel = new JPanel();
        
        panel.add(Jbutton("Start"));
        panel.add(Jbutton("Stop"));
        panel.add(Jbutton("Tempo Up"));
        panel.add(Jbutton("Tempo Down"));
        panel.add(Jbutton("Reset"));
        panel.add(Jbutton("Save"));
        panel.add(Jbutton("Load"));
        panel.add(Jbutton("Start Recording"));
        panel.add(Jbutton("Stop Recording"));
        
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
