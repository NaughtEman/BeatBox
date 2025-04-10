/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Utilities;

/**
 *
 * @author dosum
 */

import java.util.*;
import java.io.*;
import BeatBox.GUI.Components.InstrumentsPanel;

public class ChannelStateManager {
    private static final Map<String, Map<String, boolean[]>> channelStates = new HashMap<>();
    private static final String STATE_FILE = "beatbox_states.dat";
    
    public static void saveState(String channelName, InstrumentsPanel panel) {
        Map<String, boolean[]> instrumentStates = new HashMap<>();
        
        panel.getCheckboxStates().forEach((instrumentName, states) -> {
            boolean[] stateArray = new boolean[states.size()];
            for (int i = 0; i < states.size(); i++) {
                stateArray[i] = states.get(i).isSelected();
            }
            instrumentStates.put(instrumentName, stateArray);
        });
        
        channelStates.put(channelName, instrumentStates);
    }
    
    public static Map<String, boolean[]> getState(String channelName) {
        return channelStates.getOrDefault(channelName, new HashMap<>());
    }
    
    public static void clearStates() {
        channelStates.clear();
    }
    /*
    public static void saveToDisk() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(STATE_FILE))) {
            oos.writeObject(channelStates);
        } catch (IOException e) {
            System.err.println("Failed to save states: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void loadFromDisk() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(STATE_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                channelStates.clear();
                channelStates.putAll((Map<String, Map<String, boolean[]>>) obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No saved states found or error loading: " + e.getMessage());
        }
    }*/
}
