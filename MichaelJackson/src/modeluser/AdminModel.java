package modeluser;

import java.util.ArrayList;
import model.JDBCexecute;
	
public class AdminModel extends User {
	
	private String adminID;
	private JDBCexecute database;
	
	public AdminModel(String adminID){
		super();
		this.adminID = adminID;
		database = new JDBCexecute();
	}
	
	public String getAdminProfile(int choice) {
		try {
			return super.getUserProfile(adminID, choice);
		} catch (Exception e) {
			System.out.println("getAdminProfile fail");
		}
		
		return "";
	}
	
	public boolean setAdminProfile(String content, int choice) {
		try {
			return super.setUserProfile(content, adminID, choice);
		} catch (Exception e) {
			System.out.println("setAdminProfile fail");
		}
		
		return false;
	}
	
	// Admin can set other users' password
	public boolean setUserPassword(String userID, String newPassword) {
		try {
			//String query = ("UPDATE USER SET USER_ID = '" + newUserID + "' WHERE USER_ID = '"+ oldUserID +"';");
			return super.setUserPassword(userID, newPassword);
		} catch (Exception e) {
			System.out.println("setUserPassword fail");
		}
		
		return false;
	}
	
	// Admin can set other users' ID
	public boolean setUserID(String oldUserID, String newUserID) {
		try {
			String query = ("UPDATE USER SET USER_ID = '" + newUserID + "' WHERE USER_ID = '"+ oldUserID +"';");
			return super.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("setUserID fail");
		}
		
		return false;
	}
	
	
	/**
	 * 	1:USER_ID 	not null
	 *  2:USER_NAME not null
	 *  3:USER_PASS not null
	 *  4:USER_POS 
	 *  5:USER_DESC 
	 *  6:USER_GENDER
	 *  7:USER_CONTACT
	 *  8:USER_EMAIL
	 *  9:USER_TYPE not null
	 */
	public boolean addNewUser(String newUserID, String newUserPassword, String newUserType) {
		
		String query =("INSERT INTO USER " +
				       "VALUES('" +
				       newUserID + "', " +
				       "null, '" +
				       newUserPassword + "', " +
				       "null, null, null, null, null, '" +
				       newUserType + "');" );
		if(database.executeUpdate(query)) {
			System.out.println("addNewUser Success");
			return true;
		} else {
			System.out.println("addNewUser Fail");
			return false;
		}
	}
	
	public boolean deleteExistingUser(String userID) {
		
		String query = "DELETE FROM USER " +
                	   "WHERE USER_ID = '" + userID + "'";
	
		return super.executeUpdate(query);

	}
	public void getAllTrainerID(ArrayList<String> list) {
		
		String column = "USER_ID";
		String query = ("SELECT USER_ID FROM TRAINER; " );
		
		database.executeMultiRowQuery(query, column, list);
	}
	
	public void getAllTraineeID(ArrayList<String> list) {
		
		String column = "USER_ID";
		String query = ("SELECT USER_ID FROM TRAINEE; " );
		
		database.executeMultiRowQuery(query, column, list);
	}
	
	public String getUserName(String userID, int choice) throws Exception {
		
		String userDetails = "Fail To Get Name";
		String query = "";
		String column = "";

		// Query
		switch(choice) 
		{
			case 1:	
				query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ userID + "' " +
						"AND USER_TYPE = 'trainee';");
				column = "USER_NAME";
				break;
			case 2: 
				query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ userID + "' " +
						"AND USER_TYPE = 'trainer';");
				column = "USER_NAME";
				break;
			
			default:
				System.out.println("Invalid choice");
				return userDetails;
		}

		// Execute Query
		userDetails = database.executeQuery(query, column);
		return userDetails;
	}
	
	public String getLastUserID(int choice) throws Exception {
		
		// Query
		String lastID = "Fail to Obtain Result";
		String column = "USER_ID";
		String userType = "";
		
		switch (choice) {
			case 1: userType = "TRAINER";
					break;
			case 2: userType = "TRAINEE";
					break;
		}
		
		String query = ("SELECT USER_ID FROM " + userType +
				" ORDER BY USER_ID DESC LIMIT 1;" );
		System.out.println(query);
			
		String c = "COUNT(USER_ID)";
		String q = "SELECT COUNT(USER_ID) FROM " + userType + "; ";
		
		 
		int row = Integer.parseInt(database.executeQuery(q,c));
		if (row == 0) {	
			// if table is empty
			lastID = (choice < 2) ? "tnr00000" : "tne00000";
			System.out.println("table is empty, USER_ID reset");
		}
		else {
			// Execute Query
			lastID = database.executeQuery(query, column);
			System.out.println("getLastUserID executed");

		}
		// Extract result
		System.out.println("getLastUserID result: \n"
				+ "Last USER_ID: " + lastID); 
		return lastID;

	}
}
