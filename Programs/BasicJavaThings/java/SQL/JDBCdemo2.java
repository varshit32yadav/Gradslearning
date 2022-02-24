import java.sql.*;
import java.io.*;
public class JDBCdemo2{
	public static void main(String[] args) {
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Pure java driver for Orcacle.
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
			PreparedStatement pstmt=con.prepareStatement("insert into Emp values(?,?)"); 
			System.out.println("Enter the name");//by this you can pass the values during runtime.
			String name=br.readLine();
			System.out.println("Enter the age");
			int age=Integer.parseInt(br.readLine());
			pstmt.setString(1,name);//replacing 1st? with name
			pstmt.setInt(2,age);//replacing 2nd? with age
			pstmt.execute();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
//Prepared statemnt you need to compile only once and you can run multiple times to execute your queries.
// Unlike normal Statement ,where you have to compile everytime you execute a new query