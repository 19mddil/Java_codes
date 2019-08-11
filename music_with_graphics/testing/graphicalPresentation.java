import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;


class graphicalPresentation extends JPanel implements ControllerEventListener{
		boolean msg = false;
		public void paintComponent(Graphics g){
			if(msg){
					Graphics2D g2 = (Graphics2D) g;
					//g.setColor(Color.white);
					//g.fillRect(0,0,this.getWidth(),this.getHeight());
					int r = (int)(Math.random()*250);
					int gr = (int)(Math.random()*250);
					int b = (int)(Math.random()*250);
					
					g.setColor(new Color(r,gr,b));
					
					int h = (int)(Math.random()*490 +10);
					int w = (int)(Math.random()*490 +10);
					
					int x = (int) (Math.random()*40+10);
					int y = (int) (Math.random()*40+10);
					
					g.fillRect(x,y,h,w);

					msg = false;
			}
				
		}
		public void controlChange(ShortMessage event){
			msg = true;
			repaint();
		}
	}
