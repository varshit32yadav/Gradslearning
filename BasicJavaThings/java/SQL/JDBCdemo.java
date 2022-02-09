import java.sql.*;
public class JDBCdemo{
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Pure java driver for Orcacle.
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
			Statement stmt=con.createStatement();
			
			//sending data from database to java application
			ResultSet rs=stmt.executeQuery("select * from Emp");
			while(rs.next()){
				
				System.out.println("Name "+rs.getString(1));//print column 1
				System.out.println("Age " +rs.getString(2));
				System.out.println();
		    }
		    rs.close();
		    

		    //sending data from java application to database

		    //stmt.executeUpdate("insert into Emp values('varshit',21)");
		    //stmt.executeUpdate("update Emp set age=age+1");
		    //
		    stmt.executeUpdate("delete Emp where name='varshit'");

		    stmt.close();
		    con.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}