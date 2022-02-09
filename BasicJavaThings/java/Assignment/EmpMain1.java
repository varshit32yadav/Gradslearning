import java.util.Scanner;
import java.io.*;

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

public class EmpMain1
{
	public void menu()
	{
		
		
	}
	public static void main(String args[])
	{
		Emp s[]= new Emp[20];
		int i=0;
		int choice,ch;
	try{
		do
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("------------MAIN MENU-----------------");
			System.out.println(" 1. Create \n 2. Display \n 3. Raise Salary \n 4.Exit \n Enter your choice: ");
			choice=sc.nextInt();
			

			switch(choice)
			{
				case 1:	
					do
					{
						System.out.println("-----------SUB MENU UNDER CREATE------------------");
						System.out.println(" 1. Clerk \n 2. Programmer \n 3. Manager \n 4.Exit \n Enter your choice: ");
						ch=sc.nextInt();
					
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
						}
					}while(ch!=4);
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
				
				
			}

			
		}
	}
		catch(IOException e)
		{
			System.out.println("Enter a number within the range [1,4]:");
			continue;
		}
		while(choice!=4);
		System.out.println("Total no. of employees created: "+ i);
		

	}
}