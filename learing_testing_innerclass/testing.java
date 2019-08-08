class testing{
	public static void main(String[] args){
		myouter outer = new myouter();
		//myinner inner = new myinner();// ok I can not do it...!!! They must have a especial bond.Its possible only inside of its outter class
		myouter.myinner inner = outer.new myinner();
		
		
		//inuter.damn_outer_do_some_stuff();
		outer.stealling_his_wife();
		//outer.inner.x = 78;
		//outer.y = 100;
	}
}
