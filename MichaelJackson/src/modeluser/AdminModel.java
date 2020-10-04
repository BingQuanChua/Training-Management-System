package modeluser;


public class AdminModel extends User {
	
	private String adminID;
	
	public AdminModel(String adminID){
		super();
		this.adminID = adminID;
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
		
		return super.executeUpdate(query);
	}
	
	public boolean deleteExistingUser(String userID) {
		
		String query = "DELETE FROM USER " +
                	   "WHERE USER_ID = '" + userID + "'";
	
		return super.executeUpdate(query);

	}

}
