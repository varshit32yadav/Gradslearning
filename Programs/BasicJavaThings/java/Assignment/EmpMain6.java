import java.util.*;
import java.io.*;
class Emp{
	//declare only those variables , which are actual property of class.
   String name;
   int age;
   float salary;
   String designation;
  // Scanner sc=new Scanner(System.in);//it is not a property of employee class . It is an entity to read from keyboeard. So do not declare it as class property.Wherever the req. is ,create and use there.
  
  public Emp(float salary,String designation){
     Scanner sc=new Scanner(System.in);//it should be declared here.
     System.out.println("Enter the name");	
     this.name=sc.next();
     this.age=InvalidAgeException.getAge(); //or (new InvalidAgeException()).getAge();sameThing(you can acess class property in anway)     
     //dont write Exception logic in this CLass as it will be not OOP. It will be structured programming and lengthy code will be there.
	   this.salary=salary;
	   this.designation=designation;
	   this.WriteToFile();
	   }
	   public void raiseSalary(){
   	//Scanner sc=new Scanner(System.in);//declare it wherever it is required. 
   	//System.out.println("Enter Salary to be raised for: "+this.name);
    //   float sal=sc.nextFloat();
    // if(this.designation.compareTo("Clerk")==0)  //wrong it is structured programming .
   	//   this.salary+=2000;
   	 //   public void raiseSalary(){  //this is object oriented programming. (Defauilt raise of every desig.) is inEmp[Method Overriding is used].
     //     salary+=2000;
	   this.salary+=2000;
  } 
  public void WriteToFile(){//as reading and writing to the file should be done in Employee class .
	 	 try{
	 	 	  File f1=new File("details.csv");
	      PrintWriter pr=new PrintWriter(new FileOutputStream(f1,true)); //No nedd to check existance of the file while writing into it, if file not created then the file will get created and be wriiten.
			  pr.print(this.name+","+this.age+","+this.salary+","+this.designation);
	      pr.println();
	      pr.flush();
	      pr.close();
	 	}catch(Exception e){
	 		System.out.println(e.getMessage());
	 	}

  }
  public static void display(){
    try{
				File fname=new File("details.csv");
				if(fname.exists()){
	      	BufferedReader br=new BufferedReader(new FileReader(fname));
		   	  String line=null;
		   	  if(fname.length()==0){
		   	     	System.out.println("File is empty \n");
		   	    }
		   	  else{
		   	   	while((line=br.readLine())!=null ){
							StringTokenizer st = new StringTokenizer(line, ",");
							System.out.println("Name : "+st.nextToken());
							System.out.println("Age : "+st.nextToken());
							System.out.println("Salary : "+st.nextToken());
							System.out.println("Designation : "+st.nextToken());
							System.out.println();
		   	   	}
		   	  }
		   	  br.close();
	   	  }
	   	  else{
 			   System.out.println("File doesn't exist");
 		    }   
	   	  System.out.println("\n--------------------");	
		}catch(Exception ex){
				  System.out.println(ex.getMessage());
		}
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
	public void raiseSalary(){
     salary+=5000;
	}
}

class Manager extends Emp{
	Manager(){
		super(90000,"Manager");
	}
		public void raiseSalary(){ 
     salary+=10000;
	}
}

public class EmpMain{
  
	public static void main(String[] args){
		//Emp e[]=new Emp[100];//size was fixes ..so if more than 100 employees are there then there would be problem.
		//ArrayList<Emp>e=new ArrayList<>();//now size is dynamic.jitna enter krnana hai krwa lo.[ALso generics <Emp> is used so now only objects of Emp class are allowed to be stored.
		Menu();
	}

		public static void Menu(){
		Scanner sc=new Scanner(System.in);
		System.out.println(" 1)Create \n 2)Display \n 3)raise Salary \n 4)Exit ");
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
				      Emp.display();//way to access other class property.
				      Menu();
							break;

						case 3:
							System.out.println("case 3 is not working currently");
				      Menu();
							break;

						case 4:
				      totalEmployees();
				      return;  
			}
	  }
	public static void totalEmployees(){
	  	try{
	  		  File f=new File("details.csv");
				  BufferedReader br=new BufferedReader(new FileReader(f));
	   	    if(f.exists()){
	   	     String line=null;int c=0;
           while((line=br.readLine())!=null )c++;
           System.out.println("Number of Employees are: "+c);
	   	    }
	   	    else{
	   	    	System.out.println("File Not found");
	   	    }
	   	    br.close();
				  }catch(Exception ex){
				   	System.out.println(ex.getMessage());
				  }
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
	     		if(choice<1 || choice>4)throw new InvalidChoiceException(" bhai galat choice daal rahe ho \n");
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
