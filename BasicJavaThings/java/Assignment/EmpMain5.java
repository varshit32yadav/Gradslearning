//A seperate func called WriteToFile() should be created as a part of Emp. This must be called from Emp(). Change Emp() to Emp(String x, int y) and make according changes in the child classes 

import java.util.*;
import java.io.*;
import java.util.InputMismatchException;
class Emp
{
	String name;
	int age;
	float salary;
	String designation;

	Emp()
	{
		System.out.print("-----------------\n");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter name: ");
		name=sc.next();
		age= InvalidAgeException.getAge();
	}
	
	public void display()
	{

		//System.out.println(name+ " "+age + " "+salary+ " "+designation+"\n");
	}
	public void raiseSalary()
	{
		salary=salary+2000;
	}
}
class Clerk extends Emp
{
	Clerk()
	{
		super.salary=10000;
		super.designation="Clerk";
		
	}
} 
class Programmer extends Emp
{
	Programmer()
	{
		super.salary=30000;
		super.designation="Programmer";
		
	}
	public void raiseSalary()
	{
		salary=salary+5000;
	}
} 
class Manager extends Emp
{
	Manager()
	{
		super.salary=80000;
		super.designation="Manager";
		
	}
	public void raiseSalary()
	{
		salary=salary+10000;
	}
} 

public class EmpMain5
{
	public static void main(String args[])
	{
		//ArrayList<Emp> s= new ArrayList<Emp>();
		
		boolean fl=true;
		while(fl)
		{
			
				
				Scanner sc=new Scanner(System.in);
				System.out.println("------------MAIN MENU-----------------");
				System.out.print(" 1. Create \n 2. Display \n 3. Raise Salary \n 4.Exit \n Enter your choice: ");
				int choice=InvalidChoiceException.getChoice();
				
				switch(choice)
				{
					case 1:	
						boolean flag=true;
						while(flag)
						{
							
								System.out.println("-----------SUB MENU UNDER CREATE------------------");
								System.out.print(" 1. Clerk \n 2. Programmer \n 3. Manager \n 4.Exit \n Enter your choice: ");
								int ch= InvalidChoiceException.getChoice();
								
								switch(ch)
								{
									case 1: Emp e1= new Clerk();
										try	
										{
											PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv", true));
											pw.println(e1.name+","+e1.age+","+e1.salary+","+e1.designation);
											pw.flush();
											pw.close();
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
										break;
									case 2: Emp e2=new Programmer();
										try	
										{
											PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv", true));
											pw.println(e2.name+","+e2.age+","+e2.salary+","+e2.designation);
											pw.flush();
											pw.close();
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
										break;
									case 3: Emp e3= new Manager();
										try	
										{
											PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv", true));
											pw.println(e3.name+","+e3.age+","+e3.salary+","+e3.designation);
											pw.flush();
											pw.close();
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
										break;
									case 4: System.out.println("EXITING SUB MENU");
										flag=false;
								}
							
						}
						break; 
							
					
					case 2: 
						try
						{
							String fname="employees.csv";

							File f = new File(fname);

							if(f.exists())
							{
								BufferedReader fr = new BufferedReader(new FileReader(fname));
								String line = null;
								while( (line=fr.readLine()) != null )
								{
									System.out.println(line);
								}
								fr.close();
							}
							else
							{
								System.out.println("Sorry ! file doesn't exist");
							}
						}
						catch(Exception e)
						{		
							System.out.println(e);
						}
						break;
					/*
					case 3:	System.out.println("Salary is raised. Enter choice 2 to view the changes");
						Iterator<Emp> j=s.iterator();
						while(j.hasNext())
						{
							j.next().raiseSalary();
						}
						break;
					*/
					
					case 4: long count=0;
						try
						{
							String fname="employees.csv";

							File f = new File(fname);

							if(f.exists())
							{
								BufferedReader fr = new BufferedReader(new FileReader(fname));
								String line = null;
								while( (line=fr.readLine()) != null )
								{
									count++;
								}
								fr.close();
							}
							else
							{
								System.out.println("Sorry ! file doesn't exist");
							}
						}
						catch(Exception e)
						{		
							System.out.println(e);
						}
				
						System.out.println("Total no. of employees created: "+ count);
						
						fl=false;
						break; 
				}
			
			
		}

	}
	
}
class InvalidChoiceException extends RuntimeException
{
	InvalidChoiceException()
	{
	}
	InvalidChoiceException(String msg)
	{
		super(msg);
	}
	public static int getChoice()
	{
		int ch=0;
		Scanner sc=new Scanner(System.in);
		try
		{
			ch=sc.nextInt();
			if(ch<1 || ch>4)
				throw new InvalidChoiceException();
			
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter a valid input");
		}
		catch (InvalidChoiceException e) 
		{
            		System.out.println("Invalid Input: Please enter a value from 1 to 4 for choice.");
        	}
		return ch;
		
	}
	
}
class InvalidAgeException extends RuntimeException
{
	InvalidAgeException()
	{
	}
	InvalidAgeException(String msg)
	{
		super(msg);
	}
	public static int getAge()
	{
		int age;
		while(true)
		{
		try
		{
			
			System.out.print("Enter age: ");
			age=new Scanner(System.in).nextInt();
			if(age<21 || age>60)
				throw new InvalidAgeException();
			return age;
			
		}
		catch (InvalidAgeException e) 
		{
            		System.out.println("Invalid input: Please enter a value from 21-60 for age");
        	}
		catch (InputMismatchException e) 
		{
            		System.out.println("Invalid input: Please enter a valid value ");
        	}
		
		}					
		
	}
	
}