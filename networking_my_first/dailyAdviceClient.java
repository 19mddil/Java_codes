import java.io.*;
import java.net.*;
/*
System IP Address : 127.0.1.1
Public IP Address: 203.78.146.24
*/
class dailyAdviceClient{
	void go(){
		try{
			Socket s = new Socket("190.165.1.103",4242);
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			
			String advice = reader.readLine();
			System.out.println("Today you should: "+advice);
			reader.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
