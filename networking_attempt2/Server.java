import java.io.*;
import java.net.*;

public class Server{
	String[] adviceList = {"abcde","fghij","klmnop","qrstv","uvwxy"};
	String getAdvice(){
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	void go(){
		try{
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true){
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println("sent "+advice+"as requested");
				
			}
		}catch(IOException ex){
			
		}
	}
}
