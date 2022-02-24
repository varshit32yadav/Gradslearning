import java.io.*;
import java.sql.SQLException;

class A
{
	public void abc() throws ArithmeticException, NullPointerException, IOException, SQLException, UserException
	{
			int a = 50;
			for(int i=1; i<=20; i++)
			{
				System.out.println(i);
				int res = a/(a-i);
				if(i==150)
					throw new NullPointerException();
				if(i==120)
					throw new IOException();
				if(i==100)
					return;
				if(i==8)
					throw new ArrayIndexOutOfBoundsException();
				if(i==6)
					throw new SQLException();
				if(i==4)
					throw new UserException("Just for Demo");
			}
	}
	public void xyz() throws ArithmeticException, NullPointerException, IOException, SQLException, UserException
	{
		abc();
	}
	public void atoz() throws ArithmeticException, NullPointerException, IOException, SQLException, UserException
	{
		xyz();
	}
}
public class ExceptionDemo
{
	public static void main(String args[])
	{
		try
		{
			A a1 = new A();
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
		catch(UserException e)
		{
			System.out.println("User Defined exception handler.....");
			e.display();
			e.printStackTrace();
			System.out.println("Reason : "+e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Default exception handler");
		}
		finally
		{
			System.out.println("THANK YOU");
		}

		System.out.println("Program continues....");
	}
}
class UserException extends Exception
{
	UserException()
	{
	}
	UserException(String msg)
	{
		super(msg);
	}
	public void display()
	{
		System.out.println("From display() method of Custom exception class");
	}
}