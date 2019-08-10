import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class east implements ActionListener{
	JButton y;
	east(JButton b){
		y = b;
	}
	public void actionPerformed(ActionEvent event){
		y.setText("I am potential!!??");
	}	
}
