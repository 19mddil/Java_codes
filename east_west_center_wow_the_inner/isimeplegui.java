import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class isimplegui{
	JFrame frame;
	//JButton button;//south
	JLabel label;//west
	//JButton button1;//east
	//changing_clr_circle clr;
	
	
	void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Change Color");
		label = new JLabel("I am a label");
		JButton button1 = new JButton("see what happens at the other side");
		changing_clr_circle clr = new changing_clr_circle();
		
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);//south
		frame.getContentPane().add(BorderLayout.CENTER,clr);
		frame.getContentPane().add(BorderLayout.EAST,button1);//east
		frame.getContentPane().add(BorderLayout.WEST,label);//west
		frame.setSize(500,500);
		frame.setVisible(true);
		/*
		south s = new south(frame);
		east e = new east(label);
		*/
		button.addActionListener(new south());//different function ? not so do not need visible true here
		button1.addActionListener(new east());
		
	}
	class east implements ActionListener{// hummmmm.....no worry of passing to another class by construction function....
		public void actionPerformed(ActionEvent event){
			label.setText("I am potential!!??");
		}		
	}
	class south implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}
	
}
