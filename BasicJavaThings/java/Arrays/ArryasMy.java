import java.util.*;
public class ArryasMy{
   public static void main(String[] args) {
   	Student s[]=new Student[4];//(we have declared the array of objects if Student Class) just like->   //int ar[]=new int[9]; ar[0]=1;
   	//s[0].name="Raj";//null Pointer exception agya; kyoki object ni banay tumne arrya ka ;(-->ar[0] khali hai aut tum use access krna chah rhe ho ..pehle value to dalo usme bhai)
   	String arr[]={"Ram","Shyam","radhe","Lakhan"};
   	for(int i=0;i<arr.length;i++){
   		s[i]=new Student();
   		s[i].name=arr[i];
   	}
    for(Student st:s)System.out.println(st.name);
   }
}

class Student{
	String name;
}