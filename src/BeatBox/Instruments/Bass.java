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
public class Bass implements Instruments{
    
    private final String[] instrumentsNames = {
        "Acoustic Bass",
        "Electric Bass (finger)",
        "Electric Bass (pick)",
        "Fretless Bass",
        "Slap Bass 1"
    };
    
    private final Map<String, Integer> INSTRUMENTS = Map.ofEntries(
        Map.entry("Acoustic Bass", 32),
        Map.entry("Electric Bass (finger)", 33),
        Map.entry("Electric Bass (pick)", 34),
        Map.entry("Fretless Bass", 35),
        Map.entry("Slap Bass 1", 36)
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
