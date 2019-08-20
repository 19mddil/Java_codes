import java.io.*;

class gamechar implements Serializable{
	int power;
	String type;
	String[] weapons;
	
	gamechar(int p,String t, String[] w){
		power = p;
		type = t;
		weapons = w;
	}
}
