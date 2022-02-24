class A				
{   A(){ 
         this(4);
	System.out.println("A()");}
	A(int x){
		this("ss");
		System.out.println("A(int)");
	}
	A(String str)
	{   this();
		System.out.println("A(String)");
	}
}
class B extends A		
{	B()
	{   
		System.out.println("B()");
	}
	B(int x){

		System.out.println("B(int)");
	}
	B(String str)
	{
		this();
		System.out.println("B(String)");
	}
}
public class InheritanceDemo4
{	public static void main(String args[])
	{
		 // B b1 = new B();
		  System.out.println("--------------");
	      B b2=new B("as");

	}
}
// F:\JavaTraining\java\OOPS>java InheritanceDemo4
// A()
// B()
// A()
// B(int)
