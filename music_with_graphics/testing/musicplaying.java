import javax.sound.midi.*;

public class musicplaying{
	void play(int ofbit){
			try{
				
					Sequencer player = MidiSystem.getSequencer();
					player.open();
					
					Sequence seq = new Sequence(Sequence.PPQ,4);
					
					
					Track track = seq.createTrack();
					
					
					ShortMessage a = new ShortMessage();
					a.setMessage(144,1,44,100);
					MidiEvent noteon = new MidiEvent(a,1);
					track.add(noteon);
					ShortMessage b = new ShortMessage();
					b.setMessage(128,1,44,100);
					MidiEvent noteof = new MidiEvent(b,ofbit);
					track.add(noteof);
					a = new ShortMessage();
					a.setMessage(144,1,60,100);
					noteon = new MidiEvent(a,1);
					track.add(noteon);
					b = new ShortMessage();
					b.setMessage(128,1,60,100);
					noteof = new MidiEvent(b,ofbit);
					track.add(noteof);
					ShortMessage a2 = new ShortMessage();
					a2.setMessage(144,1,70,100);
					MidiEvent noteon1 = new MidiEvent(a2,ofbit);
					track.add(noteon1);
					ShortMessage b2 = new ShortMessage();
					b2.setMessage(128,1,70,100);
					MidiEvent noteof2 = new MidiEvent(b2,ofbit+21);
					track.add(noteof2);
					
					player.setSequence(seq);
					player.start();
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}
}
