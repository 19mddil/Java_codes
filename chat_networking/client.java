import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class client{
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go(){
		JFrame frame = new JFrame("Simple chat client");
		JPanel mainPanel = new JPanel();
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new sendButtonListener());
		
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetworking();
		
		frame.setSize(400,500);
		frame.setVisible(true);
		
	}
	
	void setUpNetworking(){
		try{
			sock = new Socket("127.0.1.1",5000);
			writer = new PrintWriter(sock.getOutputStream());
		}catch(Exception ex){
			
		}
	
	}
	
	
	public class sendButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			try{
				writer.println(outgoing.getText());
				writer.flush();
			}catch(Exception ex){
				
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	
	public static void main(String[] args){
		new client().go();
	}
	
}
