class RyanMonicaJob implements Runnable{
	
	BankAccount account = new BankAccount();
	
	public static void main(String[] args){
		RyanMonicaJob theJob = new RyanMonicaJob();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		one.setName("Ryan");
		two.setName("Monica");
		two.start();
		one.start();
	}
	private synchronized void makeWithdraw(int ammount){
		//System.out.println("ammount: "+ammount+" balance: "+account.balance);
		if(ammount <= account.balance){
			System.out.println(Thread.currentThread().getName()+" is about to withdraw money");
			try{
				System.out.println(Thread.currentThread().getName()+"is going to sleep anytime now");
				Thread.sleep(500);
			}catch(InterruptedException ex){
				
			}
			System.out.println(Thread.currentThread().getName()+" has woken up");
			account.withDraw(ammount);
			System.out.println(account.balance);
			System.out.println(Thread.currentThread().getName()+" has withdrawed money");
		}
	}
	public void run(){
		for(int i = 0;i<100;i++){
			makeWithdraw(10);
			if(account.balance < 0){
				System.out.println("overdrawn!");
			}
		}
	}
	
}
