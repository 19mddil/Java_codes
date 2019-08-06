
import javax.swing.*; //swing components are event sources having a way to add listeners(classes that implements actionlisteners) by addactionlistener....
import java.awt.event.*;



public class another_listener_with_bad_intention implements ActionListener{
	public void actionPerformed(ActionEvent event) {///if the button that registers it clicks it will catch that event.. its a event handler method.And button calls it as soon as it got the event.
		/*
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame frame1 = new JFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		JFrame frame2 = new JFrame();
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mydrawing_panel b = new mydrawing_panel();
		adding_image c = new adding_image();
		color_circle d = new color_circle();
		
		
		frame2.getContentPane().add(d);
		frame2.setSize(500,331);
		frame2.setVisible(true);
		

		/*
		frame1.getContentPane().add(c);
		frame1.setSize(500,331);
		frame1.setVisible(true);
		
		frame.getContentPane().add(b);
		frame.setSize(300,300);
		frame.setVisible(true);
		*/
		
		/**
		 *need a frame method to co ordinate each new frames in different positions in the window 
		**/
	}
}
