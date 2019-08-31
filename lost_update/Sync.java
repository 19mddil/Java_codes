class Sync implements Runnable{
	private int balance;
	public void run(){
		for(int i = 0;i<50;i++){
			synchronized(this){
				increment();
			}
		}
	}
	void increment(){
		System.out.println(Thread.currentThread().getName());
		int i = balance;
		System.out.println("balance is "+balance);
		balance = i+1;
		System.out.println("balance is "+balance);
	}
}
