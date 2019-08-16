import javax.swing.*;
import java.awt.*;

class panel{
	void go(){
		JFrame frame = new JFrame();
		JPanel p = new JPanel();
		JPanel q = new JPanel();
		JButton b = new JButton("shock me");
		JButton c = new JButton("bliss");
		JButton d = new JButton("bliss");
		JButton e = new JButton("bliss");
		JButton f = new JButton("blissf");
		JButton g = new JButton("bliss");
		JButton h = new JButton("bliss");
		JButton i = new JButton("bliss");
		JButton j = new JButton("bliss");
		JButton k = new JButton("bliss");
		JButton l = new JButton("blisffa");
		p.setBackground(Color.darkGray);
		p.setLayout(new FlowLayout());
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		p.add(f);
		p.add(g);
		p.add(h);
		p.add(i);
		
		frame.getContentPane().add(BorderLayout.EAST,p);
		frame.setSize(250,200);
		frame.setVisible(true);
	}
}
