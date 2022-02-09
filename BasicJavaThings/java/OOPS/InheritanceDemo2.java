class A				
{
	void abc()
	{
		System.out.println("HI");
	}
}
class B extends A		
{
}
class C extends B
{
	void abc()
	{
		System.out.println("THANKS");
	}
}

public class InheritanceDemo2
{
	public static void main(String args[])
	{
		A a1 = new A();
		a1.abc();
		System.out.println("------------");
		B b1 = new B();
		b1.abc();
		System.out.println("------------");
		C c1 = new C();
		c1.abc();
	}
}