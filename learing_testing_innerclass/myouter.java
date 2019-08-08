class myouter{
	private int x;
	
	void damn_outer_do_some_stuff(){
		myinner inner = new myinner();
		inner.go();
	}
	
	class myinner{
		void go(){
			x = 42;
			System.out.println(x);
		}
	}
}
