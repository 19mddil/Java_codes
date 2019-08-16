import javax.swing.*;
import java.awt.*;

class playing{
	void go(){
		JPanel p = new JPanel();
		p.setBackground(Color.gray);
		JFrame f = new JFrame("testing 1 2 3 4");
		JLabel l = new JLabel("Name:");
		JLabel m = new JLabel("Age:");
		f.setContentPane(p);
		f.setSize(300,300);
		JTextField field = new JTextField(20);
		JTextField field1 = new JTextField(20);
		p.add(l);
		p.add(field);
		//field.requestFocus();
		//field.setText("hey!");
		//field.selectAll();
		//System.out.println(field.getText());
		f.setVisible(true);
	}
}
