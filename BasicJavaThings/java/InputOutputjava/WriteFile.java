import java.io.*;

public class WriteFile
{
	public static void main(String args[])
	{
		try	
		{
			//PrintWriter pw = new PrintWriter(System.out);
			PrintWriter pw = new PrintWriter(new FileOutputStream("abc.txt", true));
			pw.println(args[0]);
			pw.flush(); //to flush it out from buffer to the outout file.
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

/*

employees.csv
---------------
Sudhir,33,25000,Programmer
Manoj,22,10000,Clerk
Mamta,45,80000,Manager
*/