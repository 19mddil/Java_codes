import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class simplegui{
	JFrame frame;
	JButton button;//south
	JButton label;//west
	JButton button1;//east
	changing_clr_circle clr;
	void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Change Color");
		label = new JButton();
		button1 = new JButton("see what happens at the other side");
		clr = new changing_clr_circle();
		
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);//south
		frame.getContentPane().add(BorderLayout.CENTER,clr);
		frame.getContentPane().add(BorderLayout.EAST,button1);//east
		frame.getContentPane().add(BorderLayout.WEST,label);//west
		frame.setSize(500,500);
		frame.setVisible(true);
		
		south s = new south(frame);
		east e = new east(label);
		
		button.addActionListener(s);//different function ? not so do not need visible true here
		button1.addActionListener(e);
	}
}
