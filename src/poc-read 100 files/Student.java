package poc2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	public static void main(String[] args)throws SQLException{
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Selci@44");
			 Statement stmt = con.createStatement();
//			 String sql = "CREATE TABLE Student " + "(studentid INTEGER not NULL, "
//					 + " firstname VARCHAR(255)," + " lastname VARCHAR(255)," + " deptid INTEGER, " + "joiningDate date not NULL," + "studentDob date DEFAULT NULL," + "mobileNo bigint DEFAULT NULL," + "email VARCHAR(255) DEFAULT NULL)";
//	      
//	         stmt.executeUpdate(sql);
	         System.out.println("Created");
	         FileInputStream f = new FileInputStream("C:\\Users\\selciya.nayagam\\Desktop\\inputs.txt");
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
	 		String sid = "", fname = "", lname = "", deptID = "", joinDate = "", dob = "", phNo = "", email = "";
	 		for (int i = 0; i <= 8; i++) {
	 		sid = spliting[0];
	 		fname = spliting[1];
	 		lname = spliting[2];
	 		deptID = spliting[3];
	 		joinDate = spliting[4];
	 		dob = spliting[5];
	 		phNo = spliting[6];
	 		email = spliting[7];
	 		}
            ResultSet rset = null;
            Statement stmnt1 = con.createStatement();


	 		int k = stmnt1.executeUpdate("insert into student(studentid, firstName, lastName, deptid, joiningDate,studentDob, mobileNo, email) values('" + sid + "','" + fname + "','" + lname + "','" + deptID + "','" + joinDate + "','"+dob +"','"+phNo+"','"+email+"')");
	 		System.out.println(fname+" inserted into db");



	 		}
	 		}
	 		catch (Exception e) {
	 		System.out.println(e);
	 		}



	 		}

	 }


