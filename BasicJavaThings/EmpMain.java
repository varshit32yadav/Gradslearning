import java.util.*;

class Emp
{
	String name;
	int age;
	int salary;
	String designation;

	public Emp()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter name : ");
		name = sc.next();
		System.out.print("Enter age : ");
		age = sc.nextInt();
	}		
	public void display()
	{
		System.out.println("\nName : "+name);
		System.out.println("Age : "+age);
		System.out.println("Salary : "+salary);
		System.out.println("Designation : "+designation);
	}
	public void raiseSalary()
	{
		salary += 2000;
	}
}
class Clerk extends Emp
{
	Clerk()
	{
		salary = 10000;
		designation = "CLERK";	
	}
}
class Programmer extends Emp
{
	Programmer()
	{
		salary = 30000;
		designation = "PROGRAMMER";	
	}
	public void raiseSalary()
	{
		salary += 5000;
	}
}
class Manager extends Emp
{
	Manager()
	{
		salary = 80000;
		designation = "MANAGER";	
	}
	public void raiseSalary()
	{
		salary += 10000;
	}
}

class EmpMain
{
	public static void main(String args[])
	{
		Emp e[] = new Emp[100];
		int ch1=0, ch2=0, count=0;
		
		do
		{
			System.out.println("-------------------");
			System.out.println("  1. Create  ");
			System.out.println("  2. Display  ");
			System.out.println("  3. Raise Salary  ");
			System.out.println("  4. Exit  ");
			System.out.println("-------------------");
			System.out.print("Enter choice : ");
			ch1 = new Scanner(System.in).nextInt();
			if(ch1==1)
			{
				do
				{
					System.out.println("-------------------");
					System.out.println("  1. Clerk  ");
					System.out.println("  2. Programmer  ");
					System.out.println("  3. Manager  ");
					System.out.println("  4. Exit  ");
					System.out.println("-------------------");
					System.out.print("Enter choice : ");
					ch2 = new Scanner(System.in).nextInt();
					switch(ch2)
					{
						case 1 : e[count++] = new Clerk();
							break;
						case 2 : e[count++] = new Programmer();
							break;
						case 3 : e[count++] = new Manager();
							break;
					}
				}while(ch2 != 4);
			}
			if(ch1==2)
			{
				for(int i=0; i<count; i++)
					e[i].display();
			}
			if(ch1==3)
			{
				for(int i=0; i<count; i++)
					e[i].raiseSalary();
			}
		}while(ch1 != 4);
		System.out.println("Total no. of employees created : "+count);
	}
}