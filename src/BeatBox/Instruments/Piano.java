/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Instruments;

import java.util.Map;

/**
 *
 * @author dosum
 */
public class Piano implements Instruments{
    
    private final String[] instrumentsNames = {
        "Acoustic Grand", 
        "Bright Acoustic",
        "Electric Grand",
        "Honky-tonk",
        "Electric Piano 1"
    };
    
    private final Map<String, Integer> INSTRUMENTS = Map.ofEntries(
        Map.entry("Acoustic Grand", 0),
        Map.entry("Bright Acoustic", 1),
        Map.entry("Electric Grand", 2),
        Map.entry("Honky-tonk", 3),
        Map.entry("Electric Piano 1", 4)
    );

    @Override
    public String[] getInstrumentsNames() {
        return instrumentsNames;
    }

    @Override
    public int getInstrumentsNo() {
        return instrumentsNames.length;
    }

    @Override
    public int getValue(String key) {
        return INSTRUMENTS.getOrDefault(key, 0);
    }
    
    
    
}
