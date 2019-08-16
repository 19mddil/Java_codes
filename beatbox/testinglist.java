import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

class testinglist{
	int[] notes = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	void go(){
		
      try {
		
         Sequencer player = MidiSystem.getSequencer();         
         player.open();
        
         Sequence seq = new Sequence(Sequence.PPQ, 4);         
         Track track = seq.createTrack();  
          
         MidiEvent event = null;
         int instrument;

         
         

         track.add(makeEvent(192,1,57,0,0));
         for(int i = 0;i<16;i++){
			 track.add(makeEvent(144,1,notes[i],100,i));
			 track.add(makeEvent(128,1,notes[i],100,i+1));
		 }
         player.setSequence(seq); 
         player.start();
         // new
	     Thread.sleep(5000);
	     player.close();
         System.exit(0);

      } catch (Exception ex) {ex.printStackTrace();}

	}
	
	MidiEvent makeEvent(int cmd,int channel,int note,int emphasis,int beat){
		MidiEvent onoff = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(cmd,channel,note,emphasis);
			onoff = new MidiEvent(a,beat);
		}catch(Exception ex){}
		return onoff;
	}
		
		
}

