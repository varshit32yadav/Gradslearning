interface I{//everything inside Interface is by default public

	//abstract void xyz();//without body	
	default void abc(){  //with body (Java8 addtiion)    default is a keyword not an access modifier
	System.out.println("I");
	}

}

interface J {
	default void abc(){
		System.out.println("J");
	}
	static void wxy(){
		System.out.println("Static method can be called wothout super Keyword");
	}
}

class A implements I,J{
	public void abc(){
		//when we inherit multiple interfaces with same methods.
		I.super.abc();//if more thn 1 intreface have the same default method then either call it like I.super.abc()
		System.out.println("Hi ffrom A class");//Or override it .
		J.super.abc();
		J.wxy();//Static method can be called wothout super Keyword
	}
}
public class DAY1{
	public static void main(String[] args) {
		A a=new A();
          a.abc();
	}
}