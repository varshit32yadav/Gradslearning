public class MethodReference{
   public static void main(String[] args) {
   	I i1= Demo::new;//way of passing constructor of demo class as an argument
   	i1.getObject("ramesh");

   }
}

class Demo{
	public Demo(){
		System.out.println("Demo object is created...");
	}
	public Demo(String abc){
		System.out.println(abc);
	}
}
interface I{ //functional interface as only one method is there. and method ref is only for funtional interface.
	//public   Demo getObject(); OR
	public void getObject(String s); //only parameter matching is important 
}

/*layman way:
interface I is like Runnable interface
getObject is like  run() of Runnable
I i1=Demo::new  [means ]
run()[getObject] is pointning to [DEmo class construcutor]
so whenever getObject is called it is poitintg to the DEmo construcutor[ I i1=Demo::new]
*/