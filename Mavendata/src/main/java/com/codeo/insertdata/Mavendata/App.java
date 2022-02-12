package com.codeo.insertdata.Mavendata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 //established connections
   	 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
          // statement 
   	 Statement st= con.createStatement();
   	 String query  = "INSERT INTO table_i (student_name, email_id, mobileno, addreass, rollno) values ('Mahi','mahi46@gmail.com','mahal','7878712539','06')";
   	 //execute the query
   	st.executeUpdate(query);
   	 st.close();
   	 con.close();
    }
}
