class myRunnable implements Runnable{
	public void run(){
		System.out.println("in Run");
		go();
	}
	void go(){
		System.out.println("in go");
		doMore();
	}
	void doMore(){
		System.out.println("in doMore");
	}
}
