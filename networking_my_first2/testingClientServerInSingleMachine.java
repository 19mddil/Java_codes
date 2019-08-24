import java.io.*;
import java.net.*;

class testingClientServerInSingleMachine{
	public static void main(String[] args){
		try{
			ServerSocket serverSock = new ServerSocket(5000);//making a server application to make a serverSocket on port 5000
			/**The upper line starts the server aplication on server to listen for clients in port 5000**/
			
			//making a client
			Socket chatSocket = new Socket("127.0.1.1",5000);//The ip given here is the machine I am running the code and 5000 is already activated on the serverSocket in this case my own machine...
			PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
			writer.println("message to send");
			
			
		}catch(Exception ex){
			
		}
		try{
			Socket chatSocket = new Socket("127.0.1.1",5000);
			InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
			BufferedReader reader = new BufferedReader(stream);
			String message = reader.readLine();
			System.out.println(message);
		}catch(Exception ex){
			
		}
		
		
		
	}
}
