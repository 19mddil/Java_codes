class TestSync{
	public static void main(String[] args){
		Sync syncJob = new Sync();
		Thread a = new Thread(syncJob);
		Thread b = new Thread(syncJob);
		a.start();
		b.start();
	}
}
