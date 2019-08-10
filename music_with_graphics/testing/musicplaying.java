import javax.sound.midi.*;

public class musicplaying{
	void play(){
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
			MidiEvent noteof = new MidiEvent(a,16);
			track.add(noteof);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
