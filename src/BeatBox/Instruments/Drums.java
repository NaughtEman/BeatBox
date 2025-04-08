/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Instruments;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dosum
 */
public class Drums implements Instruments{
    
    private final String[] instrumentsNames = {"Bass Drum", "Closed Hi-Hat", 
        "Open Hi-Hat", "Acoustic Snare" ,"Crash Cymbal", "Hand Clap", "High Tom", 
        "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", 
        "Low-mid Tom", "High Agogo", "Open Hi Conga"}; 
    
    private final Map<String, Integer> INSTRUMENTS = new HashMap<>(Map.ofEntries(
            Map.entry("Bass Drum", 35),
            Map.entry("Closed Hi-Hat", 42),
            Map.entry("Open Hi-Hat", 46),
            Map.entry("Acoustic Snare", 38),
            Map.entry("Crash Cymbal", 49),
            Map.entry("Hand Clap", 39),
            Map.entry("High Tom", 50),
            Map.entry("Hi Bongo", 60),
            Map.entry("Maracas", 70),
            Map.entry("Whistle", 72),
            Map.entry("Low Conga", 64),
            Map.entry("Cowbell", 56),
            Map.entry("Vibraslap", 59),
            Map.entry("Low-mid Tom", 47),
            Map.entry("High Agogo", 67),
            Map.entry("Open Hi Conga", 63)
        )
    );

    public Drums() {}

    public String[] getInstrumentsNames() {
        return instrumentsNames;
    }
    
    public int getInstrumentsNo() {
        return instrumentsNames.length;
    }
    
    public int getValue(String key){
        return INSTRUMENTS.getOrDefault(key,0);
    }
    
}
