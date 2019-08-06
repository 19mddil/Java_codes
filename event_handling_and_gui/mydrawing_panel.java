
import java.awt.*;
import javax.swing.*;

public class mydrawing_panel extends JPanel{///a great way of customization!!!
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(20, 50, 100, 100);
	}
}
