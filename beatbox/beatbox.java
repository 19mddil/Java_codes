import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;


class beatbox{
	
	String[] intervallist = {"1","2","3","4","5","6","7"};
	String[] overlappinglist = {"0","-1","-2","-3","-4","-5","-6","-7"};
	String[] musiclist = {
		"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
		"21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40",
		"41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60",
		"61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80",
		"81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100",
		"101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120",
		"121","122","123","124","125","126","127","128"
		};
	JList ilist;
	JList olist;
	JList mlist;
	
	int x = 1,y = 0,z=1;
	Sequencer player;//for using them in inner class
	Sequence sequence;//for using them in inner class
	Track track;
	JPanel gridPanel;
	JPanel listpanel1 = new JPanel();
	JPanel listpanel2 = new JPanel();
	JPanel listpanel3 = new JPanel();
	JFrame theFrame;
	ArrayList<JCheckBox> checkboxList;
	String[] instrumentNames = {
		"note1","note2","note3","note4","note5","note6","note7","note8","note9","note10","note11","note12","note13","note14","note15","note16"
	};
	int[] notes = {80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95};
	//int[] notes = {10,20,30,40,50,55,60,65,70,75,80,90,100,110,120,127};
	//String[] listEntries


	public void buildGui(){
		ilist = new JList(intervallist);
		olist = new JList(overlappinglist);
		mlist = new JList(musiclist);
		JScrollPane scroller = new JScrollPane(ilist);
		JScrollPane scroller1 = new JScrollPane(olist);
		JScrollPane scroller2 = new JScrollPane(mlist);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		listpanel1.add(scroller);
		listpanel2.add(scroller1);
		listpanel3.add(scroller2);
		
		ilist.setVisibleRowCount(1);
		ilist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ilist.addListSelectionListener(new MyilistListener());
		
		olist.setVisibleRowCount(1);
		olist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		olist.addListSelectionListener(new MyolistListener());
		
		mlist.setVisibleRowCount(10);
		mlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mlist.addListSelectionListener(new MymlistListener());
		
		theFrame = new JFrame("cyber beatbox");//creating a frame
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		BorderLayout layout = new BorderLayout();//setting a borderlayout object
		JPanel background = new JPanel(layout);// having a jpanel background with border layout
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		checkboxList = new ArrayList<JCheckBox>();// for saving references of checkboxes so we can use them later


		Box buttonBox = new Box(BoxLayout.Y_AXIS);// for rightside buttons
		buttonBox.add(listpanel1);
		buttonBox.add(listpanel2);
		buttonBox.add(listpanel3);
		
		
		JButton start = new JButton("start");
		start.addActionListener(new MystartListener());
		buttonBox.add(start);
		JButton stop = new JButton("stop");
		stop.addActionListener(new MystopListener());
		buttonBox.add(stop);
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyupTempoListener());
		buttonBox.add(upTempo);
		JButton downTempo = new JButton("Temp Down");
		downTempo.addActionListener(new MydownTempoListener());
		buttonBox.add(downTempo);
		JButton clear = new JButton("clear");
		clear.addActionListener(new MyclearListener());
		buttonBox.add(clear);

		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0;i<16;i++){
			nameBox.add(new Label(instrumentNames[i]));
		}

		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);
		theFrame.getContentPane().add(background);

		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(0);
		grid.setHgap(0);
		gridPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER,gridPanel);

		for(int i = 0;i< 256;i++){
			JCheckBox c = new JCheckBox();//finally we are creating a checkbox and adding to arraylist of same time
			c.setSelected(false);
			checkboxList.add(c);
			gridPanel.add(c);// now adding it to gui though saving the reference on a checkbox list....
		}

		setUpMidi();

		theFrame.setBounds(50,50,300,300);
		theFrame.pack();//need a testing here
		theFrame.setVisible(true);
	}

	void setUpMidi(){
		try{
			player = MidiSystem.getSequencer();
			player.open();
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			player.setTempoInBPM(120);
		}catch(Exception e){ e.printStackTrace(); }
	}


	void buildTrackAndStart(int mi,int interval1,int overlapping1){
		int[] trackList = null;

		sequence.deleteTrack(track);
		track = sequence.createTrack();

		for(int i=0;i<16;i++){// so note literally depends on it
			trackList = new int[16];///its for repetations
			for(int j=0;j<16;j++){
				JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
				if(jc.isSelected()){
					trackList[j] = notes[i];  // from i we get the notes
				}
				else{
					trackList[j] = 0;
				}
			}
			makeTracks(mi,trackList,interval1,overlapping1);//9 is the interval
		}
		/*
		trackList = new int[16];
		track.add(makeEvent(192,1,notes[i],0,i*16+1));
		for(int j = 0;j<16;j++){
			int note = notes[j];
			JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));//getting previously setted checkboxes row by row....as each row has 16 of it
			if(jc.isSelected()){
				trackList[j] = note;
			}
			else{
				trackList[j] = 0;
			}
		}
		makeTracks(trackList);
		*/

		try{
			player.setSequence(sequence);
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
			player.setTempoInBPM(120);
		}catch( Exception e) {e.printStackTrace();}
	}
	void makeTracks(int musicinstrument,int[] list,int interval,int overlapping){
		int j;
		int x;
		int temp=0;
		track.add(makeEvent(192,1,musicinstrument,0,1));
		for(int i= 0;i<16;i++){
			int note = list[i];
			if(i == 0){
				x = 0;
			}else{
				x = overlapping;
			}
			if(note != 0){// this helps to create a little intervals...
				
				temp = temp + 1 + x;
				System.out.print(temp+" "+"beat On");
				track.add(makeEvent(144,1,note,100,temp));
				temp += interval;
				System.out.println(temp+"beat off");
				track.add(makeEvent(128,1,note,100,temp));
			}
			temp = temp + 1 + x;//Nice thing to get....
			System.out.print(temp+" ");
			temp += interval;
			System.out.println(temp);
		}
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
	class MystartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
				System.out.println(x+" "+y);
				buildTrackAndStart(z,x,y);
		}
	}
	class MystopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			player.stop();
		}
	}
	class MyupTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			 float tempoFactor = player.getTempoFactor();
			 player.setTempoFactor((float)(tempoFactor * 1.03));

		}
	}
	class MydownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			 float tempoFactor = player.getTempoFactor();
             player.setTempoFactor((float)(tempoFactor * .97));
		}
	}
	class MyclearListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			int i;
			for(i=0;i<256;i++){
				JCheckBox jc = (JCheckBox) checkboxList.get(i);
				if(jc.isSelected()){
					jc.setSelected(false);
				}
			}
		}
	}
	class MyilistListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent lse){
			if(!lse.getValueIsAdjusting()){
				String sel = (String) ilist.getSelectedValue();
				x = Integer.parseInt(sel);	
			}
		}
	}
	class MyolistListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent lse){
			if(!lse.getValueIsAdjusting()){
				String sel = (String) olist.getSelectedValue();
				y = Integer.parseInt(sel);	
			}
		}
	}
	class MymlistListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent lse){
			if(!lse.getValueIsAdjusting()){
				String sel = (String) mlist.getSelectedValue();
				z = Integer.parseInt(sel);	
			}
		}
	}

}



