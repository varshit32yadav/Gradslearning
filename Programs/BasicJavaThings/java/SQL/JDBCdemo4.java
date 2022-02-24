import java.sql.*;
public class JDBCdemo4{
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Pure java driver for Orcacle.
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger" ); //("url","usernmae","password");
			Statement stmt=con.createStatement();
			
			stmt.addBatch("insert into Emp values('utkarsh',21)"); //all the queries in the batch will execute at once .and if any exceptoion in between occured then none of the query from the batch will execute.
			stmt.addBatch("insert into Emp values('utkarsh',21)");
			stmt.addBatch("insert into Emp values('utkarsh',21)");
			stmt.addBatch("insert into Emp values('utkarsh',21)");
			//if(true)throw new Exception();if Exception occured then none of the query from the batch will execute.But Program will be compiled.
			stmt.addBatch("insert into Emp values('utkarsh',21)");

			stmt.executeBatch();
		    stmt.close();
		    con.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}//In Batch statement: [ all queries runs at once oe no query is run if some exception occured]. 
}