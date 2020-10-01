package model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class User {
	
	// For database
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private Connection con;
	private Statement st;
	private ResultSet rs;

	
	/****************************************
	 * Constructor
	 ****************************************/
	public User()
	{
		try {
			con = DriverManager.getConnection(url, serverName, serverPassword);
			st = con.createStatement();
			System.out.println("ADMIN: Connected to Database\n");
		} catch (SQLException e) {
			System.out.println("USER: Fail to Connect Database\n");
		}
		
	}

	/****************************************
	 * Getter Method
	 * 
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
	 * @throws Exception 
	 ****************************************/
	protected String getUserProfile(String userID, int choice) throws Exception {
		
		String profile = "";
		String query = "";
		String column = "";
		
		try {
			switch(choice) 
			{
				case 1:	
					query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_NAME";
					break;
				case 2: 
					query = ("SELECT USER_POS FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_POS";
					break;
				case 3: 
					query = ("SELECT USER_DESC FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_DESC";
					break;
				case 4: 
					query = ("SELECT USER_GENDER FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_GENDER";
					break;
				case 5: 
					query = ("SELECT USER_CONTACT FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_CONTACT";
					break;
				case 6: 
					query = ("SELECT USER_EMAIL FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_EMAIL";
					break;
				case 7: 
					query = ("SELECT USER_TYPE FROM USER WHERE USER_ID = '"+ userID +"';");
					column = "USER_TYPE";
					break;
				default:
					System.out.println("Invalid choice");
					throw new Exception();
			}
			
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getUserProfile query execution successful");
			
			// Extract result
			profile = rs.getString(column);
			System.out.println(userID + " " + column + ": " + profile 
					+ "\ngetUserpProfile Success\n");
		
			
		} catch (SQLException e) {
			System.out.println("getUserProfile Fail");
		}
		
		return profile;
	}
	
	
	
	/****************************************
	 * Setter Method
	 * Only user can set it's own details
	 *
	 * @param content
	 * @param userID
	 * @param choice
	 *  1:USER_NAME
	 *  2:USER_POS
	 *  3:USER_DESC
	 *  4:USER_GENDER
	 *  5:USER_CONTACT
	 *  6:USER_EMAIL
	 *  7:USER_TYPE //User cannot set type
	 *  
	 * @return boolean
	 * @throws Exception 
	 ****************************************/
	protected boolean setUserProfile(String content, String userID, int choice) throws Exception {

		String query = "";
		boolean valid = false;
		
		try {
			switch(choice) 
			{
				case 1:     //USER_NAME
					query = ("UPDATE USER SET USER_NAME = '" + content + "' WHERE USER_ID = '"+ userID +"';");
					break;
				case 2: 	//USER_POS"
					query = ("UPDATE USER SET USER_POS = '" + content + "' WHERE USER_ID = '"+ userID +"';");
					break;
				case 3: 	//USER_DESC
					query = ("UPDATE USER SET USER_DESC = '" + content + "' WHERE USER_ID = '"+ userID +"';");
					break;
				case 4: 	//USER_GENDER
					query = ("UPDATE USER SET USER_GENER = '" + content + "' WHERE USER_ID = '"+ userID +"';");
					break;
				case 5: 	//USER_CONTACT
					query = ("UPDATE USER SET USER_CONTACT = '" + content + "' WHERE USER_ID = '"+ userID +"';");
					break;
				case 6: 	//USER_EMAIL
					query = ("UPDATE USER SET USER_EMAIL = '" + content + "' WHERE USER_ID = '"+ userID +"';");
					break;
				default:
					System.out.println("Invalid choice");
					throw new Exception();
			}
			
			System.out.println(query);
			
			// Execute Query
			st.executeUpdate(query);
			System.out.println("setUserProfile query execution successful");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("setUserProfile Fail");
		}
		
		return false;
	}
	
	
	/****************************************
	 * Setter Methods
	 * Only user can set his or her own password
	 * Only admin can change other users' password
	 ****************************************/
	protected boolean setUserPassword(String userID, String newPass) {
		
		if(validatePasswrod(newPass)) {
		
			try {
				// Query
				String query = ("UPDATE USER SET USER_PASS = '" + newPass + "' WHERE USER_ID = '"+ userID +"';");
				System.out.println(query);
							
				// Execute Query 
				st.executeUpdate(query);			
				System.out.println("setUserPassword Success");
				return true;
					
			} catch (SQLException e) {
				System.out.println("setUserPassword Fail");
			}
		} else {
			System.out.println("Password length < 8");
		}
		
		return false;
	}
	
	/****************************************
	 * Only for admin
	 ****************************************/
	protected boolean setUserID(String oldUserID, String newUserID) {
		
		try {
			// Query
			String query = ("UPDATE USER SET USER_ID = '" + newUserID + "' WHERE USER_ID = '"+ oldUserID +"';");
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

	protected boolean executeQuery(String query) {
		
		try {
			// Query
			System.out.println(query);
						
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("Query Execution Success");
			return true;
				
		} catch (SQLException e) {
			System.out.println("Query Execution Fail");
		}
		
		return false;
	}
	
	
	/****************************************
	 * Setter verification
	 ****************************************/
	private boolean validateContent(String content) {
		
		if(content.length() > 1) {
			return true;
		}
		
		return false;
	}
	
	private boolean validateGender(String gender) {
		
		if(gender == "m" || gender == "f") {
			return true;
		}
		
		return false;
	}
	
	private boolean validatePasswrod(String password) {
		
		if(password.length() > 8) {
			return true;
		}
		
		return false;
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
		System.out.println("Database closed");
	}

}
