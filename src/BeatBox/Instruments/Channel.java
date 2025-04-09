/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Instruments;

import java.util.*;

/**
 *
 * @author dosum
 */
public class Channel {
    
    private final int channel;
    
    private final Instruments instruments;
    
    private final String name;
    
    private final static String[] instrumentsNames = {"Drums", "Piano", "Bass", "Strings", "Brass" }; 
    
    // Maps a channel name to a its object
    private final Map<String, Integer> ICHANNEL = new HashMap<>(Map.ofEntries(
            Map.entry("Drums", 9),
            Map.entry("Piano", 0),
            Map.entry("Bass", 1),
            Map.entry("Strings", 2),
            Map.entry("Brass", 3)
        )
    );
    
    //Maps a channel name to its channel number
    private final Map<String, Instruments>CO = new HashMap<>(
            Map.ofEntries(
                    Map.entry("Drums", new Drums()),
                    Map.entry("Piano", new Piano()),
                    Map.entry("Bass", new Bass()),
                    Map.entry("Strings", new Strings()),
                    Map.entry("Brass", new Brass())
            )
    );
    
    public Channel(String name){
        this.instruments = CO.get(name);
        this.channel = ICHANNEL.get(name);
        this.name = name;
    }
    
    //private final List<Instruments> instruments = new ArrayList<>();
    
    public static String[] getChannelsNames() {
        return instrumentsNames;
    }
    
    public int getChannel(){
        return channel;
    }
    
    public String[] getInstrumentsNames() {
        return instruments.getInstrumentsNames();
    }
    
    public int getInstrumentsNo() {
        return instruments.getInstrumentsNo();
    }
    
    public int getValue(String key){
        return instruments.getValue(key);
    }
    
    
    
}
