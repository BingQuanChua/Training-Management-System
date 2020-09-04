package comm;

import java.sql.*;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		String url = "";
		String userName = "root";
		String password = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		
	}
}
