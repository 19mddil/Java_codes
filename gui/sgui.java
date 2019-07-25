import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

class acwidget extends JPanel{
	public void paintComponent(Graphics g){
		//g.setColor(Color.orange);
		//g.fillRect(20,50,100,100);
		/*Image image = new ImageIcon("cat.jpg").getImage();
		g.drawImage(image,0,0,this);*/
		
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);
		
		Color randc = new Color(red,green,blue);
		g.setColor(randc);
		g.fillOval(70,70,100,100);
	}
}
public class  sgui implements ActionListener{
	JFrame frame,frame2;
	JButton button;
	public static void main(String[] args){
		sgui g = new sgui();
		g.go();
	}
	public void go(){
		frame = new JFrame();
		button = new JButton("click me to see a rectangle");
		button.addActionListener(this);
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);///setting frame size
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){///if the class bevent listens catch the event!!!!
		
		//frame.setVisible(false);
		//button.setText("well, not what I wanted");
		for(;;){
			acwidget w = new acwidget();
			w.repaint();
			frame2 = new JFrame();
			frame2.getContentPane().add(w);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setSize(300,300);
			frame2.setVisible(true);
			try{
				TimeUnit.SECONDS.sleep(10);
			}catch(Exception ex){
				
			}
		}
	}
}
