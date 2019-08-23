import java.io.*;


class decoding{
		FileInputStream filestream;
		ObjectInputStream os;
		box temp = null;
	
		box decoded(){
			try{
				filestream = new FileInputStream("foo.ser");
				os = new ObjectInputStream(filestream);
				temp = (box)os.readObject();
				os.close();
			}catch(Exception ex){ ex.printStackTrace(); }
			return temp;
		}
	
}
