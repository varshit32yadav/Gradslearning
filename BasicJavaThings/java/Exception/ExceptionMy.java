import java.io.*;
import java.sql.SQLException;
import java.util.*;
class A{
   public void abc()  throws ArithmeticException, NullPointerException, IOException, SQLException{  //these exceptions occured in abc() will be handled by its caller or so on..
      int a = 50;
         for(int i=1; i<=20; i++)
         {
            System.out.println(i);
            int res = a/(a-i);
            if(i==150)
               throw new NullPointerException();
            if(i==134)
               throw new IOException();
            if(i==100)
               return;
            if(i==8)
               throw new ArrayIndexOutOfBoundsException();
            if(i==6)
               throw new SQLException();
            if(i==2)
               throw new UserException("Created the Exception just for Demo"); 
         }
   }
   public void xyz() throws ArithmeticException, NullPointerException, IOException, SQLException{  //now it passes exception handle pas to atoz
      abc();
   } 
   public void atoz() throws ArithmeticException, NullPointerException, IOException, SQLException{  //now it throws all these exceptions  to main to handle all of them
      xyz();
   }
}
public class ExceptionMy{
   public static void main(String[] args) {//abc()-->xyz()-->atoz()-->main()-->JVM()-->terminates the program  :=>(passing the exception handling part to their callers).
     
     try {A a1=new A();
            a1.atoz();
         }
      catch(IOException e)
      {
         System.out.println("IO Exception occured....");
      }
      catch(NullPointerException e)
      {
         System.out.println("NULL Exception occured....");
      }
      catch(UserException e){
         e.display();
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
     
      catch(Exception e)
      {
         System.out.println("Default exception handler");//if all above catch are not able to handle any Exception then it will handle.
      }
      finally{
        System.out.println("thanks");
      }
      System.out.println("Program Continues....");
   }
}
class UserException extends RuntimeException{ //creating user Excdption of Unchecked Exception type as it extends RuntimeException
   UserException(){
   }
   UserException(String msg){
      super(msg);//calling the super class(RuntimeException)
   }
   void display(){
      System.out.println("From display() method of Custom exception class");
   }

}
/*
F:\JavaTraining\java\Exception>java ExceptionMy
1
2
From display() method of Custom exception class
Created the Exception just for Demo
UserException: Created the Exception just for Demo
        at A.abc(ExceptionMy.java:22)
        at A.xyz(ExceptionMy.java:26)
        at A.atoz(ExceptionMy.java:29)
        at ExceptionMy.main(ExceptionMy.java:36)
thanks
Program Continues....
*/