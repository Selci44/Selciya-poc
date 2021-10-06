package poc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.io.*;
	public class Merge {
	static final String DB_URL = "jdbc:mysql://localhost:3306/selciya";
	static final String USER ="root";
	static final String PASS ="Selci@44";
	public static void main(String[] args)
	{
	try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt = conn.createStatement();
	) {
	Statement st = conn.createStatement();
	ResultSet res = st.executeQuery("select studentid, firstname, lastname,deptname\n" +
	"from student \n" +
	"join department \n" +
	"On student.deptid = Department.Deptid");
	System.out.println("studentid" + "	firstname " + "lastname" + "      depttname");
	while (res.next()) {
	String stuID = res.getString("studentid");
	String FirstName = res.getString("firstname");
	String LastName = res.getString("lastname");
	//String DepID = res.getString("DepID");
	String Department = res.getString("deptname");
	System.out.format(
	"%10s%10s%10s%10s\n",stuID, FirstName, LastName,Department);
	} // Step 7: Close the connection
	conn.close();
	} catch (SQLException throwables) {
	throwables.printStackTrace();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}




