package poc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Department {
	public static void main(String[] args)throws SQLException{
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Selci@44");
			 Statement stmt = con.createStatement();
			 String sqli8 = "CREATE TABLE DEPARTMENT" + "(deptid INTEGER not NULL," + "deptname VARCHAR(99),"+ "PRIMARY KEY(deptid))";
	                   
			 stmt.executeUpdate(sqli8);
			 System.out.println("Department records inserted");
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
}
}
