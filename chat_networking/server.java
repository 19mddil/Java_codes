import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class server{
	void go(){
		try{
			System.out.println("server");
			ServerSocket serverSock = new ServerSocket(5000);
			
			while(true){
				Socket sock = serverSock.accept();
				
				InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
				BufferedReader reader = new BufferedReader(streamReader);
				
				System.out.println(reader.readLine());
				
			}
		}catch(Exception ex){
			
		}
	}
	public static void main(String[] agrs){
		new server().go();
	}
}
