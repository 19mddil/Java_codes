import java.util.concurrent.TimeUnit;
class virsleeptest{
	public static void main(String[] args){
		for(;;){
			System.out.println("hello virus");
			try{
				TimeUnit.SECONDS.sleep(2);
			}catch(Exception ex){
				
			}
		}
	}
}
