/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.GUI.Listeners;

/**
 *
 * @author dosum
 */

import BeatBox.Music.Beats;
import java.awt.*;
import java.awt.event.*;

public class ButtonListener implements ActionListener{
    Beats beats = Beats.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the action 
       String actionCmd =  e.getActionCommand().toLowerCase();
        
        /* Switch statement to handle each button based on its action command
            Make sure each case is in lower case
       */
        switch (actionCmd) {
            case "start":
                try{
                    beats.play();
                }catch(Exception ex){ex.printStackTrace();}
                
                break;
            case "stop":
                try{
                    beats.stop();
                }catch(Exception ex){ex.printStackTrace();}
                break;
            case "tempo up":
                try{
                    beats.updateTempo(5);
                }catch(Exception ex){ex.printStackTrace();}
                break;
            case "tempo down":
                try{
                    beats.updateTempo(-5);
                }catch(Exception ex){ex.printStackTrace();}
                break;
            default:
                System.out.println("No Button Clicked");
                break;
        }
    }
    
    
}
