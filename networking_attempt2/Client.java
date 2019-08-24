
import java.io.*;
import java.net.*;

class Client{
	void go(){
		try{
			Socket s = new Socket("127.0.1.1",4242);
			
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			
			String advice = reader.readLine();
			System.out.println("Today you should remember : "+ advice);
			
			reader.close();
			
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
