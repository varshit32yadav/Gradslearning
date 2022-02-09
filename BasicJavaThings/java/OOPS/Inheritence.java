class A{ 
	int x=10;
	int z=20;
	void abc(){
		System.out.println("Hi  from A");
	}
}
class B extends A{ 
	int z=70;
	void xyz(){
		//System.out.println(super.z+" "+ z);
		System.out.println("Hi  from B");
    }
}
class C extends B{
   int y=30;
   void xyz(){
   	System.out.println("Hi from C");
   }
}
public class Inheritence{
	public static void main(String[] args) {
		A a1=new A();
		System.out.println(a1.x);
		a1.abc();
		System.out.println("-------------");
		B b1=new B();
		System.out.println(b1.x);
		b1.abc();b1.xyz();
		System.out.println("-------------");
		C c1=new C();
		System.out.println(c1.x+" "+c1.z);//10 70
		c1.abc();
		c1.xyz();	
		System.out.println("-------------");
	}
}
