class A				// Super, Base, Parent
{
	int x = 10;
	void abc()
	{
		System.out.println("HI");
	}
}
class B extends A		// Sub, Derived, Child
{
	int y = 20;
	void xyz()
	{
		System.out.println("HELLO");
	}
}
class C extends A
{
	int z = 30;
	void atoz()
	{
		System.out.println("THANKS");
	}
}

public class InheritanceDemo
{
	public static void main(String args[])
	{
		A a1 = new A();
		System.out.println(a1.x);
		a1.abc();

		System.out.println("------------");

		B b1 = new B();
		System.out.println(b1.x);
		System.out.println(b1.y);
		b1.abc();
		b1.xyz();

		System.out.println("------------");

		C c1 = new C();
		System.out.println(c1.x);
		System.out.println(c1.z);
		c1.abc();
		c1.atoz();
	}
}