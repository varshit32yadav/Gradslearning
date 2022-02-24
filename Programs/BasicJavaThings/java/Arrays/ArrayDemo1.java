public class ArrayDemo
{
	public static void main(String args[])
	{
		int arr[] = { 11, 22, 33, 44, 55 };

		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println("-----");

		for(int x : arr)
		{
			System.out.println(x);
		}
		System.out.println("=============");

		Student s[] = new Student[5];
		String names[] = { "Dinesh", "Suresh", "Ganesh", "Mahesh", "Ramesh" };

		for(int i=0; i<s.length; i++)
		{
			s[i] = new Student();
			s[i].name = names[i];
		}
		for(int i=0; i<s.length; i++)
			System.out.println(s[i].name);
		for(Student st : s)
			System.out.println("Name : "+st.name);
	}
}
class Student
{
	String name;
}
