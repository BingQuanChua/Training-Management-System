package modeluser;

import model.JDBCexecute;

public class User {

	private JDBCexecute database;
	
	/***************
	 * Constructor
	 **************/
	protected User()
	{
		database = new JDBCexecute();
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
	 * @return profileDetails // based on choice
	 * @throws Exception 
	 ****************************************/
	public String getUserProfile(String userID, int choice) throws Exception {
		
		String profileDetails = "Fail To Obtain Result";
		String query = "";
		String column = "";

		// Query
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
				return profileDetails;
		}

		
		// Execute Query
		profileDetails = database.executeQuery(query, column);

		return profileDetails;
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
		
		// Query
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
				query = ("UPDATE USER SET USER_GENDER = '" + content + "' WHERE USER_ID = '"+ userID +"';");
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
			
		if(database.executeUpdate(query)) {
			System.out.println("setUserProfile Successful");
			return true;
		} else {
			System.out.println("setUserProfile Fail");
			return false;
		}
	}
	
	
	/****************************************
	 * Setter Methods
	 * Only user can set his or her own password
	 * Only admin can change other users' password
	 * 
	 * @param userID
	 * @param newPass
	 * 
	 * @return boolean
	 ****************************************/
	protected boolean setUserPassword(String userID, String newPass) {
		
		// Query
		String query = ("UPDATE USER SET USER_PASS = '" + newPass + "' WHERE USER_ID = '"+ userID +"';");

		// Execute Query 
		if(database.executeUpdate(query)) {			
			System.out.println("setUserPassword Success");
			return true;
		} else {
			System.out.println("setUserPassword Fail");
		}
		
		
		
		return false;
	}
	
	/*******************
	 * Only for admin
	 ******************/
	protected boolean executeUpdate(String query) {

		// Execute Query 
		database.executeUpdate(query);			
		System.out.println("User executeUpdate Success");
		return true;

	}
	
	protected String executeQuery(String query, String column) {

		// Execute Query 
		String result = "Fail To Obtain Result";
		try {
			result = database.executeQuery(query, column);
			System.out.println("User executeUpdate Success");
			return result;
		} catch (Exception e) {
			System.out.println("User executeUpdate Fail");
		}	
		
		return "Fail To Obtain Result";
	}

}
