import javax.sound.midi.*;
public class music{
	public static void main(String[] args){
		int instrument = Integer.parseInt(args[0]);
		int note = Integer.parseInt(args[1]);
		music mini = new music();
		mini.play(instrument,note);
	}//close main

	public void play(int i,int n){
		try{
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ,4);

			Track track = seq.createTrack();
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192,1,i,0);
			MidiEvent changeinstrument = new MidiEvent(first,1);
			track.add(changeinstrument);

			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,n,100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,n,100);
			MidiEvent noteOff = new MidiEvent(b,48);
			track.add(noteOff);

			player.setSequence(seq);

			player.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}//close play
	}//close class
}
