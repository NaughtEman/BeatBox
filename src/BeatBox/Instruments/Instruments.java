/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Instruments;

/**
 *
 * @author dosum
 */
public class Instruments {
    
    private final String[] instrumentsNames = {"Bass Drum", "Closed Hi-Hat", 
        "Open Hi-Hat", "Acoustic Snare" ,"Crash Cymbal", "Hand Clap", "High Tom", 
        "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", 
        "Low-mid Tom", "High Agogo", "Open Hi Conga"};

    private final int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,59,47,67,63}; 

    public String[] getInstrumentsNames() {
        return instrumentsNames;
    }

    public int[] getInstruments() {
        return instruments;
    }
    
    
}
