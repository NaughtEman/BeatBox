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
public class Strings implements Instruments{
    
    private final String[] instrumentsNames = {
        "Violin",
        "Viola", 
        "Cello",
        "Contrabass",
        "String Ensemble"
    };
    
    private final Map<String, Integer> INSTRUMENTS = Map.ofEntries(
        Map.entry("Violin", 40),
        Map.entry("Viola", 41),
        Map.entry("Cello", 42),
        Map.entry("Contrabass", 43),
        Map.entry("String Ensemble", 44)
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
