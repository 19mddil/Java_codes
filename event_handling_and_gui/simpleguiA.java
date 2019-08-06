
import javax.swing.*; //swing components are event sources having a way to add listeners(classes that implements actionlisteners) by addactionlistener....
import java.awt.event.*;

public class simpleguiA implements ActionListener{

	JButton button1 = new JButton("hey I am one");
	JButton button2 = new JButton("hey I am two");
	
	void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(button1);
		//frame.getContentPane().add(button2);
		another_listener_with_bad_intention x = new another_listener_with_bad_intention();
		button1.addActionListener(x);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	void change_text() {
		button1.setText("well one has been clicked");
	}
	public void actionPerformed(ActionEvent event) {
		change_text();
	}
}
