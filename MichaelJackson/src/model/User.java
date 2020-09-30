package model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class User {
	
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private String name;
	private String position;
	private String description;
	private String userID;
	private String password;
	
	public User()
	{
		try {
			con = DriverManager.getConnection(url, serverName, serverPassword);
			st = con.createStatement();
			System.out.println("USER: Connected to Database\n");
		} catch (SQLException e) {
			System.out.println("USER: Fail to Connect Database\n");
		}
		
	}
	
	public String getUserName(String UserID) {
		
		String name = "";
		
		try {
			// Query
			String query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ UserID +"';");
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserName query execution successful");
			
			// Extract result
			name = rs.getString("USER_NAME");
			System.out.println(UserID + " USER_NAME: " + name 
					+ "\ngetUserName Success\n");
			
		} catch (SQLException e) {
			System.out.println("getUserName Fail");
		}
		
		return name;
	}
	

	public String getUserPassword(String UserID) {
		
		String password = "";
		
		try {
			// Query
			String query = ("SELECT USER_PASS FROM USER WHERE USER_ID = '"+ UserID +"';");
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserName query execution successful");
			
			// Extract result
			password = rs.getString("USER_PASS");
			System.out.println(UserID + " USER_PASS: " + password
					+ "\ngetUserPassword Success\n");
			
		} catch (SQLException e) {
			System.out.println("getUserPassword Fail");
		}
		
		return password;
	}
	
	public String getUserType(String UserID) {
		
		String type = "";
		
		try {
			// Query
			String query = ("SELECT USER_TYPE FROM USER WHERE USER_ID = '"+ UserID +"';");
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserType query execution successful");
			
			// Extract result
			type = rs.getString("USER_TYPE");
			System.out.println(UserID + " USER_TYPE: " + position 
					+ "\ngetUserType Success\n");
			
		} catch (SQLException e) {
			System.out.println("getUserType Fail");
		}
		
		return type;
	}
	

	/**
	 * @param UserID
	 * @param choice
	 *  1:USER_NAME
	 *  2:USER_POS
	 *  3:USER_DESC
	 *  4:USER_GENDER
	 *  5:USER_CONTACT
	 *  6:USER_EMAIL
	 *  7:USER_TYPE
	 *  
	 * @return profile base on choice
	 */
	public String getUserProfile(String UserID, int choice) {
		
		String profile = "";
		String query = "";
		String column = "";
		
		try {
			switch(choice) 
			{
				case 1:	
					query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_NAME";
					break;
				case 2: 
					query = ("SELECT USER_POS FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_POS";
					break;
				case 3: 
					query = ("SELECT USER_DESC FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_DESC";
					break;
				case 4: 
					query = ("SELECT USER_GENDER FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_GENDER";
					break;
				case 5: 
					query = ("SELECT USER_CONTACT FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_CONTACT";
					break;
				case 6: 
					query = ("SELECT USER_EMAIL FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_EMAIL";
					break;
				case 7: 
					query = ("SELECT USER_TYPE FROM USER WHERE USER_ID = '"+ UserID +"';");
					column = "USER_TYPE";
					break;
			}
			
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserProfile query execution successful");
			
			// Extract result
			profile = rs.getString(column);
			System.out.println(UserID + " " + column + ": " + profile 
					+ "\ngetUserpProfile Success\n");
		
			
		} catch (SQLException e) {
			System.out.println("getUserProfile Fail");
		}
		
		return profile;
	}
	
	public boolean setName(String UserID, String newName) {
		
		try {
			// Query
			String query = ("UPDATE USER SET USER_NAME = '" + newName + "' WHERE USER_ID = '"+ UserID +"';");
			System.out.println(query);
			
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("setUserName Success");
			return true;
			
		} catch (SQLException e) {
			System.out.println("setUserName Fail");
		}
		
		return false;
	}
	
	public boolean setPosition(String newPosition) {
		
		
		return false;
	}
	
	public boolean setDescription(String newDescription) {
	
		
		return false;
	}
	
	public boolean setUserID(String newUserID) {
		
		
		return false;
	}
	
	public boolean setPassword(String UserID, String newPass) {
		
		try {
			// Query
			String query = ("UPDATE USER SET USER_PASS = '" + newPass + "' WHERE USER_ID = '"+ UserID +"';");
			System.out.println(query);
						
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("setUserPassword Success");
			return true;
				
		} catch (SQLException e) {
			System.out.println("setUserPassword Fail");
		}
		
		return false;
	}
	
	public void closeDatabase() {
		
		try {
			// Close statement
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Database closed");
	}

}
