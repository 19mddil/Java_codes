
class threadTester{
	public static void main(String[] args){
		Runnable threadJob;
		threadJob = new myRunnable(); //Things that start with a capital letter in java is class or interface
		Thread myThread = new Thread(threadJob);
		myThread.start();
		
		System.out.println("Back to Main");
	}
}
