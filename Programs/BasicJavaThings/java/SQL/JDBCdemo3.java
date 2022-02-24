import java.sql.*;
import java.io.*;
public class JDBCdemo3{
	public static void main(String[] args) {
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Pure java driver for Orcacle.
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
			//CallableStatement cstmt=con.prepareCall("CALL abc()"); 
			//CallableStatement cstmt=con.prepareCall("CALL ?"); 
			 CallableStatement cstmt=con.prepareCall("CALL "+args[0]); 
			//cstmt.setString(1,args[0]);
			cstmt.execute();
			cstmt.close();
			con.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}