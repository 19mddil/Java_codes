import java.io.*;
class testing{
	public static void main(String[] args){
		try{
			FileOutputStream fs = new FileOutputStream("foo.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			box anotherbox = new box();
			anotherbox.width = 50;
			anotherbox.height = 50;
			os.writeObject(anotherbox);
			os.close();
		}catch(Exception ex){
			
		}
		
		
		box gettingbox= null;
		/*
		box gettingbox2= null;
		
		FileInputStream fs1;
		ObjectInputStream os1;
		try{
			fs1 = new FileInputStream("foo.ser");
			os1 = new ObjectInputStream(fs1);
			gettingbox1 = (box)os1.readObject();
			os1.close();
		}catch(Exception ex){ ex.printStackTrace(); }
		*/
		
		gettingbox = new decoding().decoded();
		
		System.out.println(gettingbox.width);
		System.out.println(gettingbox.height);
		
	}
}
