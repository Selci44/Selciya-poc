package poc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
public class ReadWrite {
	public static void main(String[] args) {
		try {
		//Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Selci@44";

		Connection myConn = null;


		Connection conn = DriverManager.getConnection(dbUrl, user, pass);
		ResultSet myRs = null;
		Statement Stmnt1 = conn.createStatement();
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



		int k = Stmnt1.executeUpdate("insert into studenttoday(studentid, firstName, lastName, Departmentid, JoiningDate,studentDob, MobileNumber, email) values('" + sid + "','" + fname + "','" + lname + "','" + deptID + "','" + joinDate + "','"+dob +"','"+phNo+"','"+email+"')");
		System.out.println(fname+" inserted into db");



		}
		}
		catch (Exception e) {
		System.out.println(e);
		}



		}

}



