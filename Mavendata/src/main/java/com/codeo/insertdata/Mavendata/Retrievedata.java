package com.codeo.insertdata.Mavendata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrievedata {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		boolean flag=false;
		
		String query="select*from hmanagment";
		
  //1 register the jdbc driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
 // 2. Established the connection
		
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
				
 // 3. Create statement object
	
	st=con.createStatement();//send&execute
	
 // 4.Execute the query
	if(st!=null) {
		rs=st.executeQuery(query);
	}
		
 //	5. select data 
	if(rs!=null) {
		
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getString(4)+""+rs.getString(5)+""+rs.getString(6)+"");
		}
	}
	
	if(flag==false) {
			System.out.println("record not retrieved");
	} 
	else {
				System.out.println(" record retrieved sucessfully");
			}
	}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        catch(Exception e) {
        	e.printStackTrace();
        }
		
		
		// 6.close jdbc object& connection
		finally {
			// close resultset object
			if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  if(st!=null) {
			  try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	 
	}
		
}	


