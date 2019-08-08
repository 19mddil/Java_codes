class myouter{
	private int x;
	myinner inner = new myinner();
	
	void damn_outer_do_some_stuff(){
		inner.go();
	}
	
	class myinner{
		void go(){
			x = 42;
			System.out.println(x);
		}
	}
}
