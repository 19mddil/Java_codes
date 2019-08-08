class myouter{
	private int x;
	myinner inner;
	void damn_outer_do_some_stuff(){
		inner = new myinner();//// its actually like myouter outer = new outer(); myouter.myinner inner = outer.new myinner(); like they got a especial bond for both cases declaring inside of a outter class or from a main function of another testing class
		inner.go();
	}
	
	class myinner{
		void go(){
			x = 42;
			System.out.println(x);
		}
	}
}
