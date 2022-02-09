public class ArrayDemo
{
	public static void main(String[] args)
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

		System.out.println("==============");

		int md[][] = new int[5][];
		md[0] = new int[6];
		md[1] = new int[2];
		md[2] = new int[10];
		md[3] = new int[3];
		md[4] = new int[9];

		int ma[][] = new int[2][3];

		for(int i=0; i<md.length; i++)
		{
			for(int j=0; j<md[i].length; j++)
			{
				System.out.print(md[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------");

		for(String a : args)
		{
			System.out.println(a);
		}

		System.out.println("-----------");

		//int x[][], y[][], z[][];
		int[][] x, y, z;
	}
}
class Student
{
	String name;
}