
import java.awt.*;
import javax.swing.*;

public class adding_image extends JPanel{
	public void paintComponent(Graphics g) {
		Image image = new ImageIcon("green_eyes_cat.jpeg").getImage();
		g.drawImage(image, 0, 0, this);
	}
}
