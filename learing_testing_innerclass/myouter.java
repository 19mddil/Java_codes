class myouter{
	private int x;
	class myinner{
		void go(){
			x = 42;
			System.out.println(x);
		}
	}
}
