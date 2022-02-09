class A implements Runnable{
	public void run(){
		for(int i=0;i<=5;i++)System.out.println("from A thread "+i );
	}
}
class B{  //make this class as thread and execute its method that is static (as run()is non static)without extending Thread or implementnig Runnable
 
  B(){
  	for(int i=0;i<=5;i++)System.out.println("from B(constructor) Thread "+i );
  }
  public static void abc(){
  	for(int i=0;i<=5;i++)System.out.println("from B(abc) Thread "+i );
  } 
  public void xyz(){
  	for(int i=0;i<=5;i++)System.out.println("from B(xyz) Thread "+i );
  }   
}

public class Threads{
	public static void main(String[] args) {
		{ 
		   A r=new A();
		   Thread t=new Thread(r);
		   t.start();

           for(int i=0;i<=5;i++)System.out.println("main Thread "+i);
           
           //Method Reference:
           Thread t2=new Thread(B::abc);//This is called Method Referencing..(B::abc)
           t2.start();
           //internally thread class run() is going to have a refernce to abc() in B class
		   
		   Thread t3=new Thread( new B()::xyz);//if non static-method then create obj of the class and then do method Refernce
            t3.start();

            //Construcutor Refernce
            Thread t4=new Thread(B::new); //Runnable is now refering to the construcotr


		}
	}
}