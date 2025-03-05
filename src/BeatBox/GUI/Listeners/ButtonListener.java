/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.GUI.Listeners;

/**
 *
 * @author dosum
 */

import java.awt.*;
import java.awt.event.*;

public class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the action 
       String actionCmd =  e.getActionCommand().toLowerCase();
        
        /* Switch statement to handle each button based on its action command
            Make sure each case is in lower case
       */
        switch (actionCmd) {
            case "start":
                System.out.println("Start Button Clicked");
                break;
            case "stop":
                System.out.println("Stop Button Clicked");
                break;
            case "tempo up":
                System.out.println("Tempo Up Button Clicked");
                break;
            case "tempo down":
                System.out.println("Tempo Down Button Clicked");
                break;
            default:
                System.out.println("No Button Clicked");
                break;
        }
    }
    
    
}
