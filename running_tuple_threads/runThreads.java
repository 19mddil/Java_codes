class runThreads implements Runnable{
	public static void main(String[] args){
		runThreads runner = new runThreads();
		Thread alpha = new Thread(runner);//look they passed single Runnable implementer class to multiple threads.......
		Thread beta = new Thread(runner);
		alpha.setName("Alpha_Thread");
		beta.setName("Beta_Thread");
		alpha.start();
		beta.start();
	}
	public void run(){
		for(int i = 0;i<25;i++){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+" is running");
		}
	}
}
