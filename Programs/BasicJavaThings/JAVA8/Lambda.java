@FunctionalInterface //to annotate that its a fun int
interface I{
	int add(int a,int b);
}
// class A implements I{
// 	public int add(int a,int b){
// 		System.out.println("Hi from A");
// 		return 0;
// 	}
// }
public class Lambda{
	public static void main(String[] args) {
	/*
	//three ways to access the implementation method of interface I
	//1)
		A a1=new A();
		a1.abc();//now you can create multiple onjects of class A and call abc() funvtion.Whicch is not secrue .
	
    //2)
       I i1=new I()//This is safer/secured then above one.
        {  //you are creating an obj of INterface I on the fly  [basically its an anonymous class which implements Interface I.as we dont know the name of the class ,so no on can create its object and use the logic of the interface.But its .class is creaetd fromtheor we can know its name.Hence nit proper safe.]
         	public void abc(){
         		System.out.println("From abc() method");
         	}

         }; //[Lambda$1.class is this anonymous class and is re-usable]
        i1.abc();//now dont have a seperate class to create its multiple objects and call abc()multiple times. 
	    //Now no one can create a seperate object out of it
	    I i2=new I(){
	    	public void abc(){
	    		System.out.println("Second time from anonnymous class");
	    	}
	    };
	    i2.abc();//it is called again...hence we can call the abc() method of the interface I as many time by creating multiple anonymous classes.
     
   
	//3 safest among all is use of Lambda Functions:
	    I i3=()->System.out.println("Hi from LAmbda function");
	    i3.abc();  //both the logic and the calling is on hte fly and no residual in the form of  .class file is created.
	    */

	    I i1=(a,b)->{
	    	(a+b);
	    }
	    int ans=i1.add(10,20);
	    System.out.println(ans);
     
	}
}