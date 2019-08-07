import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class simplegui implements ActionListener{
	JFrame frame;
	void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Change Color");
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		changing_clr_circle clr = new changing_clr_circle();
		frame.getContentPane().add(BorderLayout.CENTER,clr);
		button.addActionListener(this);//different function ? not so do not need visible true here
		
	}
	public void actionPerformed(ActionEvent event){
		/*
		// you can do this and this one is better
		changing_clr_circle clr = new changing_clr_circle();
		frame.getContentPane().add(BorderLayout.CENTER,clr);
		frame.setVisible(true);//if you don't do this ..Well...Allah saved me...again....s
		*/
		frame.repaint();
		
	}
}
