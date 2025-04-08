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
public class Brass implements Instruments{
    private final String[] instrumentsNames = {
        "Trumpet",
        "Trombone",
        "Tuba",
        "Muted Trumpet",
        "French Horn"
    };
    
    private final Map<String, Integer> INSTRUMENTS = Map.ofEntries(
        Map.entry("Trumpet", 56),
        Map.entry("Trombone", 57),
        Map.entry("Tuba", 58),
        Map.entry("Muted Trumpet", 59),
        Map.entry("French Horn", 60)
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
