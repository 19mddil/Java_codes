package creating_gui;

import javax.swing.*;

public class windowing{
	static public void main(String[] args) {
		JFrame frame = new JFrame();//making a frame
		JButton button = new JButton("click me");//making a widget like buttons,text filed(aka form) etc
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*adding widget to the frame*/
		frame.getContentPane().add(button);//you don't add things directly to the frame
		/*Displaying it*/
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
