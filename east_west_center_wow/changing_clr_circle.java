import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class changing_clr_circle extends JPanel{
	
	public void paintComponent(Graphics g){
		
		
		
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);
		Color rc = new Color(red,green,blue);
		g.setColor(rc);
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		red = (int) (Math.random()*255);
		green = (int) (Math.random()*255);
		blue = (int) (Math.random()*255);
		rc = new Color(red,green,blue);
		g.setColor(rc);
		g.fillOval(70, 70, 100, 100);
	}
}
