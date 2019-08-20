import java.io.*;

class writingTest{
	public static void main(String[] args){
		try{
			FileWriter writer = new FileWriter("meow.txt");
			writer.write("My cats need me,so do them");
			writer.close();
		}catch(Exception ex){
			
		}
	}
}
