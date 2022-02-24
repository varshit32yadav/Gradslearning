import java.util.Scanner;
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
		System.out.print("Enter age: ");
		age=sc.nextInt();
		if(age<21 || age>60)
			throw new InvalidAgeException();
	}
	
	public void display()
	{
		System.out.println(name+ " "+age + " "+salary+ " "+designation+"\n");
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

public class EmpMain2
{
	public static void main(String args[])
	{
		Emp s[]= new Emp[20];
		int i=0;
		boolean f=true;
		while(f)
		{
			try{
				
				Scanner sc=new Scanner(System.in);
				System.out.println("------------MAIN MENU-----------------");
				System.out.print(" 1. Create \n 2. Display \n 3. Raise Salary \n 4.Exit \n Enter your choice: ");
				int choice=getInput();
				
				if(choice>4)
					throw new InvalidChoiceException();
				switch(choice)
				{
					case 1:	
						boolean flag=true;
						while(flag)
						{
							try
							{
								System.out.println("-----------SUB MENU UNDER CREATE------------------");
								System.out.print(" 1. Clerk \n 2. Programmer \n 3. Manager \n 4.Exit \n Enter your choice: ");
								int ch=getInput();
								
								if(ch>4)
									throw new InvalidChoiceException();
								switch(ch)
								{
									case 1: s[i]= new Clerk();
										i++;
										break;
									case 2: s[i]= new Programmer();
										i++;
										break;
									case 3: s[i]= new Manager();
										i++;
										break;
									case 4: System.out.println("EXITING SUB MENU");
										flag=false;
								}
							}
							catch (InvalidAgeException e) 
							{
            							System.out.println("Invalid input: Please enter a value from 21-60 for age");
        						}
							catch (InputMismatchException e) 
							{
            							System.out.println("Invalid input: Please enter a valid value ");
        						}
							
							catch (InvalidChoiceException e) 
							{
            							System.out.println("Invalid Input: Please enter a value from 1 to 4 for choice.");
        						}
						}
						break; 
							

					case 2: System.out.println("Displaying details of all employees created");
						for(int j=0; j<i; j++)
						{
							s[j].display();
						}
						break;

					case 3:	System.out.println("Salary is raised. Enter choice 2 to view the changes");
						for(int j=0; j<i; j++)
						{
							s[j].raiseSalary();
						}
						break;
					case 4: System.out.println("Total no. of employees created: "+ i);
						f=false;
						break; 
				}
			}

			catch (InvalidChoiceException e) 
			{
            			System.out.println("Invalid Input: Please enter a value from 1 to 4 for choice.");
        		}
			
			catch (InputMismatchException e) 
			{
            			System.out.println("Invalid input: Please enter a valid value ");
        		}
			
		}

	}

	public static int getInput()
	{
		int ch=0;
		Scanner sc=new Scanner(System.in);
		try
		{
			ch=sc.nextInt();
			
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter a valid input");
		}
		return ch;
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
	
}