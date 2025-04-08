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
    
    private static final int NUM_CHECKBOXES = 16;
    private  List<JCheckBox> chkBxs;
    private final JPanel wholePanel;
    private Channel channel;
    private List<JPanel> nameChkbxs = new ArrayList<>();
    private String channelName = "Drums";

    
    public InstrumentsGUI() {
       channel = new Channel(channelName);
        
        // Main panel using BorderLayout
        wholePanel = new JPanel(new BorderLayout());
        
        //Create instrument grid
        JPanel instrumentPanel = createNameChkbxs();
        JPanel menuPanel = createMenu();
        instrumentPanel.setLayout(new BoxLayout(instrumentPanel, BoxLayout.Y_AXIS));
        
        
        // Add scroll feature
        JScrollPane scrollPane = new JScrollPane(instrumentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        wholePanel.add(BorderLayout.CENTER, scrollPane);
        wholePanel.add(BorderLayout.NORTH, menuPanel);
        
    }
    
    public JPanel getIPanel(){
        return wholePanel;
    }
    
    private JPanel createNameChkbxs(){  
        
        JPanel gridPanel = new JPanel(new GridLayout(0, 17, 5, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        Arrays.stream(channel.getInstrumentsNames()).forEach(name -> {
        
            JLabel nameLabel = new JLabel(name);
            
            JPanel row = new JPanel(new BorderLayout());
            nameLabel.setPreferredSize(new Dimension(120, 25));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            row.add(BorderLayout.WEST, nameLabel);
            row.add(BorderLayout.CENTER,createChkBxs(name));
            gridPanel.add(row);
            
            
        });
        
        return gridPanel;
    }
    
    private JPanel createChkBxs(String instrumentName){
        
        JPanel checkBoxPanel = new JPanel(new GridLayout(1, NUM_CHECKBOXES, 2, 1));
        
        // Clear existing components if any
        checkBoxPanel.removeAll();
        
        // Initialize checkboxes
        chkBxs = IntStream.range(0, NUM_CHECKBOXES)
                .mapToObj(i -> {
                    JCheckBox chkBx = new JCheckBox();
                    chkBx.addItemListener(new CheckListener(instrumentName, i));
                    return chkBx;
                })
                .collect(Collectors.toList());

        // Set up grid
        checkBoxPanel.setLayout(new GridLayout(1, NUM_CHECKBOXES, 2, 1));

        chkBxs.forEach(checkBoxPanel::add);
        
        return checkBoxPanel;
    } 
    
    public JPanel createMenu(){
        
        JPanel menuPanel = new JPanel();
        JComboBox instrumentList = new JComboBox(Channel.getChannelsNames());
        instrumentList.setSelectedIndex(0); // Select first item by default
        instrumentList.addActionListener(new MenuListener());
        menuPanel.add(BorderLayout.CENTER, instrumentList);
        
        return menuPanel;
    }
    
    class CheckListener implements ItemListener{
        private String instrumentName;
        private int noteNo;
        int no;
        Beats beats = Beats.getInstance();
        
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
    
    class MenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            channelName = (String)cb.getSelectedItem();
        }
    }
    
}
