class myouter{
	public int x;
	myinner inner = new myinner();
	//myinner.myouter outer = inner.new myouter(); wrong too...
	void damn_outer_do_some_stuff(){
		//inner = new myinner();//// its actually like myouter outer = new outer(); myouter.myinner inner = outer.new myinner(); like they got a especial bond for both cases declaring inside of a outter class or from a main function of another testing class
		inner.go();
	}
	class myinner{
		int y;
		void go(){
			x = 42;
			System.out.println(x);
			stealling_his_wife();
		}
	}
	/*intended mistake so we can not do it!!!! vice versa in wrong...*/
	
	void stealling_his_wife(){
		inner.y = 12;
		System.out.println(inner.y);
		//inner.go();
	}
	
}
