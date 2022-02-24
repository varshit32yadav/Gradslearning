package academy.learnprograming;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static final String DB_NAME="testjava.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:E:\\JavaProgrsms\\testingdb\\"+DB_NAME;
    public static final String TABLE_CONTACTS="contacts";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection(CONNECTION_NAME);
//            Statement statement = conn.createStatement()) {TRY WITH RESOURCES(CLOSE AUTMATICALLY WHEN NOT NEEDED)
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //conn.setAutoCommit(false);//if it is false then all the statements are grouped intosingle transaction and final commit is done by conn.commit(); else every statement is treated as a single transaction
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text" +
                    ")");
            insertContact(statement, "tim",98,"tim@gmail.com");
            insertContact(statement, "Cook",12098,"Cook@gmail.com");
            insertContact(statement,"Pane",56798,"Pane@gmail.com");

//            statement.execute("select * from contacts");
//            ResultSet results=statement.getResultSet();  2nd way to print the query
            ResultSet results=statement.executeQuery("select * from "+TABLE_CONTACTS);
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " + results.getInt(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }
            results.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
