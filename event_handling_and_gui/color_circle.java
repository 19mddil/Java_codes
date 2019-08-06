import java.awt.*;
import javax.swing.*;

public class color_circle extends JPanel{///a great way of customization!!!
	public void paintComponent(Graphics g) {
		
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