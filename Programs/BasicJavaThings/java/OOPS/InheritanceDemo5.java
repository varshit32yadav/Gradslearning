//runtmie polymorphism
class A{
 	void abc(){
 		System.out.println("Hi from A");
 	}
}
class B extends A{
	void abc(){
		System.out.println("Hi from B");
	}
}

public class InheritanceDemo5{
	public static void main(String[] args) {
	    A a1=new B();//this onw works as B() will by default call the non-parameterized constructor of class A and hence all the properties of class will
	                 // be achieved.Then B() constructor is caleed then all the properties of the claass B will be acheieved.
	    
	  // B b1=new A();//does not works as b1 is the reference variable pointing to the object of class A.
	                 // So only A() is called. B() is never called .Hence  properties of class B will never be initialized.		
	    a1.abc();
		System.out.println();
	}
}