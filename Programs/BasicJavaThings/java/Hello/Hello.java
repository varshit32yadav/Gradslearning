// public class Hello{ //source code , which is to be converted into byte code. As we can't directly run source code
// 	public static void main(String[] args) {
// 		int a=9;
// 		System.out.println("Hello"+(9+a));

// 	}
// }
//-------------------------------------------------------
// class x{     more than one main methods can be there in the class
// 	public static void main(String[] args) {
// 		System.out.println("HI x");
// 	}
// }
// class y{
// 	public static void main(String[] args) {
// 		System.out.println("hi y");
// 	}
// }
// class z{
// 	public static void main(String[] args) {
// 		System.out.println("HI z");
// 	}
// }
//-------------------------------------------------------
// public class Hello{    default construcotr is always called if no constructor is there and is provided by compiler.
// 	int x;
// 	public void xyz(){}

// }  (javap Hello -will show you all the details of the .class file).
//------------------------------------------------------

/*
0)execution -> sourceCode(.java file)--------->ByteCOde(.class file)---->machine code
                                      compiler           interpreter
                                      (javac Hello.java)  (java Hello)

1)  more than one main methods can be there in the class.
2) javap Hello to see the .class file details
3) only one public class canbe there in the file. As if the class is declared public then it should match with the name of the file. And 2 classes can't match with one name of the file.
4)Its not neccessary to match the name of class woth the name of the file..until and unless the class is declared private.
5)Main method can be called after the program has started.
6)Class is not a collection of objects, its just a blueprint.
7)class- Noun
  method- VErb
  variable-entity
8)Compiler creates the default constructor.  
  ---------------------------------------------------------------------------------------
  */
 public class Hello{
 	public static void main(String[] args) {
 		System.out.println("Hello class");
 		x.main(args);//Main method can be called after the program has started.
 	}
 }
 /*public*/ class x{  //only one public class canbe there in the file
 	public static void main(String[] args) {
 		System.out.println("X class");
 		z.main(args);
 	}
 }
 class z{
 	public static void main(String[] args) {
 	System.out.println("Z class");
 	Hello.main(args);	
 	}
 }