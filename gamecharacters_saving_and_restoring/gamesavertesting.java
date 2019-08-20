import java.io.*;

class gamesavertesting implements Serializable{
	
	public static void main(String[] args){
		
		
		gamechar abc = null;
		gamechar def = null;
		gamechar ghi = null;
		
		try{
			ObjectInputStream os = new ObjectInputStream(new FileInputStream("chargame.ser"));
			abc = (gamechar) os.readObject();
			def = (gamechar) os.readObject();
			ghi = (gamechar) os.readObject();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println(abc.power);
		System.out.println(abc.type);
		int i;
		for(i=0;i<abc.weapons.length;i++){
			System.out.print(abc.weapons[i]+' ');
		}
		System.out.println();
		System.out.println(def.power);
		System.out.println(def.type);
		for(i=0;i<def.weapons.length;i++){
			System.out.print(def.weapons[i]+' ');
		}
		System.out.println();
		
		System.out.println(ghi.power);
		System.out.println(ghi.type);
		for(i=0;i<def.weapons.length;i++){
			System.out.print(ghi.weapons[i]+' ');
		}
		System.out.println();
	}
	
	
	
}
