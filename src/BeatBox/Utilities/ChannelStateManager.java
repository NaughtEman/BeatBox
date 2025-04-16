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
    
    public static void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(STATE_FILE))) {
            out.writeObject(channelStates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void loadFromFile() {
        File file = new File(STATE_FILE);
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof Map) {
                Map<?, ?> loaded = (Map<?, ?>) obj;
                channelStates.clear();
                for (Map.Entry<?, ?> entry : loaded.entrySet()) {
                    if (entry.getKey() instanceof String && entry.getValue() instanceof Map) {
                        channelStates.put((String) entry.getKey(), (Map<String, boolean[]>) entry.getValue());
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
