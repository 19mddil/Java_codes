import javax.swing.*;
import java.awt.*;

class components{
	void go(){
		JFrame frame = new JFrame();
		JButton button = new JButton("Click This!");
		JButton button1 = new JButton("Click This!");
		Font bigFont = new Font("serif",Font.BOLD,28);
		//button.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.NORTH,button);
		frame.getContentPane().add(BorderLayout.EAST,button);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
