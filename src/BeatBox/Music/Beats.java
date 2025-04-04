/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Music;

/**
 *
 * @author dosum
 */

import javax.sound.midi.*;

public class Beats {
    
   public void createTrack(){
   
       try {
           
           Sequencer player = MidiSystem.getSequencer();
           player.open();
       } catch (Exception e) {
       }
   }
   
   public ShortMessage createShrtMesg(){
       ShortMessage shrtMsg = new ShortMessage();
       
       
       
       return shrtMsg;
   }
}
