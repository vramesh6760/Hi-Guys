abstract class compute{
	abstract void calculate(double x);
}
class sub1 extends compute {
	void calculate(double x) {
		System.out.println("Square ="+x*x);
	}
}
class sub2 extends compute {
	void calculate(double x) {
		System.out.println("Square root ="+Math.round(Math.sqrt(x)*1000)/1000.0);
	}
}
class sub3 extends compute {
	void calculate(double x) {
		System.out.println("Cube ="+ x*x*x);
	}
}
class abstraclass {


	public static void main(String[] args) {
	 compute c,d,e;	 
     c=new sub1();
     c.calculate(2);
     d=new sub2();
     d.calculate(2);
     e=new sub3();
     e.calculate(2);
     
	}

}
