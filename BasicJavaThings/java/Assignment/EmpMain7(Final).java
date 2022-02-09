import java.util.*;
import java.io.*;
import java.sql.*;
class Emp{
	//declare only those variables , which are actual property of class.
   int emp_id;
   String name;
   int age;
   float salary;
   String designation;
  // Scanner sc=new Scanner(System.in);//it is not a property of employee class . It is an entity to read from keyboeard. So do not declare it as class property.Wherever the req. is ,create and use there.
  
    public Emp(float salary,String designation){
	     Scanner sc=new Scanner(System.in);//it should be declared here.
	     System.out.println("Enter Employee id");
	     this.emp_id=InvalidIDException.setEmpID();
	     System.out.println("Enter the name");	
	     this.name=sc.next();
	     this.age=InvalidAgeException.getAge(); //or (new InvalidAgeException()).getAge();sameThing(you can acess class property in anway)     
	     //dont write Exception logic in this CLass as it will be not OOP. It will be structured programming and lengthy code will be there.
	     this.salary=salary;
	     this.designation=designation;
	     this.WriteToDB();
	}

    public static void raiseSalary(){
	   	//Scanner sc=new Scanner(System.in);//declare it wherever it is required. 
	   	//System.out.println("Enter Salary to be raised for: "+this.name);
	    //   float sal=sc.nextFloat();
	    // if(this.designation.compareTo("Clerk")==0)  //wrong it is structured programming .
	   	//   this.salary+=2000;
	   	 //   public void raiseSalary(){  //this is object oriented programming. (Defauilt raise of every desig.) is inEmp[Method Overriding is used].
	     //     salary+=2000;
	    try{ 
	        Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
	        Statement stmt=con.createStatement();
	        stmt.executeUpdate("update employee set salary=salary+2000 where designation='Clerk'") ;
	        stmt.executeUpdate("update employee set salary=salary+5000 where designation='Programmer'") ;
	        stmt.executeUpdate("update employee set salary=salary+10000 where designation='Manager'") ;
	        stmt.close();
	        con.close();
		}catch(Exception ex){
		    System.out.println(ex.getMessage());
		}
    }
   
    public void WriteToDB(){//as reading and writing to the file should be done in Employee class .
	 	 try{
	 	 	   Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
         PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?)"); //you can do with normal statement also just remember to put the variables holding the values outside the quote(" ") [eg. ("+id,name,age,sa,de+"));]
         pstmt.setInt(1,this.emp_id);
         pstmt.setString(2,this.name);
         pstmt.setInt(3,this.age);
         pstmt.setFloat(4,this.salary);
         pstmt.setString(5,this.designation);
         pstmt.execute();
         pstmt.close();
         con.close();
	 	}catch(Exception e){
	 		System.out.println(e.getMessage());
	 	}

    }

    public static void deleteFromDB(){
	  	try{
	  	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  	  System.out.println("Enter the Employee id you want to remove");
	  	  int id = Integer.parseInt(br.readLine());
	  	  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
	      Statement stmt=con.createStatement();
	      //ResultSet res=stmt.executeQuery("select * from employee where emp_id=id");//this will not recognize id as it is a variable over here not some number,so comparison is not done[Second option is use prepared statement]
	      ResultSet res=stmt.executeQuery("select * from employee where emp_id="+id);
	      if(!res.next()){
               System.out.println("Sorry,Employee Id did not match with with the records");
               res.close();
               stmt.close();
               con.close();
               br.close();
               return;
            } 
	      else{
	      	    while(res.next()){
		        	System.out.println("Employee_id :"+res.getString(1));
		        	System.out.println("Name        :"+res.getString(2));
		        	System.out.println("Age         :"+res.getString(3));
		        	System.out.println("Salary      :"+res.getString(4));
		        	System.out.println("designation :"+res.getString(5));
	            }
	        }
	      res.close();
	      System.out.println("Are you sure, you want to delete this employee?  Yes or No ?");
	      String choice=br.readLine();
	      if(choice.equalsIgnoreCase("Yes")){
	      	stmt.executeUpdate("delete from employee where emp_id="+id);
	      	System.out.println("deletion successful");
	      }
	      else System.out.println("ok,deletion is cancelled");

	      stmt.close();
	      con.close();
	  	}catch(Exception e){
	  		System.out.println(e.getMessage());
	  	}

    }

    public static void display(){
	    try{
	        Class.forName("oracle.jdbc.driver.OracleDriver");
				  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
	        Statement stmt=con.createStatement();
	        ResultSet res=stmt.executeQuery("select * from employee order by emp_id ") ;
	        while(res.next()){
	        		System.out.println("Employee_id :"+res.getString(1));
	        		System.out.println("Name        :"+res.getString(2));
	        		System.out.println("Age         :"+res.getString(3));
	        		System.out.println("Salary      :"+res.getString(4));
	        		System.out.println("designation :"+res.getString(5));
	        		System.out.println();
	        }
	        res.close();
	        stmt.close();
	        con.close();
			}catch(Exception ex){
					  System.out.println(ex.getMessage());
			}
			System.out.println("---------------------------------------------");
    }
 
}
     

class Clerk extends Emp{
	Clerk(){
		// this.salary=10000;
		// this.designation="Clerk";
		 //OR
		//1st Emp Construcutor(Parent cons) and Then clerk(child const )is called and over here again we call Parent construcotr(super()) and set(slaary,designation) to it .
		super(10000,"Clerk");//we call the constructor of PArent class and pass age and designation to the Parent class cosntrucutor.
	}
  //implement raise salary here which will override raiseSalary() of Emp class  //first will be checked in child class if not present then will check in Parent class. 
}

class Programmer extends Emp{
	Programmer(){
    super(30000,"Programmer");
	}
}

class Manager extends Emp{
	Manager(){
		super(90000,"Manager");
	}
}

public class EmpMain7{
  
	public static void main(String[] args){
		//Emp e[]=new Emp[100];//size was fixes ..so if more than 100 employees are there then there would be problem.
		//ArrayList<Emp>e=new ArrayList<>();//now size is dynamic.jitna enter krnana hai krwa lo.[ALso generics <Emp> is used so now only objects of Emp class are allowed to be stored.
		Menu();
	}

		public static void Menu(){
		Scanner sc=new Scanner(System.in);
		System.out.println(" 1)Create \n 2)Display \n 3)raise Salary \n 4)Remove \n 5)Exit ");
		int choice=InvalidChoiceException.getChoice();
			switch(choice){

						case 1:
							System.out.println(" 1)Clerk \n 2)Programmer \n 3)Manager \n 4)Exit");
							int ch=InvalidChoiceException.getChoice();
							Emp e1;
						    switch(ch){	
						  	
							  case 1:
							  	e1=new Clerk();
							  	//e.add(e1);        //as soon object is created..clerk() cosntructor is called whoch will by default first will call its Parent class defualt const() then its own constructor to recieve inputs as provided in them
							    break;
							  case 2:
							  	e1=new Programmer();       
							  	break;
							  case 3:
							  	e1=new Manager();      
							    break;	
							  case 4:
							    break;     
						    }
						    Menu();
						    break;//breaks are important afetr Menu();as when calls are returned from stack thn nxt stmt is break, which make you out of Switch.

					    case 2:
					        Emp.display();                   //way to access other class property.
					        Menu();
							break;

						case 3:
							Emp.raiseSalary();
				            Menu();
							break;
						case 4:
							Emp.deleteFromDB();
				            Menu();
							break;	

						case 5:
				           totalEmployees();
				           return;  
			}
	    }
    public static void totalEmployees(){
	    int count=0;
	    try{ 
	        Class.forName("oracle.jdbc.driver.OracleDriver");
				  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
	        Statement stmt=con.createStatement();
	        ResultSet res=stmt.executeQuery("select * from employee") ;
	        while(res.next())count++;
	        res.close();
	        stmt.close();
	        con.close();
		}catch(Exception ex){
     		System.out.println(ex.getMessage());
		}
	    System.out.println("Total number of Employees are :"+count);
    }	
	 
}
class InvalidChoiceException extends RuntimeException //write Exception Logic in it else no use of creating the class.
{
		InvalidChoiceException()
		{
		}
		InvalidChoiceException(String msg)
		{
			super(msg);
		}
		public static int getChoice(){
	     while(true){
	     	Scanner sc=new Scanner(System.in);
	     	try{	
	     		System.out.println("Enter the Choice ");
	     		int choice=sc.nextInt();
	     		if(choice<1 || choice>5)throw new InvalidChoiceException(" bhai galat choice daal rahe ho \n");
	     		else return choice;
	      }
	      catch (InputMismatchException e){
	        System.out.println(":PLease enter the valid choice:\n");
	      }
	      catch (InvalidChoiceException e){
					    	System.out.println(":Please enter Choice with in the Menu: "+e.getMessage());
				}
	    }
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
		public static int getAge(){
			while(true){
	     	Scanner sc=new Scanner(System.in);
	     	try{	
	     		System.out.println("Enter the Age ");
	     		int age=sc.nextInt();
	     		if(age<21 ||age>60)throw new InvalidChoiceException(" bhai galat age daal rahe ho \n");
	     		else return age;
	      }
	      catch (InputMismatchException e){
	        System.out.println(":PLease enter the age in numbers:\n");
	      }
	      catch (InvalidChoiceException e){
					    	System.out.println(":Please enter the age between 21-60 : "+e.getMessage());
				}
	    }
		}
		
}

class InvalidIDException extends RuntimeException{
	InvalidIDException(){

	}
	InvalidIDException(String msg){
		super(msg);
	}
	public static int setEmpID(){
		while(true){
			 try{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String x=br.readLine();
				int l=x.length();
				int id=Integer.parseInt(x);
				if(l<0 || l>5)throw new InvalidIDException();
				else return id;
			}
			catch(InputMismatchException e){
				System.out.println("Please enter the id in numbers");
			}
			catch (InvalidIDException e){
				System.out.println("Please enter the id with in the range");
			}
			catch(Exception e){
	            System.out.println(e);
			} 	
		}
	}

}