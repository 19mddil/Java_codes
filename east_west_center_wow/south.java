import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class south implements ActionListener{
	JFrame x;
	south(JFrame f){
		x = f;
	}
	public void actionPerformed(ActionEvent event){
		x.repaint();
	}
}
