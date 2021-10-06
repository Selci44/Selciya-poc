package poc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Department {
	public static void main(String[] args)throws SQLException{
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selciya", "root", "Selci@44");
			 Statement stmt = con.createStatement();
			 //String sqli8 = "CREATE TABLE DEPARTMENT" + "(deptid INTEGER not NULL," + "deptname VARCHAR(99),"+ "PRIMARY KEY(deptid))";
	                   
		//	 stmt.executeUpdate(sqli8);
			 stmt.executeUpdate("insert into department values(101,'CSE')");
			 stmt.executeUpdate("insert into department values(102,'IT')");
			 stmt.executeUpdate("insert into department values(103,'ECE')"); 
			 stmt.executeUpdate("insert into department values(104,'CIVIL')");
		     stmt.executeUpdate("insert into department values(105,'EEE')"); 
			// stmt.executeUpdate(sqli8);		 
		     System.out.println("Department records inserted");
		//     ResultSet res = stmt.executeQuery("Select * From " + "students" + "Natural Join" + "department" );
		   //  Resultset res = null;
		    // System.out.println("id" + "firstName" + "lastName" + "age" );
		     //while(res.next()) {
		    	// System.out.print(res.getInt(1)+" "+res.getString(2));
		    		 
		    	 
        }
		    	 catch(Exception e) {
		    		 e.printStackTrace();
		    	 }
		     }
}
		  