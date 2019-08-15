import javax.swing.*;
import java.awt.*;
class nested{
	JFrame frame = new JFrame();
	void make(){
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		panelB.add(new JButton("button 1"));
		panelB.add(new JButton("button 2"));
		panelB.add(new JButton("button 3"));
		panelA.add(panelB);
		panelA.setBackground(Color.darkGray);
		panelB.setBackground(Color.black);
		frame.getContentPane().add(panelA);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
