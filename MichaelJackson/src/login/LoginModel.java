package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.JDBCinfo;

public class LoginModel {
	
	// For database
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public LoginModel()
	{
		try {
			con = DriverManager.getConnection(url, serverName, serverPassword);
			st = con.createStatement();
			System.out.println("USER LOGIN: Connected to Database\n");
		} catch (SQLException e) {
			System.out.println("USER LOGIN: Fail to Connect Database\n");
		}
		
	}
	
	/****************************************
	 * Getter for login
	 ****************************************/
	public String getUserName(String userID) {
		
		String name = "";
		
		try {
			// Query
			String query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ userID +"';");
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserName query execution successful");
			
			// Extract result
			name = rs.getString("USER_NAME");
			System.out.println(userID + " USER_NAME: " + name 
					+ "\ngetUserName Success\n");
			
		} catch (SQLException e) {
			System.out.println("getUserName Fail");
		}
		
		return name;
	}
	

	public String getUserPassword(String userID) {
		
		String password = "";
		
		try {
			// Query
			String query = ("SELECT USER_PASS FROM USER WHERE USER_ID = '"+ userID +"';");
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserName query execution successful");
			
			// Extract result
			password = rs.getString("USER_PASS");
			System.out.println(userID + " USER_PASS: " + password
					+ "\ngetUserPassword Success\n");
			
		} catch (SQLException e) {
			System.out.println("getUserPassword Fail");
		}
		
		return password;
	}
	
	public String getUserType(String userID) {
		
		String type = "";
		
		try {
			// Query
			String query = ("SELECT USER_TYPE FROM USER WHERE USER_ID = '"+ userID +"';");
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserType query execution successful");
			
			// Extract result
			type = rs.getString("USER_TYPE");
			System.out.println(userID + " USER_TYPE: " + type
					+ "\ngetUserType Success\n");
			
		} catch (SQLException e) {
			System.out.println("getUserType Fail");
		}
		
		return type;
	}
	
	/****************************************
	 * Close Database (after log out)
	 ****************************************/
	public void closeDatabase() {
		
		try {
			// Close statement
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Login database closed");
	}

}
