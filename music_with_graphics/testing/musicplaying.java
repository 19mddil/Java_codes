import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class musicplaying{
	JFrame f = new JFrame("Mymusic vedio");
	graphicalPresentation gp;
	MidiEvent getevent(int cmd,int channel,int note,int emphasis,int beat){
		MidiEvent onoff = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(cmd,channel,note,emphasis);
			onoff = new MidiEvent(a,beat);
		}catch(Exception ex){}
		return onoff;
	}
	void setupgui(){
		gp = new graphicalPresentation();
		f.setContentPane(gp);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
	void play(){
			try{
					setupgui();
					Sequencer player = MidiSystem.getSequencer();
					player.open();
					
					player.addControllerEventListener(gp,new int[] {127});
					
					Sequence seq = new Sequence(Sequence.PPQ,4);
					
					
					Track track = seq.createTrack();
					
					int notes = 0;
					for(int i = 0;i< 500;i += 4 ){///giving 4 here keeps the process slow coz beats are distinct
						notes = (int)(Math.random() * 127+ 1);
						track.add(getevent(144,1,notes,100,i));
						track.add(getevent(176,1,127,0,i));
						track.add(getevent(128,1,notes,100,i+2));
						track.add(getevent(144,1,notes,100,i));
						track.add(getevent(128,1,notes,100,i+2));
						track.add(getevent(144,1,notes,100,i));
						track.add(getevent(128,1,notes,100,i+2));
						track.add(getevent(144,1,notes,100,i));
						track.add(getevent(128,1,notes,100,i+2));
						track.add(getevent(144,1,notes,100,i));
						track.add(getevent(128,1,notes,100,i+2));
					}
					
					/*
					ShortMessage a = new ShortMessage();
					a.setMessage(144,1,70,100);
					MidiEvent noteon = new MidiEvent(a,1);
					track.add(noteon);
					ShortMessage b = new ShortMessage();
					b.setMessage(128,1,70,100);
					MidiEvent noteof = new MidiEvent(b,ofbit);
					track.add(noteof);
					
					a = new ShortMessage();
					a.setMessage(144,1,60,100);
					noteon = new MidiEvent(a,ofbit+1);
					track.add(noteon);
					b = new ShortMessage();
					b.setMessage(128,1,60,0);
					noteof = new MidiEvent(b,ofbit+1+ofbit);
					track.add(noteof);
					
					ShortMessage a2 = new ShortMessage();
					a2.setMessage(144,1,70,100);
					MidiEvent noteon1 = new MidiEvent(a2,ofbit*2+1+1);
					track.add(noteon1);
					ShortMessage b2 = new ShortMessage();
					b2.setMessage(128,1,70,100);
					MidiEvent noteof2 = new MidiEvent(b2,ofbit*3+2);
					track.add(noteof2);
					
					a = new ShortMessage();
					a.setMessage(144,1,60,100);
					noteon = new MidiEvent(a,ofbit*3+2+1);
					track.add(noteon);
					b = new ShortMessage();
					b.setMessage(128,1,60,0);
					noteof = new MidiEvent(b,ofbit*3+2+1+ofbit);
					track.add(noteof);
					*/
					
					player.setSequence(seq);
					player.setTempoInBPM(220);
					player.start();
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}
	/*
	class graphicalPresentation extends JPanel implements ControllerEventListener{
		boolean msg = false;
		public void paintComponent(Graphics g){
			if(msg){
					Graphics2D g2 = (Graphics2D) g;
					//g.setColor(Color.white);
					//g.fillRect(0,0,this.getWidth(),this.getHeight());
					int r = (int)(Math.random()*250);
					int gr = (int)(Math.random()*250);
					int b = (int)(Math.random()*250);
					
					g.setColor(new Color(r,gr,b));
					
					int h = (int)(Math.random()*490 +10);
					int w = (int)(Math.random()*490 +10);
					
					int x = (int) (Math.random()*40+10);
					int y = (int) (Math.random()*40+10);
					
					g.fillRect(x,y,h,w);

					msg = false;
			}
				
		}
		public void controlChange(ShortMessage event){
			msg = true;
			repaint();
		}
	}*/
}
