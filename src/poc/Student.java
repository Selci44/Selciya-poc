package poc;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Student {
	public static void main(String[] args)throws SQLException{
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selciya", "root", "Selci@44");
			 Statement stmt = con.createStatement();
			// String sql = "CREATE TABLE Student " + "(studentid INTEGER not NULL, "
			//		 + " firstname VARCHAR(255)," + " lastname VARCHAR(255)," + " deptid INTEGER)";
	      
	      //   stmt.executeUpdate(sql);
	         System.out.println("Created");
			 
//             String sql = " ";
//		     stmt.executeUpdate("insert into  student values(8,'Ake','Amal',101)");
//		     stmt.executeUpdate("insert into  student values(9,'Abi','Anto',102)");
//		     stmt.executeUpdate("insert into  student values(10,'Ani','James',103)");
//		     stmt.executeUpdate("insert into  student values(11,'Shanu','Satrin',104)");
//		     stmt.executeUpdate("insert into  student values(12,'Ria','Lishna',105)");
//		     stmt.executeUpdate("insert into  student values(13,'Ria','Lishna',105)");
//    	     stmt.executeUpdate(sql);
             System.out.println("Inserted 5 records into the table");
             Statement st = con.createStatement();
             FileInputStream f = new FileInputStream("C:\\Users\\selciya.nayagam\\Downloads\\Jdbc-test\\src\\poc\\pocFile.txt");
             DataInputStream in = new DataInputStream(f);
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             String strLine;
             ArrayList list = new ArrayList();
             while ((strLine = br.readLine()) != null) {
                 list.add(strLine);
             }
             Iterator itr;
             for (itr = list.iterator(); itr.hasNext(); ) {
                 String str = itr.next().toString();
                 String[] spliting = str.split("\t");
                 String sid = "", fname = "", lname = "", deptID = " ";
                 for (int i = 0; i <= 5; i++) {
                     sid = spliting[0];
                     fname = spliting[1];
                     lname = spliting[2];
                     deptID = spliting[3];
     
                 }
                 ResultSet rsSet = null;
                 Statement Stmnt1 = con.createStatement();
                 rsSet = Stmnt1.executeQuery("select * from department");
                 while(rsSet.next()){
                     if(deptID.equals(rsSet.getString("deptname"))){
                         deptID=new String(rsSet.getString("deptid"));
                     }}
                 int k = Stmnt1.executeUpdate("insert into student(studentid, firstName, lastName, deptid) values('" + sid + "','" + fname + "','" + lname + "','" + deptID+"' )");
                 System.out.println("inserted "+fname+"into db");


         }
        }

		catch(Exception e){
			System.out.println(e);
		}
	}
}





