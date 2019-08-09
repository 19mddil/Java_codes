import javax.swing.*;
import java.awt.*;
class simpleanime{
	int x=70;
	int y=70;
	class moving_circle extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
			g.setColor(Color.black);
			g.fillRect(x,y,40,40);
		}
	}
	void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		moving_circle mc = new moving_circle();
		
		frame.getContentPane().add(mc);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		int i;
		for(i=0;i<130;i++){
			x++;
			y++;
			mc.repaint();
			try{
				Thread.sleep(40);
			}catch(Exception ex){}
		}
		
	}
}
