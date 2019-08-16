import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class checkbox implements ItemListener{
	JButton check;
	JButton check1;
	JButton check2;
	JButton check3;
	JButton check4;
	JButton check5;
	JButton check6;
	JButton check7;
	JButton check8;
	JButton check9;
	void go(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		frame.setContentPane(panel);
		check = new JButton("goes to 11");
		check1 = new JButton("goes to 11");
		check2 = new JButton("goes to 11");
		check3 = new JButton("goes to 11");
		check4 = new JButton("goes to 11");
		check5 = new JButton("goes to 11");
		check6 = new JButton("goes to 11");
		check7 = new JButton("goes to 11");
		check8 = new JButton("goes to 11");
		check9 = new JButton("goes to 11");
		check.addItemListener(this);
		check.setSelected(true);
		panel.add(check);
		panel.add(check1);
		panel.add(check2);
		panel.add(check3);
		panel.add(check4);
		panel.add(check5);
		panel.add(check6);
		panel.add(check7);
		panel.add(check8);
		panel.add(check9);
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		frame.setBounds(400,100,100,100);
		frame.setVisible(true);
	}
	public void itemStateChanged(ItemEvent ev){
			if(check.isSelected()){
				System.out.println("Check box is selected");
			}
			else{
				System.out.println("Check box is not selected");
			}
	}
}
