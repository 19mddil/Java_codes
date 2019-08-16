import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class swingtest implements ActionListener{
	JTextArea text;
	void go(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Click it");
		button.addActionListener(this);
		
		
		text = new JTextArea(10,20);
		text.requestFocus();
		text.setLineWrap(true);
		text.selectAll();
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		
		frame.setSize(350,300);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ev){
		text.append("Button Clicked\n");
	}
}
