/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.GUI.Components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;
import BeatBox.Instruments.Channel;
import BeatBox.Music.Beats;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dosum
 */
public class InstrumentsGUI {

    private final JPanel wholePanel;
    private Channel channel;
    private String channelName = "Drums";
    private JPanel menuPanel;
    private JScrollPane scrollPane;    
    private InstrumentsPanel instrumentPanel;
    
    public InstrumentsGUI() {
        
        // Main panel using BorderLayout
        wholePanel = new JPanel(new BorderLayout());
        
        instrumentPanel = new InstrumentsPanel();
        
        // Create menu
        createMenu();
        
         // Create instrument panel
        instrumentPanel.setChannel(channelName);        
        
        // Add scroll feature
        scrollPane = new JScrollPane(instrumentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        wholePanel.add(BorderLayout.CENTER, scrollPane);
        wholePanel.add(BorderLayout.NORTH, menuPanel);
        
    }
    
    public JPanel getIPanel(){
        return wholePanel;
    }
    
    public void createMenu(){
        
        menuPanel = new JPanel();
        JComboBox<String> instrumentList = new JComboBox<>(Channel.getChannelsNames());
        instrumentList.setSelectedIndex(0); // Select first item by default
        instrumentList.addActionListener(e -> {
            channelName = (String) instrumentList.getSelectedItem();
            instrumentPanel.setChannel(channelName);
        });
        menuPanel.add(BorderLayout.CENTER, instrumentList);
    }
    
    class CheckListener implements ItemListener{
        private final String instrumentName;
        private final int noteNo;
        private final int no;
        private final Beats beats = Beats.getInstance();
        private final Channel channel = new Channel(channelName);
        
        CheckListener(String name, int no){
            this.instrumentName = name;
            this.noteNo = channel.getValue(name);
            this.no = no;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            // Do something
            JCheckBox source = (JCheckBox) e.getSource();
            beats.makeTracks(noteNo, no);
            
            /*if(e.getStateChange() == ItemEvent.SELECTED){
                beats.makeTracks(noteNo, no);
            }else{
                beats.makeTracks(128,noteNo, no);
            }*/
  
        }

    }
    
}
