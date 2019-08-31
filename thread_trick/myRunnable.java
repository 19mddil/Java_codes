class myRunnable implements Runnable{
	public void run(){
		go();
	}
	void go(){
		doMore();
	}
	void doMore(){
		System.out.println("top o' the stack");
	}
}
