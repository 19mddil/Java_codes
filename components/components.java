import javax.swing.*;

class components{
	JFrame frame;
	void make(){
		int i;
		frame = new JFrame("a JFrame");
		frame.setSize(300,300);
		for(i=0;i<=600;i=i+100){
			
			frame.setLocation(i,i);
			frame.setVisible(true);
			try{
				Thread.sleep(100);
			}catch(Exception ex){
				
			}
		}
		
	}
}
