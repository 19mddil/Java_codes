class testing{
	public static void main(String[] args){
		myouter outer = new myouter();
		//myinner inner = new myinner(); ok I can not do it...!!! They must have a especial bond.
		myouter.myinner inner = outer.new myinner();
		inner.go();
	}
}
