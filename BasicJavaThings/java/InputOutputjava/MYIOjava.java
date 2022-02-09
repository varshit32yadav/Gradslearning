import java.io.*;
 public class MYIOjava{
 	public static void main(String[] args)  {
       

 	}
 }




// public class MYIOjava{
// 	public static void main(String[] args)  { //or throws Exception or use try/catch because IO is checked Exception ,compiler will force you to put Try catch block .
// 		try{
// 				 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				 
// 				  System.out.println("enter nmae");
// 				  String a=br.readLine();
// 				  System.out.println("age");
// 				  int b=Integer.parseInt(br.readLine());//by default bufferreader everything in terms of String so convert in Int.
// 				  System.out.println("number");
// 				  long c=Integer.parseInt(br.readLine());
// 				  System.out.println("address");
// 				  String add=br.readLine();
// 			}
// 		catch(Exception e){
// 			System.out.println("IO Exception");
// 		}	
		 
// 	}
// }
//----------------------------------------reading from the File.------------------------------------------
// try{
//  			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//  			System.out.println("Enter File name");
//  			String fname=br.readLine();
//  			File f1=new File(fname);
//  			if(f1.exists()){
//  				BufferedReader fr=new BufferedReader(new FileReader(f1));//you read from any source(keyboard,file,socket)..you should also read from buffer memory so that it is clear everytime for the new input read
//                 System.out.println(fr.readLine());
//                 String line="null";
//                 line=fr.readLine();
//                 while((line=fr.readLine())!=null){
//                 	System.out.println(line);

//                 }
//                 fr.close();//where you read the file close it there only.As the file must be allocating some resources ,so when you close the file.It will free the resources also.
//  			}
//  			else{
//  				System.out.println("File not found bhaiya");
//  			}
//  			br.close();//same reason.
//  		}
///-------------------------WRITING THE FILE-----------------------------------------------
 // try{
 //        	PrintWriter pr=new PrintWriter(new FileOutputStream("notesDay8.txt",true));//by default write Operation overwrites everything inside the file,So put (true)to append the file rather then overwriting everything from it.
        	
 //            for(int i=0;i<args.length;i++){
 //               pr.println(args[i]);
 //            }
 //        	pr.flush();//while writing any data,it is send to buffer. So flush the buffer then write.
 //        	pr.close();
 //        	BufferedReader fr=new BufferedReader(new FileReader("notesDay8.txt"));//you read from any source(keyboard,file,socket)..you should also read from buffer memory so that it is clear everytime for the new input read
                
 //                String line=null;
 //                 while((line=fr.readLine())!=null){
 //                 	System.out.println(line);
 //                   }
 //                fr.close();   
 //             }      
 // 		catch(Exception e){
 // 			System.out.println("IO Exception occured");
 // 		}
 //------------------------------------------------------------------