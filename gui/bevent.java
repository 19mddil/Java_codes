import javax.swing.*;
import java.awt.event.*;     // the package which has ActionListener and ActionEvent in
public class bevent implements ActionListener{ //now bevent instances can use ActionListeners methods
	JButton button;//declaring a JButton reference
	
	public static void main(String[] args){//main function where the execution begins
		bevent gui = new bevent();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();///having a frame
		button = new JButton("click me");///having a button as JButtons instance(now ref has a obj)
		
		button.addActionListener(this);///calling JButtons method by its own instance passing the guis class
		
		frame.getContentPane().add(button);///adding a button to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);///setting frame size
		frame.setVisible(true);///setting frame visibility
	}
	
	public void actionPerformed(ActionEvent event){///if the class bevent listens catch the event!!!!
		button.setText("well,yes,I have been killed!");
	}
	
}
