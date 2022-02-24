/*
Interface is used to achieve pure abstraction. all the variables in it are by default public static final. ALl the methods in it are by default public.
Client if only gviven the interface ,which only contains abstract Methods(empty body without any logic) with them and you will be having the class with all the logic part.Hence, Security issue is solved.
Client is unaware of the implementation part ,you only give the interface to the client (limited access clients can work on ).
*/
interface I{
	int x=50;
	void add();
	void sub();
}
interface J{
	int y=5;
	void mul();
	void div();
}
interface K extends I,J{

}
class Calculator implements K // or implements I,j same thing.
{
	
	public void add()
	{
		System.out.println(K.x + K.y);
	}
	public void sub()
	{
		System.out.println(I.x - J.y);
	}
	public void mul()
	{
		System.out.println(K.x * K.y);
	}
	public void div()
	{
		System.out.println(I.x / J.y);
	}
 
}
public class InterfaceMy{
	public static void main(String[] args) {
		//System.out.println(I.x+""+K.x+""+J.y+""+K.y); Interface variables are class variables(static variables)So they can be directly accessed without creating any object.
		Calculator c1=new Calculator();
        //c1.add();c1.sub();c1.mul();c1.div();//it will work but now your are letting client access all the mehtods of the class. Hence , not secure .
		
	    //secure thing is to give only inerface to client . For clients who only want to add and sub ,give them Interface I. For the CLients who wants to mul and div ,give them Interface J.
	    I i1=c1;//i1 is the interface variable pointing to the refence variable(which is pointing to the calculator class object).
	    J j1=c1;
	    i1.add();i1.sub();
	    j1.mul();j1.div();

	    System.out.println("======================== eg. of multiple inheritance by K interface");//
	    K k1=c1;
	    k1.add();k1.sub();
	    k1.mul();k1.div();

	}
}
