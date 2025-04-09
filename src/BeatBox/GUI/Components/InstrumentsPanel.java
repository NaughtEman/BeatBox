/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.GUI.Components;

import BeatBox.Instruments.Channel;
import BeatBox.Music.Beats;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.*;

public class InstrumentsPanel  extends JPanel {
    private String currentChannelName;
    private JPanel checkBoxPanel;
    private static final int NUM_CHECKBOXES = 16;
    private List<JCheckBox> chkBxs  = new ArrayList<>();
    private Map<String, List<JCheckBox>> chkBxsMap = new HashMap<>();
    private Channel channel;
    
    public InstrumentsPanel(){
        setLayout(new BorderLayout());
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        add(checkBoxPanel, BorderLayout.CENTER);
    }
    
    public void setChannel(String channelName) {
        if (!channelName.equals(currentChannelName)) {
            currentChannelName = channelName;
            channel = new Channel(channelName); // Initialize channel here
            Beats.getInstance().setCurrentChannel(channel.getChannel());
            refreshCheckboxes();
        }
    }

    private void refreshCheckboxes() {
        checkBoxPanel.removeAll();
        chkBxsMap.clear(); 
        JPanel gridPanel = new JPanel(new GridLayout(channel.getInstrumentsNo(), 1, 1, 1));
        gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.Y_AXIS));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        
        Arrays.stream(channel.getInstrumentsNames()).forEach(name -> {
        
            JLabel nameLabel = new JLabel(name);
            
            JPanel row = new JPanel(new BorderLayout());
            row.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
            
            nameLabel.setPreferredSize(new Dimension(120, 25));  
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            row.add(BorderLayout.WEST, nameLabel);
            row.add(BorderLayout.CENTER,createChkBxs(name));
            
            gridPanel.add(row);
            gridPanel.add(Box.createVerticalStrut(4)); // optional spacing
            
            
        });
        
        checkBoxPanel.add(gridPanel);
        checkBoxPanel.setAlignmentY(TOP_ALIGNMENT);
        checkBoxPanel.setAlignmentX(LEFT_ALIGNMENT);
        checkBoxPanel.revalidate();
        checkBoxPanel.repaint();
    }
    
    private JPanel createChkBxs(String instrumentName){        
        JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 4));
        
        // Initialize checkboxes
        /*List <JCheckBox> rowChkBxs = IntStream.range(0, NUM_CHECKBOXES)
                .mapToObj(i -> {
                    JCheckBox chkBx = new JCheckBox();
                    chkBx.addItemListener(new CheckListener(instrumentName, i));
                    return chkBx;
                })
                .collect(Collectors.toList());*/
        
        chkBxs = IntStream.range(0, NUM_CHECKBOXES)
                .mapToObj(i -> {
                    JCheckBox chkBx = new JCheckBox();
                    chkBx.addItemListener(new CheckListener(instrumentName, i));
                    return chkBx;
                })
                .collect(Collectors.toList());
        
        // Set up grid
        checkBoxPanel.setLayout(new GridLayout(1, NUM_CHECKBOXES, 2, 1));
        
        chkBxsMap.put(instrumentName, chkBxs);
        //rowChkBxs.forEach(checkBoxPanel::add);
        chkBxs.forEach(checkBoxPanel::add);
        
        return checkBoxPanel;
    }
    
    class CheckListener implements ItemListener{
        private final String instrumentName;
        private final int no;
        private final Beats beats = Beats.getInstance();
        
        CheckListener(String name, int no){
            this.instrumentName = name;
            this.no = no;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            // Do something
            JCheckBox source = (JCheckBox) e.getSource();
            int noteNo = channel.getValue(instrumentName);
            beats.makeTracks(noteNo, no);
            System.out.println("Channel name: " + currentChannelName + " Note no: " + noteNo  + " No: " + no);
            
            
            if(e.getStateChange() == ItemEvent.SELECTED){
                beats.makeTracks(noteNo, no);
                beats.makeTracks(noteNo, no+1);
            }else{
                beats.removeNote(noteNo, no);
                beats.removeNote(noteNo, no+1);
            }
  
        }

    }
    
}

