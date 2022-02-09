class A				
{
	int x = 10;
	void abc()
	{
		System.out.println("HI");
	}
}
class B extends A		
{
	int x = 50;
	void abc()
	{   
		System.out.println("HELLO");
	}
	public void xyz()
	{
		System.out.println(super.x);
		System.out.println(this.x);
		this.abc();
		super.abc();
	}
}
class C extends B
{
	
}
public class InheritanceDemo3
{
	public static void main(String args[])
	{
		// B b1 = new B();
		// b1.xyz();
         C c1=new C();
         System.out.println(c1.x);
         c1.xyz();

	}
}