import java.io.*;
import java.io.*;

public class IODemo
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter name : ");
		String name = br.readLine();

		System.out.print("Enter age : ");
		int age = Integer.parseInt(br.readLine());

		System.out.print("Enter address : ");
		String address = br.readLine();

		System.out.println("Enter mobile : ");
		long mobile = Integer.parseInt(br.readLine());

		System.out.println("Enter email : ");
		String email = br.readLine();

		System.out.println("----------------");

		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Address : "+address);
		System.out.println("Mobile : "+mobile);
		System.out.println("Email : "+email);
	}
}