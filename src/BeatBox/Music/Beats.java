/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeatBox.Music;

/**
 *
 * @author dosum
 */

import java.util.*;
import javax.sound.midi.*;

public class Beats {
    
    private static final int DEFAULT_RESOLUTION = 24; // Standard MIDI resolution
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private Map<String, Track> instrumentTracks;
    private int tempoBPM = 120;
    private static Beats instance;
    private int currentChannel = 9; // Default to channel 9 (percussion)
    
    public Beats(){}
    
    public static Beats getInstance(){
         if(instance ==null){
            instance =  new Beats();
        }
        return instance;
    }
    
   public void setUpMidi(){
   
       try {
           
           sequencer = MidiSystem.getSequencer();
           sequencer.open();
           
           createNewSequence();
           
           track = sequence.createTrack();
           
           sequencer.setTempoInBPM(tempoBPM);
           
       } catch (Exception e) { e.printStackTrace();}
       
   }
   
   private void createNewSequence() {
        try {
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack(); // Create fresh track
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
   
   public MidiEvent makeEvent( int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        }catch(Exception e){e.printStackTrace();}
        
        return event;    
    }
   
   public void makeTracks(int key, int tick){
       track.add(makeEvent(144,currentChannel,key,100,tick));
       track.add(makeEvent(128,currentChannel,key,100,tick+1));
   }
   
   public void removeNote(int key, int tick) {
        removeEventsForNote(key, tick);
    }
   
   // Helper method to find and remove events
private void removeEventsForNote(int key, int tick) {
    List<MidiEvent> toRemove = new ArrayList<>();
    
    for (int i = 0; i < track.size(); i++) {
        MidiEvent event = track.get(i);
        if (event.getTick() == tick) {
            ShortMessage msg = (ShortMessage)event.getMessage();
            if (msg.getData1() == key) {  // Check if note matches
                toRemove.add(event);
            }
        }
    }
    
    toRemove.forEach(event -> track.remove(event));
}
   
   // Add this new method to handle channel changes
    public void setCurrentChannel(int channel) {
        this.currentChannel = channel;
        //resetSequence(); // Clear existing sequence when channel changes
    }
    
    public void resetSequence() {
        createNewSequence(); // Create fresh sequence and track
    }
   
   public void play() throws InvalidMidiDataException {
        sequencer.setSequence(sequence);
        sequencer.setTempoInBPM(tempoBPM);
        setLooping(true);
        sequencer.start();
        
    }
   
   public void setLooping(boolean shouldLoop) {
    if (sequencer != null) {
        // Loop the entire sequence
        sequencer.setLoopCount(shouldLoop ? Sequencer.LOOP_CONTINUOUSLY : 0);
        
        // Set loop points (start/end in ticks)
        sequencer.setLoopStartPoint(0);
        sequencer.setLoopEndPoint(sequence.getTickLength());
    }
}

    public void stop() {
        if (sequencer != null && sequencer.isRunning()) {
            sequencer.stop();
        }
    }

    public void close() {
        stop();
        if (sequencer != null && sequencer.isOpen()) {
            sequencer.close();
        }
    }

    public void setTempo(int bpm) {
        this.tempoBPM = bpm;
        if (sequencer != null && sequencer.isOpen()) {
            sequencer.setTempoInBPM(bpm);
        }
    }
    
    public void updateTempo(int value){
        
        int newTempo = 0;
        if (sequencer == null || !sequencer.isOpen()) return;
        
        newTempo = tempoBPM + value;
        
        if(newTempo != tempoBPM && newTempo > 0) setTempo(newTempo);
        
    }
}